import java.time.LocalDate;

public class SmartCity extends Petrol{
    public SmartCity(int id, String regNo, String manufacturer,
                     String model, LocalDate regDate, String location) {
        super(id, regNo, manufacturer, model, regDate, location);
        this.engine = engine;
        this.co2 = co2;
    }

     @Override
     public double calculateRate(int hours, int kilometers) {
        double hourlyRate = 11;
        double dailyRate = 55;
        double mileageCost = Math.max(0, kilometers - 50)*0.25;
         return (hours <= 24? hourlyRate * hours : dailyRate) + mileageCost;
     }

 }
