
package epn;

import java.io.* ;
import java.net.* ;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor  extends Thread {
    private ServerSocket socketServicio;
	
	private OutputStream outputStream;
	private java.io.InputStream inputStream; 
	private DataOutputStream salidaDatos;
	private DataInputStream entradaDatos;
	private String palabra;
        private String flujo;
	private Socket miServicio;
	private String directorio;
	private String letra;
	
	public Servidor(Socket socket) {
		 this.miServicio=socket;
	}

	public void recibirDatos() {
        try {
        	
            inputStream = miServicio.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            flujo=entradaDatos.readUTF();
            
            System.out.println("SERVIDOR RECIBE:");
            System.out.println(flujo);
            
            StringTokenizer tokens = new StringTokenizer(flujo,"-");
            directorio=tokens.nextToken();
            letra=tokens.nextToken();
            System.out.println(letra);
        } catch (IOException ex) {
        	System.out.println("Error ");
        }
    }
	
	public void enviarDatos(String flujo) throws IOException {
		
		outputStream = miServicio.getOutputStream();
        salidaDatos = new DataOutputStream(outputStream);
        salidaDatos.writeUTF(flujo);
        System.out.println("SERVIDOR ENVIA:");
        System.out.println(flujo);
       
    }
	
	
	
	public void EnviarConteo()
	{	
                String resultado="";
                String recorre;
		boolean BAND=false;
		File fichero = new File("Libros/"+directorio+".txt");
		Scanner s = null;
		try{
			
			s = new Scanner(fichero);

			while(s.hasNextLine()) {
				String line=s.nextLine();
				
				StringTokenizer tokens = new StringTokenizer(line," ");
                                while(tokens.hasMoreTokens()){
				recorre=tokens.nextToken();
                                System.out.println(recorre);
				if(recorre.startsWith(letra)==true){
                                        System.out.println(recorre);
                                        
					resultado+=recorre+"\n";
					BAND=true;
				}
                                }
				
			}
                        if(BAND==true){
                        enviarDatos(resultado);
                        }
                        else if (BAND==false){
				enviarDatos("No existen palabras que empiecen con esa letra");
			}
			} catch (Exception ex) {
				System.out.println("Mensaje: " + ex.getMessage());
			} finally {
				
				try {
					if (s != null)
						s.close();
				} catch (Exception ex2) {
					System.out.println("Mensaje 2: " + ex2.getMessage());
				}
			}
	}
	
	public void cerrarTodo() {
	    try {
	        salidaDatos.close();
	        entradaDatos.close();
	        socketServicio.close();
	        miServicio.close();
	 
	    } catch(IOException ex) {
	        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	
	@Override
    public void run() {
  
		recibirDatos();
        EnviarConteo();
     
    }
}
