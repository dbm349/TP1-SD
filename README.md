# TPS-SD
Trabajos prácticos de Sistemas Distribuidos

# Pasos para importar el proyecto 

1. Ingresar al repositorio de Github con el link dado y descargar archivo .zip

2. Descomprimir el archivo recientemente descargado.

3. Importar el proyecto en eclipse.(File> Import> Maven> Existing Maven Projects> Next> Browse> Practico1> Finish).


# Pasos para la ejecución de los ejercicios

# Punto 1 al 4
1. Correr la clase Servidor.java
2. Correr la clase Cliente.java

# Punto 5
1. Correr la clase ServerMain.java
2. Correr la clase Cliente.java

# Punto 6
1. Correr la clase ServerMain.java
2. Correr la clase Cliente.java

Aclaración: El error,(vector2 es inicializado en 0), se encuentra introducido en el código de ambas operaciones(suma y resta).


# Conclusiones

Punto 1. Se pudo enviar el mensaje desde el cliente hacia el servidor, y se obtuvo una respuesta con ese mismo mensaje aclarando quien lo envía. Cabe mencionar que el Servidor no puede aceptar la petición de mas de un cliente al mismo tiempo.

Punto 2. Mediante la creacion de un hilo para cada Cliente, el Servidor pudo atendes varios Clientes a la vez.

Punto 6. Los parámetros en RMI siempre se pasan por valor debido a que el objeto posiblemente no este en el mismo espacio de memoria,
por lo que al inicializar el vecto2 en 0, estamos modificando el objeto copia que se encuentra en el servidor.
Por último podemos observar que el vector2 en el cliente no se vio modificado por el error introducido.
