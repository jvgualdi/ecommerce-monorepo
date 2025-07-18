# Ecommerce Monorepo

## Pré‑requisitos
- Git
- Java 21 SDK e Maven 3.8+
- Docker & Docker Compose

## Setup Local

1. Clone o repositório:
   ```bash
   git clone git@github.com:SEU_USUARIO/ecommerce-monorepo.git
   cd ecommerce-monorepo
   ```

2. Suba infra (Postgres + Redis):
   ```bash
   ./bootstrap.sh
   ```

3. Backend (catalog-service):
   ```bash
   cd backend/catalog-service
   mvn clean spring-boot:run
   ```
   Acesse `http://localhost:8080/actuator/health` → deve retornar `UP`.