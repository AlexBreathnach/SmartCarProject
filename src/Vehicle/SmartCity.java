package Vehicle;

import java.time.LocalDate;

public class SmartCity extends Petrol {
    private static final double HOURLY_RATE = 11.0;
    private static final double DAILY_RATE = 55.0;

    public SmartCity(int id, String regNo, String manufacturer,
                     String model, LocalDate regDate,
                     String location, double engine, int co2) {

        super(id, regNo, manufacturer, model, regDate, location, engine, co2);
    }

    @Override
    public double calculateRate(int hours, double distance) {
        double mileageRate = (distance > 50) ? (distance - 50) * 0.25 : 0;
        return (hours * HOURLY_RATE) + mileageRate;
    }

    public void setRates(double hourlyRate, double dailyRate) {
        // Adding updates to  hourly and daily rates
    }

    @Override
    public String toString() {
        return "SmartCity: " + super.toString() +
                ", Hourly Rate: €" + HOURLY_RATE +
                ", Daily Rate: €" + DAILY_RATE;
    }
}
