
package epn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplicacion {

	public static void main(String[] args) {
	
	
        ServerSocket ss=null;
        Socket socket=null;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(5555,5);
            System.out.println("\t[OK]");
            while (true) {
                
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket+"     Hora: "+new Date());
               ((Servidor) new Servidor(socket)).start();
              
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ss.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger("Error al cerrar el servidor: " + ex.getMessage());
            }
		

	}
        }

}
