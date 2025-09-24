# Java Cardholder App

A simple Java Spring Boot application to **add, store securely, and search cardholder information**.  
Frontend is basic HTML; backend uses Spring Boot with encrypted storage for PANs.

---

### Features
- Add Card: Submit cardholder name and PAN (encrypted before storage).  
- Search Cards: Search by last 4 digits; display masked PAN.  
- Frontend: Simple HTML forms; results shown in a table.

---

## Database Structure

For this project, a **single table** named `cards` stores cardholder information:

```sql
CREATE TABLE cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cardholder_name VARCHAR(255) NOT NULL,
    encrypted_pan VARCHAR(255) NOT NULL,
    last4 CHAR(4) NOT NULL,
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
---
## Prerequisites
- **Java 17+**: Make sure JDK is installed and `java` is available in your PATH.  
- **Maven**: Either install Maven globally or use the included **Maven Wrapper** (`./mvnw`) that comes with the project. 

---

## How to Run

1. **Clone the repository**:
```bash
git clone <your-repo-url>
cd java-cardholder-app
```
2. **Run the application using Maven Wrapper**:
```bash
./mvnw spring-boot:run   # Linux / macOS
mvnw.cmd spring-boot:run  # Windows
```
3. **Open the frontend in your browser**:
```bash
http://localhost:8080/index.html
```
---

## Notes
- For simplicity, the AES encryption key is currently hardcoded in `EncryptionUtil`.  
- In a production environment, the key should be stored securely (e.g., environment variable, secret manager).

---