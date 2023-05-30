# Poder_Judicialv2
Web Service REST

Pasos para ejecutar con Docker
1. Crear el archivo jar. Para esto abrimos la consola dentro del directorio de trabajo, luego ejecutamos el siguiente comando "./mvnw clean install
"
2. Luego verificamos que se haya creado un archivo.jar en el directorio target
3. Por ultimo, lo que hacemos es modificar las credenciales de acceso a la base de datos, donde colocamos 
el puerto, el usuario y contraseña para conectarnos, esto lo modificamos desde el archivo .env
4. Finalmente, utilizamos el comando "docker-compose up" para crear los contenedores de la base de datos
5. y la aplicacion.
