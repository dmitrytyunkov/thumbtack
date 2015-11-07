package net.thumbtack.tyunkov.lessons.third.cars;

import net.thumbtack.tyunkov.lessons.fifth.ColorException;
import net.thumbtack.tyunkov.lessons.fourth.Color;
import net.thumbtack.tyunkov.lessons.third.Colored;

/**
 * Created by dmitry on 24.10.15.
 */
public class Car implements Colored {

    private String brand = new String();
    private int weight;
    private int maxSpeed;
    private Color color;

    public Car(String brand, int weight, int maxSpeed) {
        this(brand, weight, maxSpeed, Color.BLACK.toString());
    }

    public Car(String brand, int weight, int maxSpeed, String colorString) {
        this.brand = brand;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        setColor(colorString);
    }

    public void printInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Weight: " + weight);
        System.out.println("Maximum speed" + maxSpeed);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String colorString) {
        try {
            Color.fromString(colorString);
            color = Color.getColor();
        } catch (ColorException ex) {
            color = Color.BLACK;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (weight != car.weight) return false;
        if (maxSpeed != car.maxSpeed) return false;
        return brand.equals(car.brand);

    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + weight;
        result = 31 * result + maxSpeed;
        return result;
    }
}
