public class Logger extends Thread {
    int Freqeuency;
    SensorList Readings;

    public Logger(int frequency, SensorList readings) {
        this.Freqeuency = frequency;
        this.Readings = readings;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * this.Freqeuency);
        } catch (InterruptedException e) {
        }

        this.Readings.printtop5();
        this.Readings.printBottom5();
        // log greatest diff
    }
}
