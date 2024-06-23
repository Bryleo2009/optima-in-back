
# Proyecto Spring Boot en Local
## Requisitos Previos
- Java JDK
    - Ve al sitio oficial de Oracle para descargar Java JDK en [java.com](https://www.java.com/es/download/)
    - Descarga la versión adecuada de Java JDK para tu sistema operativo (Windows, macOS, Linux).
    - Sigue las instrucciones de instalación proporcionadas en el sitio web.
    - Una vez completada la instalación, puedes verificar que Java JDK se haya instalado correctamente ejecutando el siguiente comando en tu terminal: `java -version`
- IDE (Spring Tools 4, IntelliJ IDEA, Eclipse, etc.)
    - Abre tu IDE Eclipse.
    - Ve a "Help" en la barra de menú y selecciona "Eclipse Marketplace".
    - En el cuadro de búsqueda, escribe "Spring Tools" y presiona Enter.
    - Deberías ver "Spring Tools 4" en los resultados de la búsqueda. Haz clic en "Install" para comenzar la instalación.
    - Sigue las instrucciones en pantalla para completar la instalación. Es posible que necesites reiniciar Eclipse una vez que  
      la instalación haya finalizado.
    - Una vez instalado, puedes comenzar a utilizar Spring Tools 4 para desarrollar y gestionar tus proyectos Spring de manera más
      eficiente.
- Maven
    - Ve al sitio oficial de Apache Maven en https://maven.apache.org/.
    - Descarga la última versión de Apache Maven en formato binario.
    - Descomprime el archivo descargado en una ubicación de tu elección en tu sistema.
    - Configura las variables de entorno M2_HOME para que apunten al directorio donde descomprimiste Maven y añade %M2_HOME%\bin al PATH del sistema.
    - Para verificar la instalación, abre una nueva terminal y ejecuta el comando mvn -version.
    - Si Maven se ha instalado correctamente, verás la versión de Maven y la información del sistema.

## Pasos de Configuración
1. Clona este repositorio en tu máquina local: [optima-in-back](https://github.com/Bryleo2009/optima-in-back.git) con el comando `git clone https://github.com/Bryleo2009/optima-in-back.git`
2. Importa el proyecto en tu IDE preferido.
3. Ejecuta la aplicación Spring Boot desde tu IDE o con el comando: `mvn spring-boot:run`
4.  Accede a la aplicación en tu navegador visitando `http://localhost:9090` u otra URL especificada. ¡Listo! Ahora deberías tener el proyecto Spring Boot funcionando en tu máquina local. Asegúrate de incluir cualquier otra información relevante en tu README para facilitar a otros colaboradores el levantamiento del proyecto en sus entornos locales. ¡Éxito con tu proyecto!

## Configuración de Base de Datos

- Se manejará un acceso a MySql, donde la conexión por defecto es
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/optima-in  
  spring.datasource.username=root  
  spring.datasource.password=
  ```
  Por lo tanto, la base de datos posee el nombre optima-in, usuario root y sin contraseña. Esto puede ser modificado segun su preferencia.

## Configuración de Consumo
- Para acceder a los datos del backend. se realizará un consumo por la ruta `http://localhost:9090/api/v1/`
  Existiendo datos en `/credito` , `/proyecto`, `/cliente`
## Consumo de Archivo .jar
- Si la configuración actual de su sistema, concuerda con lo especificado en este documento. Puede omitir los pasos de arriba y ejecutar el archivo .jar
    1.  Abre una terminal o línea de comandos en tu sistema.
    2.  Navega hasta la ubicación donde se encuentra tu archivo JAR utilizando el comando  `cd ruta/del/archivo`.
    3.  Una vez en la ubicación correcta, puedes ejecutar el archivo JAR utilizando el comando  `java -jar nombre_del_archivo.jar`.

  Por ejemplo, si tu archivo JAR se llama  `optima-in.jar`, el comando sería  `java -jar optima-in.jar`.
