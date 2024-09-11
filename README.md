# SMARTJOB RETO TÉCNICO JAVA

Este proyecto contiene:

- Uso de arquitectura hexagonal haciendo uso de principios SOLID
- Integración con Swagger
- Integración con JPA
- Comunicación entre capas a través de Interfaces
- H2 Database
- Uso token JWT para el registro.

# 1.- Arquitectura de la aplicación
![Arquitectura de la aplicación](/images/pag0_0.jpg)

# 2.- Pasos para ejecutar la aplicación

Ejecutar para descargar las dependencias, generar el jar.

- mvn clean install


# 3.- Pruebas

3.1) CARGA PREVIA: Como paso previo se carga la tabla de 
![Descripción de la imagen](/images/pag1_1.jpg)

Veremos que crean 3 tablas:
- USERS
- PHONES
- REGULAR_EXPRESSIONS

Al iniciar la aplicación se crean estas 3 tablas, luego la aplicación  ingresa los registros que se visualizan en la imagen. 
En la tabla REGULAR_EXPRESSSIONS la expresión regular que contiene CODE ="000"" corresponde a la expresión regular DEL PASSWORD. El registro que tiene CODE="001" es un registro correspondiente a una expresión regular que no es una contraseñ. Se le agregó solo para ejemplos didacticos.


![Descripción de la imagen](/images/pag4_0.jpg)


Existen 2 APIs, la primera de Usuarios y la segunda de Expresiones Regulares.


3.2) Listado de APIs 
```
API USERS
POST  ->  http://localhost:8081/smartjob/api/v1/users
PUT   ->  http://localhost:8081/smartjob/api/v1/users/{uuid}
GET   ->  http://localhost:8081/smartjob/api/v1/users/{uuid}
DELETE -> http://localhost:8081/smartjob/api/v1/users/{uuid}


API REGULAR EXPRESSIONS
POST  ->  http://localhost:8081/smartjob/api/v1/expressions
PUT   ->  http://localhost:8081/smartjob/api/v1/expressions/{uuid}
GET   ->  http://localhost:8081/smartjob/api/v1/expressions/{uuid}
DELETE -> http://localhost:8081/smartjob/api/v1/expressions/{uuid}
```
3.3 ) Registro de USUARIO
- POST  ->  http://localhost:8081/smartjob/api/v1/users

   Se necesita un JWT como el que se visualiza en la imagen
  ![Descripción de la imagen](/images/pag2_0.jpg)
   Solo basta con copiar :  "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtY29uZG9yaWJAZ21haWwuY29tIiwiZXhwIjoxNzIwNjE3NTQxLCJub21icmUiOiJtYXJjbyBjb25kb3JpIn0.Ij2QDGtpkNOdRG92KLYh5vv-YPY5nRW-7SoAImq7mPc"

   Luego se raliza la creación de USUARIO y finaliza la creación de usuarios.

  ![Descripción de la imagen](/images/pag2_1.jpg)

3.4 ) Otras operaciones API USUARIOS

- PUT  ->  http://localhost:8081/smartjob/api/v1/users/{uuid}

   Luego se raliza la actualización de USUARIO:

  ![Descripción de la imagen](/images/pag2_2.jpg)

- GET  ->  http://localhost:8081/smartjob/api/v1/users/{uuid}

   Luego se raliza la consulta de un USUARIO:

  ![Descripción de la imagen](/images/pag2_3.jpg)

- DELETE  ->  http://localhost:8081/smartjob/api/v1/users/{uuid}

   Luego se raliza la eliminación de un USUARIO:

  ![Descripción de la imagen](/images/pag2_4.jpg)

3.5 ) Otras operaciones API REGULAR EXPRESSIONS

- PUT  ->  http://localhost:8081/smartjob/api/v1/users/{uuid}

  Luego se raliza la actualización de LA Expresión Regular de tipo Contraseña:

  ![Descripción de la imagen](/images/pag5_0.jpg) 

