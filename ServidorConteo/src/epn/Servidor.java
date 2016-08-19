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
    

    public Servidor(Socket socket) throws IOException {
        this.miServicio = socket;
        num_con++;
       
    }
//En esta seccion como su metodo indica se receptan los datos.
    public void recibirDatos() {
        
        StringTokenizer tokens = new StringTokenizer(flujo, "-");
        directorio = tokens.nextToken();
        letra = tokens.nextToken();
        EnviarConteo();
        
    }

    public void enviarDatos(String flujo) throws IOException {

        salidaDatos.writeUTF(flujo);
    

    }
//Numero de datos.
    public void EnviarConteo() {

        lista = new <String>ArrayList();
        String resultado = "";
        String recorre;
        String recorreAux[];
        String dirAux[];
        String line="";
        boolean BAND = false;
        
        try {
            directorio=directorio.trim();
            dirAux = directorio.split("[¡|!|¿|?|.|,|;|:|-|_|(|)|�|%|$|=]*");
                        directorio = "";

                        for (int i = 0; i < dirAux.length; i++) {

                            directorio+= dirAux[i];
                        }
            
            FileReader fichero = new FileReader("Libros/"+directorio+".txt");
            BufferedReader s = new BufferedReader(fichero);

            while ((line=s.readLine()) != null) {
                

                StringTokenizer tokens = new StringTokenizer(line, " ");
                while (tokens.hasMoreTokens()) {
                    recorre = tokens.nextToken();

                    if (recorre.startsWith(letra) == true || recorre.startsWith(letra.toUpperCase()) == true || recorre.startsWith(letra.toLowerCase()) == true) {

                        recorreAux = recorre.split("[¡|!|¿|?|.|,|;|:|-|_|(|)|�]*");
                        recorre = "";

                        for (int i = 0; i < recorreAux.length; i++) {

                            recorre += recorreAux[i];
                        }

                        lista.add(recorre);
                        BAND = true;
                    }
                }

            }
            
            if (BAND == true) {
                Collections.sort(lista, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        o1 = java.text.Normalizer.normalize(o1, java.text.Normalizer.Form.NFD);
                        o2 = java.text.Normalizer.normalize(o2, java.text.Normalizer.Form.NFD);
                        return o1.compareToIgnoreCase(o2);
                    }
                });

                for (int i = 0; i < lista.size(); i++) {
                    resultado += lista.get(i) + "\n";
                }

                enviarDatos(resultado+"\n\nNumero de palabras: "+lista.size()+"\n\n");
            } else if (BAND == false) {
                enviarDatos("No existen palabras que empiecen con la letra " + letra);
            }
            fichero.close();
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } 
    }

    public void cerrarTodo() {
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
            inputStream = new InputStreamReader(miServicio.getInputStream());
            entrada = new BufferedReader(inputStream);
             salidaDatos = new DataOutputStream(miServicio.getOutputStream());
             while (true) {
        //  System.out.println(":0");
                flujo=entrada.readLine();
                recibirDatos();
                

            }
	} catch (Exception e) {
            System.out.println("Se ha desconectado:      "+miServicio+"      Hora:   "+new Date());
            num_con--;
        }

    }

    public static void main(String[] args) {

        
        ServerSocket ss=null;
        Socket socket=null;
        System.out.print("Inicializando servidor... ");
        try {
           ss =new ServerSocket(5555);
            System.out.println("\t[OK]");
            
            while (true) {
                 socket = ss.accept();

                if (num_con > 5) {
                    PrintStream pout = new PrintStream(socket.getOutputStream());
                    pout.println("Servidor saturado intente luego");

                    socket.close();
                    continue;
                } else {
                    System.out.println("Nueva conexión entrante: " + socket + "     Hora: " + new Date());
                    ((Servidor) new Servidor(socket)).start();
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
