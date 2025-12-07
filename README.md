# 🎓 Gestor de Estudiantes Backend

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.2-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey.svg)](LICENSE)

Proyecto backend para la gestión de estudiantes, construido con Spring Boot, Spring Data JPA y H2 Database.

---

## 📦 Tecnologías utilizadas

- Java 21
- Spring Boot 3.3.x
- Spring Data JPA
- H2 Database (en memoria)
- Maven

---

## ⚙️ Funcionalidades

- Crear nuevos estudiantes
- Obtener todos los estudiantes
- Obtener estudiante por ID
- Actualizar estudiante existente
- Eliminar estudiante
- Buscar estudiantes por nombre (parcial y case-insensitive)

---

## 🏗 Estructura del proyecto

`gestor-estudiantes-backend/`

- `src/main/java/com/curso/gestor_estudiantes/`
    - `controller/` → Controladores REST
    - `model/` → Entidades JPA
    - `repository/` → Repositorios Spring Data
    - `service/` → Lógica de negocio
- `src/main/resources/`
    - `application.properties` → Configuración de Spring Boot y H2
- `pom.xml` → Dependencias Maven
- `README.md`

---

## 🚀 Endpoints principales

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET`    | `/estudiantes` | Obtener todos los estudiantes |
| `GET`    | `/estudiantes/{id}` | Obtener estudiante por ID |
| `POST`   | `/estudiantes` | Crear nuevo estudiante |
| `PUT`    | `/estudiantes/{id}` | Actualizar estudiante existente |
| `DELETE` | `/estudiantes/{id}` | Eliminar estudiante |
| `GET`    | `/estudiantes/buscar?nombre=xxx` | Buscar estudiantes por nombre (parcial, case-insensitive) |

---

## 🛠 Configuración de H2

- Consola habilitada en: `/h2` (ej: http://localhost:8080/h2)
- URL en memoria: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: (vacía)

Ejemplo de configuración en `src/main/resources/application.properties`:

    spring.h2.console.enabled=true
    spring.h2.console.path=/h2
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

Nota: para persistencia entre reinicios, usar:
`jdbc:h2:file:./data/testdb`

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:

   `git clone https://github.com/isasan/gestor-estudiantes-backend.git`

2. Abrir el proyecto en un IDE compatible o en terminal.

3. Ejecutar con Maven:

- En Windows:

  `mvnw.cmd spring-boot:run`  
  (o si tiene Maven instalado: `mvn spring-boot:run`)

- En Linux/macOS:

  `./mvnw spring-boot:run`

4. Acceder a los endpoints vía Postman, navegador o frontend.

---

## 📌 Notas importantes

- La base de datos por defecto es en memoria y se borra al reiniciar la aplicación.
- Todos los endpoints devuelven JSON y esperan JSON en el body cuando corresponda.
- Proyecto para fines educativos sobre Spring Boot y JPA.

---

## 👨‍💻 Autor

GitHub: isasan

---

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Consulta `LICENSE` para más detalles.
