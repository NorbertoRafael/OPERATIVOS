# OPERATIVOS

Andrango Norberto,
Mejia David,
Proaño Gonzalo,
Simbaña Sandy


# CONTADOR DE PALABRAS USANDO SOCKETS E HILOS
EL programa lo realizamos en lenguaje de programacion JAVA con IDE Netbeans.
Para la facilidad de la verificacion de la funcionalidad de nuestro proyecto se ha habilitado los ejecutables.
Donde primero se debe ejecutar el servidor para que el cliente se pueda conectar cabe señalar como nuestro programa se realizo en RED por ello la Ip ingresada en usuario debe ser la del servidor.

VENTAJAS

Nos permite realizar el conteo de las palabras que empiezen con la inicial que ingresemos.

Nos muestra los resultados claramente de forma intuitive.

DESVENTAJAS

Los libros deben estar en formato txt y por la cual es una limitacion para el analisis.

La obtencion de los libros en format txt es muy dificil de encontrar. 


PASOS PARA EJECUTAR EL SERVIDOR


solo abrir el ejecutable (El archivo en formato .JAR)

PASOS PARA EJECUTAR EL CLIENTE

1.abrir el ejecutable(.JAR)
2.Ingresar la ip del servidor y si el servidor se ejecuto en una misma maquina solo ingresar localhost
3.Escoger el Autor del libro que deseamos ha analisar
4.Posteriormente los libros de dicho autor escogido se habilitan.
5.Ingresamos la inicial de la palabra que deseamos buscar

FUNCIONALIDAD
El programa de conteo de palabras consiste en uno a maximo diez clientes que solicitan dicho servicio a un servidor.
El cliente y el servidor son programas independientes que se comunican entre si mediante sockets en una red.
Para ejecutar el programa del cliente primeramente debe estar levantado el servicio, es decir; el programa
del servidor debe estar en ejecucion y trabajando. 

PROGRAMA DEL CLIENTE

En el programa cliente se ingresa la ip o direccion del servidor que proporciona el servicio.
Una vez conectado mediante un puerto especifico el cliente es capaz de solicitar la busqueda 
en un libro de todas las palabras que comiencen con una letra indicada y contarlas.
Una vez enviados los datos, la peticion es procesada por el servidor y devuelve un resultado, el cual está compuesto
por una lista de todas las palabras encontradas y el numero de palabras encontradas.
El cliente podrá seguir enviando peticiones bajo la misma conexion hasta que este la termine.

PROGRAMA DEL SERVIDOR

Una vez ejecutado el programa servidor, el servicio se levata y escucha a travez de un puerto especifico, 
a la espera de una nueva solicitud o solicitudes por parte de clientes.
Una vez aceptada la solicitud se mostrara en la interfaz las conexiones con hora y fecha,
el programa servidor creara un hilo dedicado a este cliente y procesará la peticion realizando los calculos correspondientes 
internamente, devolviendo un resultado. Una vez terminada la peticion el servidor sigue a la escucha de una nueva peticion de
este cliente hasta que se cierre la conexion. 
El servidor en todo momento permanece escuchando por nuevas solicitudes de conexion por parte de clientes.
Al desconectarse un cliente los datos se mostraran en la interfaz correpondientemente.
El numero máximo de conexiones concurrentes permitidas por el software es de diez, una vez sobrepasado este limite
el servidor cerrara las conexiones consecuentes, hasta que uno o más usuarios se desconecten y existan conexiones disponibles.
