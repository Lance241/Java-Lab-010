public class StatisticsDisplay implements Display {

    private WeatherStation ws;

    private float temperatureMin;

    private float temperatureMax;
    private float tempRunningTotal;
    private float averageTemperature;
    private int numReadings;

    public StatisticsDisplay(WeatherStation ws) {
        this.ws = ws;
        ws.registerDisplay(this);
        numReadings++;
    }
    public void update() {
        float temperature = ws.getTemperature();
        tempRunningTotal += temperature;
        numReadings++;

        if ( numReadings == 1 || temperature < temperatureMin) {
            temperatureMin = temperature;
        }
        if ( numReadings == 1 || temperature > temperatureMax) {
            temperatureMax = temperature;
        }
        display();
    }

    public void display() {
        if (numReadings > 0) {
            float averageTemperature = tempRunningTotal /numReadings;
        }
        System.out.println("Temperature Statistics:");
        System.out.println("Max: " + temperatureMax + "°F");
        System.out.println("Min: " + temperatureMin + "°F");
        System.out.println("Average: " + averageTemperature + "°F");
    }
}
