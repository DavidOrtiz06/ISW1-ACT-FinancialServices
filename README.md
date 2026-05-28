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
CREATE DATABASE IF NOT EXISTS isw_db;
USE isw_db;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_identificacion VARCHAR(20) NOT NULL UNIQUE,
    nombre_completo VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE tarjeta_credito (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(16) NOT NULL UNIQUE,
    fecha_vencimiento VARCHAR(7) NOT NULL,
    franquicia VARCHAR(20) NOT NULL,
    estado VARCHAR(10) NOT NULL DEFAULT 'ACTIVO',
    cupo_total DECIMAL(15,2) NOT NULL,
    cupo_disponible DECIMAL(15,2) NOT NULL,
    cupo_utilizado DECIMAL(15,2) GENERATED ALWAYS AS (cupo_total - cupo_disponible) STORED,
    cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
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
