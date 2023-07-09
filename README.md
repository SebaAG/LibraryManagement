# Administración de Libros utilizando Java y Tecnologías de Backend

Este proyecto es una aplicación de administración de libros desarrollada en Java, que emplea una variedad de tecnologías y herramientas del lado del servidor. La aplicación utiliza programación orientada a objetos para una estructura de código modular y mantenible.

## Características principales

- **Gestión de libros**: Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos para administrar libros. Cada libro tiene atributos como título, autor, año de publicación y género.

- **Base de datos MySQL**: Utiliza MySQL como el sistema de gestión de bases de datos para almacenar y recuperar información sobre los libros. Esto permite un almacenamiento persistente y una gestión eficiente de los datos.

- **Maven**: Se utiliza Maven como herramienta de gestión de dependencias para simplificar la configuración del proyecto y asegurar la correcta resolución de dependencias.

- **Hibernate y JPA**: Se emplea el framework de persistencia Hibernate junto con la API de Persistencia de Java (JPA) para mapear los objetos de la aplicación con las tablas de la base de datos. Esto facilita la interacción con la base de datos y agiliza el desarrollo.

- **Spring Boot**: Se utiliza Spring Boot como el framework de desarrollo de aplicaciones Java, lo que facilita la configuración inicial y proporciona un entorno de ejecución simplificado. También aprovecha las capacidades de inyección de dependencias y gestión transaccional de Spring.

- **OpenCSV**: La dependencia opencsv permite trabajar con archivos CSV en la aplicación. Proporciona métodos para leer y escribir datos en formato CSV, lo que puede ser útil para importar y exportar información relacionada con los libros desde y hacia archivos CSV.

- **Lombok**: La dependencia lombok simplifica la escritura de código Java al reducir la cantidad de código boilerplate necesario para clases, como getters, setters, constructores y métodos equals y hashCode. Esto mejora la legibilidad y reduce el tiempo de desarrollo.