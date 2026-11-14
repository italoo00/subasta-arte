# 🎨 Subasta de Obras de Arte

**Proyecto de Software — Patrones de Diseño**

Aplicación web para la gestión, publicación y puja de obras de arte en tiempo real, implementando patrones de diseño creacionales, estructurales y de comportamiento.

---

## 1. Integrantes y Distribución

| Integrante | Rama | Módulo / Responsabilidad | Patrones Implementados |
| :--- | :--- | :--- | :--- |
| **Italo** | `feature/subastas` | Entidades base (`Obra`, `Subasta`), gestión de obras/subastas y estructura base del frontend. | **Factory** (subastas normales y con precio de reserva) |
| **Antonio** | `feature/usuarios` | Gestión de usuarios, login, verificación y ciclo de vida de las subastas. | **Proxy** (control de acceso a pujas) y **State** (`Programada → Activa → Cerrada → Adjudicada`) |
| **Jhairo** | `feature/pujas` | Sistema de pujas, cálculo de incrementos mínimos y actualización en pantalla. | **Strategy** (incremento fijo o porcentual) y **Observer** (notificaciones y actualización de precio) |

---

## 2. Tecnologías

* **Backend:** Java / Spring Boot *(ajusta la versión si aplica)*
* **Frontend:** React, React Router y Hooks
* **Control de Versiones:** Git & GitHub (Flujo basado en `main` ← `dev` ← `feature/*`)

---

## 3. Estructura del Repositorio

```text
DS/
├── backend/subasta-arte/    # API REST en Spring Boot (config, controller, dto, entity, exception, pattern, repository, service)
├── frontend/                # Interfaz web en React + Vite
└── README.md                # Documentación general del proyecto