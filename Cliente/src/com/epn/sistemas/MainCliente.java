package com.epn.sistemas;
public class MainCliente {

    public static ConetorCliente cliente; 
    
    public static void main(String[] args) {
        
        InterfazCliente Icliente = new InterfazCliente();                       //instanciamos la clase interfaz
        Icliente.show();                                                        //Mostramos la interfaz(Jpanel)
      }
    public static void IniciarHilos(String ip){
        cliente = new ConetorCliente(ip);                                   //INTANCIAMOS un objeto de la clase cliente para utilizar el metodo strart o run
        cliente.start();
    }
    
}
