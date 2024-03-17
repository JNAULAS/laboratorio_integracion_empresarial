# laboratorio_integracion_empresarial
Proyecto contenedor de integracion empresarial.
### COMANDO PARA CREACION DE PROYECTO
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn archetype:generate -B -DarchetypeGroupId=org.apache.camel.archetypes -DarchetypeArtifactId=camel-archetype-spring-boot -DarchetypeVersion=4.0.4 -Dpackage=org.apache.camel.learn -DgroupId=org.apache.camel.learn -DartifactId=spring-camel-integration -Dversion=1.0.0-SNAPSHOT

### COMANDO PARA COMPILAR EL PROYECTO
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn clean package -DskipTests

### COMANDO PARA CORRER EL PROYECTO
- Este comando no permite lanzar la aplicacion ya que no es proyecto nativo de camel para este caso es un sprint boot
/Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn camel:run

- Al ser un proyecto sprint boot ejecutamos la aplicacion con el comando.
    java -jar target/spring-camel-integration-1.0.0-SNAPSHOT.jar
- AQUI NO TENEMOS DESPLEGADO NINGUN SERVICIO DENTRO DEL SPRINT BOOT 
### PARA ESTO DESARROLLAMOS UN SERVICIO UTILIZANDO UN ENDPOINT DE TIPO SERVICE ACTIVATOR
- Esto con el objetivo que por medio de ese servicio se lance esa ruta.
