default:
	echo("run: make <p1/p2> to get the outputs for the desired problem.")

p2:
	javac Logger.java Node.java Sensor.java SensorList.java P2.java
	java P2

p1:
	javac CGLinkedList.java Node.java Servant.java P1.java
	java P1

clean:
	rm *.class