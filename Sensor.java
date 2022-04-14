import java.util.Random;

public class Sensor extends Thread {
    Random rand = new Random();
    SensorList Readings;
    int Frequency;
    int Interval;

    public Sensor(int frequency, SensorList readings, int interval) {
        this.Frequency = frequency;
        this.Readings = readings;
        this.Interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            int reading = rand.nextInt(171) - 100;
            Readings.add(this.Interval, reading);

            try {
                Thread.sleep(1000 * this.Frequency);
            } catch (InterruptedException e) {
            }

            this.Interval++;
        }
    }
}
