package com.epn.sistemas;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ConetorCliente extends Thread{

    private Socket sokett;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    
    final int puerto = 5555;

    public ConetorCliente(String ip) {
        try {

            sokett = new Socket(ip, puerto);

            //incializacion de varaibles para la lectura de datos
            entradaSocket = new InputStreamReader(sokett.getInputStream());
            entrada = new BufferedReader(entradaSocket);

            //inicializacion de variables de salida de datos para el envio de mensajes
            salida = new DataOutputStream(sokett.getOutputStream());
            salida.writeUTF((""));
           
            JOptionPane.showMessageDialog(null, "La conexion a sido exitosa");

        } catch (Exception e) {
            System.out.println("Hay un error en clase ConectorCliente 1" + e);
        }

    }

    public void run() {

        String cadena1;

        while (true) {
            try {
                cadena1 = entrada.readLine();
                //son las palabras que devuelve en el servidor "bajo"
                InterfazCliente.textoCliente.setText(InterfazCliente.textoCliente.getText() + "\n" + cadena1);
            } catch (IOException e) {
                System.out.println("Hay un error en clase ConectorCliente 2" + e);
            }
        }

    }

    public void MandaServidor(String cadena) {
        try {
            System.out.println(":D"+cadena);
            this.salida = new DataOutputStream(sokett.getOutputStream());
            this.salida.writeUTF(cadena + "\n");
            //manda todo el string Sofocles/Edipo Rey-b
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente 2" + e);
        }
    }

    public String LeerPB() {
     
        try {
            
            return entrada.readLine();
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente 3" + e);
        }
        return null;
    }
}
