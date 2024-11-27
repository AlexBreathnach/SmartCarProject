import java.time.LocalDate;

abstract class Petrol extends Vehicle {
    public double engine;
    public int co2;


    public Petrol(int id, String regNo, String manufacturer,
                  String model, LocalDate regDate, String location) {
        super(id, regNo, manufacturer, model, regDate, location);
    }
}

