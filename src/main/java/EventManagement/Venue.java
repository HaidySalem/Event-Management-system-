/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package first.eventmangmentsystem;

/**
 *
 * @author ASUS
 */
public class Venue {
    
    private String name;
    private int capacity;
    private String location;

    public Venue(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }
    
    public void setName(String name) {
        this.name=name;
    }

    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }

    public void settLocation(String location) {
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    
}
