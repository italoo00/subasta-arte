# Subasta de Obras de Arte

Web donde los artistas publican obras y los compradores pujan por ellas durante un tiempo limitado. Gana quien tenga la puja más alta cuando la subasta se cierra.

## Tecnologías
- **Backend:** Spring Boot (Java 21+) con API REST
- **Frontend:** React (Vite)
- **Base de datos:** PostgreSQL

Flujo: React → API REST (Spring Boot) → PostgreSQL

## Requisitos previos
- Java 21 o superior
- Node.js y npm
- PostgreSQL (se recomienda la versión 18; cualquier versión 15 en adelante funciona)

## Cómo levantar el proyecto

### 1. Base de datos
Con PostgreSQL instalado y encendido, crear la base de datos:

```sql
CREATE DATABASE subasta_arte;
```

El proyecto usa por defecto el usuario `postgres` y la contraseña `postgres`. Si la tuya es distinta, **no edites el código**: define variables de entorno.

En CMD:

```bat
set DB_USER=postgres
set DB_PASSWORD=tu_contraseña
```

En PowerShell:

```powershell
$env:DB_USER="postgres"
$env:DB_PASSWORD="tu_contraseña"
```

Las variables solo viven en esa ventana de terminal. Ejecuta el backend desde la misma ventana.

### 2. Backend

```bat
cd backend\subasta-arte
mvnw spring-boot:run
```

Corre en http://localhost:8080

### 3. Frontend

```bat
cd frontend
npm install
npm run dev
```

Corre en http://localhost:5173

## Estructura del backend

Capas: `controller → service → repository → entity`

```
com.subasta
├── controller/