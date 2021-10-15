package pl.edu.java.wszib.car.rent.model;

public class Car {
    private String brand;
    private String model;
    private String plate;
    private int year;
    private boolean rent;

    public Car(String brand, String model, String plate, int year) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.year = year;
        this.rent = false;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public int getYear() {
        return year;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("Car{")
                .append("brand = ")
                .append(this.brand)
                .append(" ,model = ")
                .append(this.model)
                .append(" ,year = ")
                .append(this.year)
                .append(" ,plate = ")
                .append(this.plate);

        if(this.rent) {
            stringBuilder.append(" Wypożyczony}");
        } else {
            stringBuilder.append(" Wolny}");
        }

        return stringBuilder.toString();
    }
}
