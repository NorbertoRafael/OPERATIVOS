package cliente;

import static cliente.MainCliente.DesCifrado13;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;


public class ConectorCliente extends Thread {

    private Socket s;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 123;

    public ConectorCliente(String ip) {
        try {

            s = new Socket(ip, puerto);

            //incializacion de varaibles para la lectura de datos
            entradaSocket = new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader(entradaSocket);

            //inicializacion de variables de salida de datos para el envio de mensajes
            salida = new DataOutputStream(s.getOutputStream());
            salida.writeUTF((""));
            JOptionPane.showMessageDialog(null, "LA CONEXION A SIDO EXITOSA CON EL SERVIDOR");

        } catch (Exception e) {
            System.out.println("Hay un error en clase ConectorCliente" + e);
        }

    }

    public void run() {

        String texto;

        while (true) {
            try {
                texto = entrada.readLine();
                System.out.println("Respuesta del servidor cifrado : " + texto);
                texto = DesCifrado13(texto);
                InterfazCliente.textoCliente.setText(InterfazCliente.textoCliente.getText() + "\n" + texto);
            } catch (IOException e) {
                System.out.println("Hay un error en clase ConectorCliente " + e);
            }
        }

    }

    public void MandaPeticionesServidor(String palabra) {
//METODO QUE MANDA LAS PETICIONES AL SERVIDOR 
        try {//PALABRA QUE MANDAMOS COMO PETICION
            this.salida = new DataOutputStream(s.getOutputStream());
            this.salida.writeUTF(palabra + "\n");
            System.err.println("Peticion cifrada :" + palabra);
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente " + e);
        }
    }

    public String RecibeRespuestaServidor() {
        //ESTE METODO RECIBE LOS SIGNIFICADOS
        try {
            return entrada.readLine();
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente" + e);
        }
        return null;
    }
}
