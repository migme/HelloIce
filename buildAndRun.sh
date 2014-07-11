mkdir bin
rm generated/Demo/*
ls generated/Demo
$ICE_HOME/bin/slice2java --output-dir generated/  src/Printer.ice

javac -cp $ICE_HOME/lib/Ice.jar  src/*.java generated/Demo/*.java -d bin/

echo "Running server"
java -cp $ICE_HOME/lib/Ice.jar:./bin/  Server  &

sleep 5
echo "Running client"
java -cp $ICE_HOME/lib/Ice.jar:./bin/  OneWayProxiesTest 


