# Calculadora_ISA

## Resúmen
Calculadora ISA es una aplicación web que proporciona funcionalidades básicas de calculadora como suma, resta, multiplicación y división. Está construido utilizando Java y el framework Spring Boot

## Estructura del proyecto:
```
Calculadora_ISA
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── calculadora
│   │   │           ├── controller
│   │   │           │   └── CalculatorController.java
│   │   │           ├── service
│   │   │           │   └── CalculatorService.java
│   │   │           └── App.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── calculadora
│                   └── AppTest.java
├── pom.xml
└── README.md
```

## Instrucciones de configuración
1. Clonar repositorio:
   ```
   git clone <repository-url>
   ```
2. Navegar al repositorio:
   ```
   cd Calculadora_ISA
   ```
3. Construir proyecto con Maven:
   ```
   mvn clean install
   ```
4. Correr la APP:
   ```
   mvn spring-boot:run
   ```

## Uso
Una vez la APP esté corriendo, puedes ingresar a la calculadora en:
```
http://localhost:8080/calculator
```
