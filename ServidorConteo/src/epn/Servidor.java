package epn;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    
    private DataOutputStream salidaDatos;
    private InputStreamReader inputStream;
    private String flujo;
    private Socket miServicio;
    private String directorio;
    private String letra;
    private BufferedReader entrada;
    private ArrayList<String> lista;
    private static int num_con = 1;
    private static InterfazServidor interfaz=new InterfazServidor();
    private static String [] log = new String[3];
    public Servidor() {
         
         
    }
    
    
    public Servidor(Socket socket) throws IOException {
        this.miServicio = socket;
        num_con++;
       
    }

    public void recibirDatos() {
        
        StringTokenizer tokens = new StringTokenizer(flujo, "-");
        directorio = tokens.nextToken();
        letra = tokens.nextToken();
        EnviarConteo();
        
    }

    public void enviarDatos(String flujo) throws IOException {

        salidaDatos.writeUTF(flujo);
    

    }

    public void EnviarConteo() {			//Metodo que realiza los calculos pertinentes al conteo y extraccion de palabras

        lista = new <String>ArrayList();		//Arraylist para almacenar las palabras de resultado
        String resultado = "";				//variables auxiliares
        String recorre;
        String recorreAux[];
        String dirAux[];
        String line="";
        //int contador=0;
        boolean BAND = false;						//BAND se inicializa en falso
        
        try {
            directorio=directorio.trim();								//Se limpian los datos recibidos de cualquier carácter no deseado
            dirAux = directorio.split("[%|&|#|+|¡|!|¿|?|.|,|;|:|-|_|(|)|�|0|1|2|3|4|5|6|7|8|9|<|>]*");
                        directorio = "";

                        for (int i = 0; i < dirAux.length; i++) {

                            directorio+= dirAux[i];
                        }
            
            FileReader fichero = new FileReader("Libros/"+directorio+".txt");		//Se Abre el archivo del cual se va a contar las palabras
            BufferedReader s = new BufferedReader(fichero);				//Se inicializa el Buffer de lectura

            while ((line=s.readLine()) != null) {				//Mientras existas lineas en el archivo
                

                StringTokenizer tokens = new StringTokenizer(line, " ");	//Se separa la linea leída en palabras
                while (tokens.hasMoreTokens()) {
                    recorre = tokens.nextToken();
			//Si la palabra correspondiente al token actual empieza con la letra indicada por el cliente ya sea en mayuscula o minuscula
                    if (recorre.startsWith(letra) == true || recorre.startsWith(letra.toUpperCase()) == true || recorre.startsWith(letra.toLowerCase()) == true) { 
                        //contador++;
                        recorreAux = recorre.split("[»|%|&|#|+|¡|!|¿|?|.|,|;|:|-|_|(|)|�|0|1|2|3|4|5|6|7|8|9]*");  //Se toma la pabra y se limpia de signos de puntuacion                     recorre = "";

                        for (int i = 0; i < recorreAux.length; i++) {		//Se almacena la palabra libre de signos de puntuacion o caracteres no deseados

                            recorre += recorreAux[i];
                        }
                     //   if(!lista.contains(recorre))
                        lista.add(recorre);			//La palabra se añade al Arraylist de resultados
                        
                        BAND = true;			//BAND=TRUE si se ha encontrado al menos una palabra coincidente
                    }
                }

            }
            
            if (BAND == true) {							//Si BAND es TRUE
                Collections.sort(lista, new Comparator<String>() {		//Se envia a ordenar alfabeticamente
                    @Override
                    public int compare(String o1, String o2) {			//Se sobreescribe el metodo compare
                        o1 = java.text.Normalizer.normalize(o1, java.text.Normalizer.Form.NFD);		//para ignorar tildes, mayusculas y minusculas
                        o2 = java.text.Normalizer.normalize(o2, java.text.Normalizer.Form.NFD);
                        return o1.compareToIgnoreCase(o2);
                    }
                });

                for (int i = 0; i < lista.size(); i++) {
                    resultado += lista.get(i) + "\n";			//Se almacenan las palabras ya ordenadas en un String
                }
		//El string de resultado se envia al metodo enviarDatos junto con lista.size() que representa el numero de palabras encontradas
                enviarDatos(resultado+"\n\nNumero de palabras: "+lista.size()+"\n\n");		
            } else if (BAND == false) {		//Si no se han encontrado palabras que coincidan con la condicion se envia el aviso correspondiente						
                enviarDatos("No existen palabras que empiecen con la letra " + letra);
            }
            fichero.close();				//Se cierra el fichero
        } catch (Exception ex) {
            interfaz.setTextAvisos("Mensaje: " + ex.getMessage());
        } 
    }

    public void cerrarTodo() {									//Metodo para cerrar conexion
        try {
            salidaDatos.close();
           
            miServicio.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
     
         try {
            inputStream = new InputStreamReader(miServicio.getInputStream());			//Se inicializan las variables de entrada y salida de datos 
            entrada = new BufferedReader(inputStream);						//de la comunicacion 
             salidaDatos = new DataOutputStream(miServicio.getOutputStream());
             while (true) {
        								//Bucle infinito que mantiene la conexion mientras el cliente no se desconecte o deje de enviar datos
                flujo=entrada.readLine();				//Se recibe un flujo de datos provinientes del cliente
                recibirDatos();						//Se recibe el flujo como datos y se inicializa la tarea solicitada
                

            }
	} catch (Exception e) {
                        log[0]=""+miServicio;		//Se recupera los datos de la conexion en un array 
                        log[1]=""+new Date();		//Para luego ser mostrado en la interfaz
                        log[2]="Desconectado";		//En este punto el cliente se ha desconectado
            interfaz.setTablaLog(log);			//Se carga en interfaz el array
            System.out.println("Se ha desconectado:      "+miServicio+"     Hora: "+new Date());
            num_con--;					//El contador de conexiones concurrentes disminuye en 1 
        }

    }

    public static void main(String args[]) { 				//Se ejecuta el programa
        
       
        interfaz.setVisible(true);				//Se muestra la interfaz
        
        ServerSocket ss=null;					//Se crea un socket de tipo ServerSocket
        Socket socket=null;					//Se crea un socket
       
        interfaz.setTextAvisos("Inicializando servidor... ");				//Se muestra en la interfaz el estado del levantamiento del servidor
        
        try {
           ss =new ServerSocket(5555);						//Se inicializa el Serversocket para escuchar en el puerto 5555
            interfaz.setTextAvisos("Inicializando servidor... \t[OK]");			//Se muestra en la interfaz el estado del levantamiento del servidor si se ha levantado correctamente
            
            while (true) {					//Bucle infinito en el que el servidor estará escuchando para nuevas peticiones
                 socket = ss.accept();				//Si llega una solicitud se acepta

                if (num_con > 10) {				//Si el contador de conexiones simultaneas es mayor que cero
                    PrintStream pout = new PrintStream(socket.getOutputStream());		//Se envia un mensaje de alerta
                    pout.println("Servidor saturado intente luego");

                    socket.close();								//Y se cierra la conexion
                    continue;
                } else {
                    
                    
                        log[0]=""+socket;					//Se recupera los datos de la conexion en un array 
                        log[1]=""+new Date();					//para luego ser mostrado en una tabla de la interfaz
                        log[2]="Conectado";					//Se ha conectado un nuevo cliente
                    interfaz.setTablaLog(log);					//Se carga en la tabla de la interfaz la informacion de conexion
                    System.out.println("Nueva conexión entrante: " +log[0]+ "     Hora: " + log[1]);		//Se muestra en consola
                    ((Servidor) new Servidor(socket)).start();			//Se inicializa un nuevo hilo dedicado a la comunicaion con el cliente que lo ha solicitado
                }

            }
        } catch (IOException ex) {
            interfaz.setTextAvisos("Error con al levantar servicio");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
