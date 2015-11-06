Comandos para ejecutar una calculadora en CORBA

Para ejecutar el compilador IDL
idlj -fall Calculadora.idl

Compilar todas las clases
javac *.java CalculadoraApp/*.java

Ejecutar ORB
start orbd -ORBInitialPort 1070

Ejecutar el servidor:
start java CalculadoraServer -ORBInitialPort 1070 -ORBinitialHost localhost

Ejecutar el cliente:
java CalculadoraClient -ORBInitialPort 1070 -ORBinitialHost localhost
