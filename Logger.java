public class Logger extends Thread {
    int Freqeuency;
    SensorList Readings;

    public Logger(int frequency, SensorList readings) {
        this.Freqeuency = frequency;
        this.Readings = readings;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000 * this.Freqeuency);
            } catch (InterruptedException e) {
            }

            this.Readings.printtop5();
            this.Readings.printBottom5();
            // this.Readings.printList();
        }
    }
}
