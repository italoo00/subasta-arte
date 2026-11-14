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
├── controller/    Endpoints REST (sin lógica de negocio)
├── service/       Lógica de negocio
├── repository/    Acceso a datos (Spring Data JPA)
├── entity/        Entidades JPA
├── dto/           Objetos de transferencia
├── config/        Configuración (CORS, seguridad)
├── exception/     Manejo de errores
└── pattern/
    ├── observer/
    ├── state/
    ├── proxy/
    ├── factory/
    └── strategy/
```

## Patrones de diseño
- **Observer:** al pujar se actualiza el precio y se avisa a quien fue superado.
- **State:** la subasta pasa por Programada → Activa → Cerrada → Adjudicada.
- **Proxy:** controla quién puede pujar (solo usuarios verificados, nunca en su propia obra).
- **Factory:** creación de tipos de subasta (normal o con precio de reserva).
- **Strategy:** reglas de incremento mínimo de puja (fijo o porcentual).

Además se aplican los principios **SOLID** en todo el código.

## Reparto del trabajo
| Integrante | Rama | Módulo | Patrones |
|---|---|---|---|
| 1 - Italo | `feature/subastas` | Obras y subastas, base del frontend | Factory |
| 2 - Antonio | `feature/usuarios` | Usuarios, login, verificación, ciclo de vida y cierre de la subasta | Proxy, State |
| 3 - Jhairo | `feature/pujas` | Pujas, notificaciones, precio en pantalla | Strategy, Observer |
