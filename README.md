# 💳 ISW1-ACT — Gestión de Clientes y Tarjetas de Crédito

Aplicación web desarrollada para la asignatura **Ingeniería de Software 1** de la Universidad El Bosque. Permite a una empresa de servicios financieros registrar y gestionar la información de sus clientes y sus tarjetas de crédito (VISA, MASTERCARD, AMEX).

---

## 🛠️ Tecnologías utilizadas

| Capa | Tecnología |
|------|-----------|
| Backend | Java + Spring Boot  |
| Frontend | PrimeFaces (JSF) |
| Base de datos | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Build | Maven |
| IDE | IntelliJ IDEA  |
| CI | GitHub Actions |
| Calidad de código | SonarCloud |

---
## 🗄️ Script de base de datos

```sql
-- Crear base de datos
CREATE DATABASE IF NOT EXISTS financiera;
USE financiera;

-- =========================
-- TABLA TARJETAS
-- =========================
CREATE TABLE tarjetas (
    ID_TARJETA VARCHAR(50) PRIMARY KEY,
    NUM_TARJETA VARCHAR(20) NOT NULL UNIQUE,
    FECHA_VENCIMIENTO VARCHAR(7) NOT NULL,
    FRANQUICIA_TARJETA VARCHAR(20),
    ESTADO_TARJETA VARCHAR(20),
    CUPO_TOTAL INT,
    CUPO_DISPONIBLE INT,
    CUPO_UTILIZADO INT
);

-- =========================
-- TABLA CLIENTES
-- =========================
CREATE TABLE clientes (
    ID_CLIENTE VARCHAR(50) PRIMARY KEY,
    NUM_IDENTIFICACION VARCHAR(50) NOT NULL,
    CORREO VARCHAR(100),
    NOMBRE_COMPLETO VARCHAR(150),

    ID_TARJETA VARCHAR(50),

    CONSTRAINT FK_CLIENTE_TARJETA 
    FOREIGN KEY (ID_TARJETA)
    REFERENCES tarjetas(ID_TARJETA)
);
```

---

## 📋 Funcionalidades principales

- ✅ Registro de clientes con ID, nombre y correo
- ✅ Registro de tarjetas de crédito asociadas a un cliente
- ✅ Detección automática de franquicia (VISA, MASTERCARD, AMEX)
- ✅ Cálculo automático de cupo utilizado
- ✅ Eliminación lógica (ACTIVO → INACTIVO)
- ✅ Modificación del cupo total
- ✅ Visualización en tabla con actualización inmediata sin refrescar página

---

## 👥 Integrantes

| Nombre | 
|--------|
| David Ortiz |
| Diego Rodriguez |

---

## 📌 Proyecto Jira
- https://unbosque-team-software.atlassian.net/jira/software/projects/SCRUM/summary
