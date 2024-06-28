# RestAPI

Este es un proyecto demo de una API REST creada con Spring Boot. La API está documentada con Swagger para facilitar su uso y comprensión. A continuación se detalla la configuración y las herramientas utilizadas en el proyecto.

## Herramientas Utilizadas

- **Spring Boot:** Framework que simplifica el desarrollo de aplicaciones basadas en Spring.
- **Spring Data JPA:** Abstracción de persistencia para trabajar con bases de datos relacionales de manera sencilla.
- **Spring Web:** Framework para el desarrollo de aplicaciones web, incluidas las API REST.
- **Microsoft SQL Server JDBC:** Conector JDBC para interactuar con bases de datos Microsoft SQL Server.
- **SpringDoc OpenAPI:** Herramienta para generar documentación interactiva de la API utilizando Swagger.
- **Spring Boot Validation:** Biblioteca para validar automáticamente los datos de entrada en la API.

## Configuración del Proyecto

### Dependencias

El archivo `pom.xml` incluye las siguientes dependencias principales:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.microsoft.sqlserver</groupId>
        <artifactId>mssql-jdbc</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <!-- Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Plugins de Construcción

El proyecto utiliza el plugin de Maven para Spring Boot:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## Documentación de la API

La documentación de la API está generada utilizando SpringDoc OpenAPI y puede ser accedida en la ruta `/swagger-ui.html` después de iniciar la aplicación.

## Requisitos Previos

- Java 17
- Maven
- Base de datos Microsoft SQL Server

## Ejecución del Proyecto

1. Clona el repositorio:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd restapi
   ```

2. Configura la conexión a la base de datos en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:sqlserver://<HOST>:<PORT>;databaseName=<DB_NAME>
   spring.datasource.username=<USERNAME>
   spring.datasource.password=<PASSWORD>
   ```

3. Compila y ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

4. Accede a la documentación de la API en:

   ```
   http://localhost:8080/swagger-ui.html
   ```

5. Crea y ejecuta el query de la base de datos 'SQLQueryDB.sql'

6. Configurar servidor de origen para hacer peticiones en config/CorsConfig

```
 public void addCorsMappings(CorsRegistry registry) {
 registry.addMapping("/\*_")
 .allowedOrigins("http://localhost:4200")
 .allowedMethods("GET", "POST", "PUT", "DELETE")
 .allowedHeaders("_")
 .allowCredentials(true);
 }
```
