import java.time.LocalDate;

abstract class Vehicle {
    private int id;
    private String regNo;
    private String manufacturer;
    private String model;
    private LocalDate regDate;
    private String location;

    public Vehicle(int id, String regNo, String manufacturer, String model,
                   LocalDate regDate, String location) {
        this.id = id;
        this.regNo = regNo;
        this.manufacturer = manufacturer;
        this.model = model;
        this.regDate = regDate;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public abstract double calculateRate(int hours, int kilometers);

    @Override
    public String toString() {return "ID: " + ", RegNo: " + ", Manufacturer: "
            + ", RegDate: " + ", Location: "
            + id + regNo + manufacturer + regDate + location;
    }


}
