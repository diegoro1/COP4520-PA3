public class P2 {
    // number of seconds
    final static int FREQUENCY = 1;

    public static void main(String[] args) throws InterruptedException {
        SensorList readings = new SensorList();

        Sensor s1 = new Sensor(FREQUENCY, readings, 0);
        Sensor s2 = new Sensor(FREQUENCY, readings, 0);
        Sensor s3 = new Sensor(FREQUENCY, readings, 0);
        Sensor s4 = new Sensor(FREQUENCY, readings, 0);
        Sensor s5 = new Sensor(FREQUENCY, readings, 0);
        Sensor s6 = new Sensor(FREQUENCY, readings, 0);
        Sensor s7 = new Sensor(FREQUENCY, readings, 0);
        Sensor s8 = new Sensor(FREQUENCY, readings, 0);
        Logger log = new Logger(FREQUENCY, readings);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();
        s7.start();
        s8.start();
        log.start();
    }
}
