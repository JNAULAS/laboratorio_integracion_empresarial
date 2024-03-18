# laboratorio_integracion_empresarial
Proyecto contenedor de integracion empresarial.
### COMANDO PARA CREACION DE PROYECTO
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn archetype:generate -B -DarchetypeGroupId=org.apache.camel.archetypes -DarchetypeArtifactId=camel-archetype-spring-boot -DarchetypeVersion=4.0.4 -Dpackage=org.apache.camel.learn -DgroupId=org.apache.camel.learn -DartifactId=spring-camel-integration -Dversion=1.0.0-SNAPSHOT

# COMANDO PARA COMPILAR EL PROYECTO
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn clean package -DskipTests

# COMANDO PARA CORRER EL PROYECTO
- Este comando no permite lanzar la aplicacion ya que no es proyecto nativo de camel para este caso es un sprint boot
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn camel:run

- Al ser un proyecto sprint boot ejecutamos la aplicacion con el comando.
    java -jar target/spring-camel-integration-1.0.0-SNAPSHOT.jar
- AQUI NO TENEMOS DESPLEGADO NINGUN SERVICIO DENTRO DEL SPRINT BOOT 
# PARA ESTO DESARROLLAMOS UN SERVICIO UTILIZANDO UN ENDPOINT DE TIPO SERVICE ACTIVATOR
- Esto con el objetivo que por medio de ese servicio se lance esa ruta.

## PROYECTO PYTHON
1. Para crear el proyecto en python realizamos el siguiente ejercicio.
    - Ejecutamos el comando dentro del directorio contenedor.
        python3 -m venv pryservice123
    - Activaos el ambiente virtual python para esto ingresamos al folder del proyecto python.
        source pryservice123/bin/activate
    - Una vez activado el entorno virtual tenemso el resultado.
        (pryservice123) juannaula@Juans-MacBook-Pro pryservice123 % 
2. Una vez dentro del entono virtua procedemos con los siguiente pasos para consigurar el proyecto.
    - Creamos nuestro archivo de requirements.txt dentro de la carpeta pryservice123 y agregamos los siguientes comandos 
        Flask           (Permite desarrollar aplicaciones web)
        Flask-RESTful   (Complemento de python para masnejar los servicios  RESTful para manejo en formato tipo json)
    - Procedemos a instalar el archivo de requerimientos para esto debemos estar dentro del ambiente del entorno virtual.
        pip install -r pryservice123/requirements.txt

3. Procedemos a crear el servicio para captura de clientes creados desde la empresa principal
    - Creamos el archivo para nuestra aplicacion main.py
    - Corremos nuestra aplicacion dentro del entrno virtual, para esto nos ubicamos dentro del proyecto
        python main.py 
    - Ahora ya podemos probar la aplicacion corriendo en flask
        http://127.0.0.1:5000
4. Procemos a definir los servicios.
    - Definimos los metodos del servicio, para esto creamos un arreglo dentro de la clase de python
