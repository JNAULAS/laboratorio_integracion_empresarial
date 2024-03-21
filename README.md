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


### PROCEDEMOS A CREAR EL PROYECTO EN .NET
1. Para la creacion del proyecto nos hubicamos en el folder principal contenedor de todos los proyectos y ejecutamso el comando.
    - procedemos a instalar netcore 7
        https://learn.microsoft.com/es-es/dotnet/core/install/
    - Lanzamos comando para la creacion del proyecto
    dotnet new webapi -o netmicro --no-https --framework net7.0
2. Pasos para compilar y testear la aplicacion
    - dotnet clean
    - dotnet build
    - dotnet run
3. Creamos un objeto para manejar los Clientes
4. Definimos los servicios dentro de la carpeta controller
5. Procedemos a compilar el proyecto
    - dotnet clean
    - dotnet build
    - dotnet run





###### PASOS PARA EJECUCION DE PROYECTO DE LABORATORIO  #####################################################
### PYTHON
1. Levantamos el ambiente virtual, para esto lanzamos el comando ubicados dentro del folder principal laboratorio_integracion_empresarial
    source pryservice123/bin/activate
2. Ingresamos dentro de la capera contenedora del proyecto - pryservice123
3. Procedemos a levantar la aplicacion
    python main.py 
4. Realizamos la validacion de consumo de servicios desde el postman, en este caso retornara toda la data este solo es usando el componen - tetransform (primera validacion)
    http://127.0.0.1:5000/clients (methodo GET)
### .NET CORE
1. Una vez dentro del folder del proyecto principal laboratorio_integracion_empresarial ingresamos al proyecto netmicro.
1. Una vez dentro del proyecto netmicro ejecutamos los comandos para limpiar, compilar y lanzar la aplicacion.
    - dotnet clean
    - dotnet build
    - dotnet run
2. Una vez levantado la aplicacion procedemos a consumir el servicio de consulta desde el postman
    2.1 Ingresamos al swagger para copiar los endpoint 
        http://localhost:5278/swagger/index.html
    2.3 Probamos la consulta del servicio de clientes
        http://localhost:5278/Client

### EJECUTAMOS LA APLICACION PRINCIPAL CAMEL SPRINT BOOT PARA QUE ELLA RECIBA EL JSON DE INFORMACION PARA CREACION DE LOS CLIENTES EL CUAL INCLUYE LA CONDICION PARA VERIFICAR SI VA A LA EMPRESA 123 (PYTHON ) O ABC (NETCORE)
1. Ingresamos al proyecto - spring-camel-integration
2. Una vez dentro lanzamos los comando para compilar y deployar el servicio
    - COompilacion del proyecto
    /Users/juannaula/Documents/CLASES_MAESTRIA/PATRONES_INTEGRACION_EMPRESARIAL/apache-maven-3.9.6/bin/mvn clean package -DskipTests (Mac)
    mvn clean package -DskipTests (Windows)
    - Ejecucion ser servicio.
    java -jar target/spring-camel-integration-1.0.0-SNAPSHOT.jar

3. Ingresamos al postman para el consumo del servicio de consulta y creacion de nuevos clientes.
    http://localhost:8080/addClienteEmp (POST)
    
    Enviamos el json para crear el cliente
        {
            "codigo": 4,
            "identificacion": "0104925594",
            "nombres": "Karolain Naula",
            "correo": "pruebas@yahoo.es",
            "telefono": "0986543782",
            "direccion": "Ricaurte",
            "codigoEmpresa":2 // Importantes: Bandera que decide el camino a tomar
            
        }

    3.1  Si el codigo de la codigoEmpresa va en (1) el registro se realizara en la empresa 123 (PYTHON), aqui el resultado retorna la nueva lista de clientes y esto a su vez lo podemos probar con el postman endopint de consulta (http://127.0.0.1:5000/clients) (method GET) para validar el registro del nuevo cliente en el servicio python.

    3.2 Si el codigoEmpresa va en (2) el ClientRouter valida y enviara por el canal netmicro empresa ABC para registro del cliente por medio del endpoint provisto por la empresa ABC, aqui el resultado ya no sera un listado de empresas si no solo un mensaje de confirmacion que envia netmicro (Cliente Registrado con exito.), ahora qui para probar el registro en la empresa ABC (netmicro) hacemos uso del endpoint http://localhost:5278/Client (method GET) y aqui ya podremos ver el listado con el nuevo cliente creado.


