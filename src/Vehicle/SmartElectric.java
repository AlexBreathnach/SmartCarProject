package Vehicle;

import java.time.LocalDate;

public class SmartElectric extends Vehicle {
    private double engine;
    private int co2;

    public SmartElectric(int id, String regNo, String manufacturer, String model,
                     LocalDate regDate, String location,
                     double engine, int co2) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.engine = engine;
        this.co2 = co2;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }



    @Override
    public double calculateRate(int hours, double distance) {
        double hourlyRate = 11.0;
        double mileageRate = (distance > 50) ? (distance - 50) * 0.25 : 0;
        return hours * hourlyRate + mileageRate;
    }

}
