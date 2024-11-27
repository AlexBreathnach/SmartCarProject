import java.time.LocalDate;

abstract class SmartElectric extends Vehicle{
    private double battery;
    private int range;
    private int efficiency;

    public SmartElectric(double battery, int range, int efficiency, int id,
                         String regNo, String manufacturer,
                         String model, LocalDate regDate, String location) {
        super(id, regNo,manufacturer, model, regDate, location);
    }

    public double calculateRent(int hours, int kilometers){
        double hourlyRate = 14;
        double dailyRate = 70;
        return hours <= 24 ? hourlyRate * hours : dailyRate;
    }
}
