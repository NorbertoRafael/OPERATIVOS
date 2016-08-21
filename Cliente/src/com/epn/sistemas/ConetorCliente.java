package com.epn.sistemas;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class ConetorCliente extends Thread {

    private Socket sokett;                                                              //creamos un soket
    private InputStreamReader entradaSocket;                                            //creamos una variable para la conexion del soket
    private InputStream inputStream;                                                    
    private DataInputStream input;                                                      //creamos una variable para la entrada de datos
    private DataOutputStream salida;                                                    //creamos una variable para la salida de datos
    private BufferedReader entrada;                                                     

    final int puerto = 5555;                                                            //Escogemos el puerto para conectarnos

    public ConetorCliente(String ip) {                                                  //inGresamos como parametro la Ip       
        try {                                                                           //utilizamos try catch para verificar que la conexion sea exitosa y si hay un error nos muestre

            sokett = new Socket(ip, puerto);                                            //instanciamos el socket con la Ip y puerto 

            //incializacion de varaibles para la lectura de datos
            entradaSocket = new InputStreamReader(sokett.getInputStream());             //Guardamos la coneccion atraves del soket que se conecta al cliente
            entrada = new BufferedReader(entradaSocket);                                //guardamos los datos ingresados que se envian por el soket
            inputStream = sokett.getInputStream();
            input = new DataInputStream(inputStream);
            //inicializacion de variables de salida de datos para el envio de mensajes
            salida = new DataOutputStream(sokett.getOutputStream());                    //guardamos en una variable los datos ha ser enviados atraves del soket
            salida.writeUTF((""));

            JOptionPane.showMessageDialog(null, "La conexion a sido exitosa");          //Mostramos mensajes de verificacion

        } catch (Exception e) {
            System.out.println("Hay un error en clase ConectorCliente 1" + e);
        }

    }

    public void run() {

        String cadena1;

        while (true) {
            try {
                // cadena1 = entrada.readLine();
                cadena1 = input.readUTF();                          //lee la infromacion que se ha guardado en el buffer de entrada en el soket
                //son las palabras que devuelve en el servidor "bajo"
                InterfazCliente.textoCliente.setText(InterfazCliente.textoCliente.getText() + "\n" + cadena1);//colocamos en la inetrfaz lo que hace el usuario
            } catch (IOException e) {
                System.out.println("Hay un error en clase ConectorCliente 2" + e);                          //notificamos de los errores
            }
        }

    }

    public void MandaServidor(String cadena) {                  //este metodo nos permite enviar los datos atraves de soket
        try {
           
            this.salida = new DataOutputStream(sokett.getOutputStream());           //utilizamos las variables anteriormente explicadas para enviar la infromacion
            this.salida.writeUTF(cadena + "\n");                                    //asignamos a una variable que mande la peticion al servidor
            //manda todo el string Sofocles/Edipo Rey-b
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente 2" + e);      //Notificamos errores   
        }
    }

    public String LeerPB() {                                    //Este metodo nos permite leer lo que nos envia el servidor

        try {

            return entrada.readLine();                          //lee la linea entera de la infromacion que envia el servidor
        } catch (IOException e) {
            System.out.println("Hay un error en clase ConectorCliente 3" + e);
        }
        return null;
    }
}
