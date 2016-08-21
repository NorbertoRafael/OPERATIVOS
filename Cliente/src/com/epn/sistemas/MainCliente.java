package com.epn.sistemas;
public class MainCliente {

    public static ConetorCliente cliente; 
    
    public static void main(String[] args) {
        
        InterfazCliente Icliente = new InterfazCliente(); 
        Icliente.show();
      }
    public static void IniciarHilos(String ip){
        cliente = new ConetorCliente(ip); 
        cliente.start();
    }
    
}
