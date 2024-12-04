package Vehicle;

import java.time.LocalDate;

public abstract class Petrol extends Vehicle {
    private double engine; // Engine size (e.g., 1.2 for 1.2L)
    private int co2;       // CO2 emissions in g/km

    public Petrol(int id, String regNo, String manufacturer,
                  String model, LocalDate regDate,
                  String location, double engine, int co2) {

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
    public String toString() {
        return super.toString() +
                ", Engine: " + engine + "L" +
                ", CO2 Emissions: " + co2 + "g/km";
    }
}
