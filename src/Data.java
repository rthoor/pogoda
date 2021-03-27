import java.util.Date;

public class Data{

    private String date;
    private int temperature;
    private int relativeHumidity;
    private int windSpeed;
    private String windDirection;

    public Data(String date, int temperature, int relativeHumidity, int windSpeed, String windDirection) {
        this.date = date;
        this.temperature = temperature;
        this.relativeHumidity = relativeHumidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(int relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
