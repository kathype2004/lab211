/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author ASUS
 */
public class Hotel {
    private String Hotel_id;
    private String Hotel_Name;
    private int Hotel_room_available;
    private String Hotel_Address;
    private String Hotel_Phone;
    private double Hotel_Rating;
    
    public Hotel(){};
    public Hotel(String Hotel_id, String Hotel_Name,String Hotel_Address,
                 int Hotel_room_available,
                 String Hotel_Phone,double Hotel_Rating){
        
        this.Hotel_Address = Hotel_Address;
        this.Hotel_Name = Hotel_Name;
        this.Hotel_Phone = Hotel_Phone;
        this.Hotel_id = Hotel_id;
        this.Hotel_Rating = Hotel_Rating;
        this.Hotel_room_available = Hotel_room_available;
    }

    

    public String getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(String Hotel_id) {
        this.Hotel_id = Hotel_id;
    }

    public String getHotel_Name() {
        return Hotel_Name;
    }

    public void setHotel_Name(String Hotel_Name) {
        this.Hotel_Name = Hotel_Name;
    }

    public int Hotel_room_available() {
        return Hotel_room_available;
    }

    public void setHotel_room_available(int Hotel_room_available) {
        this.Hotel_room_available = Hotel_room_available;
    }

    public String getHotel_Address() {
        return Hotel_Address;
    }

    public void setHotel_Address(String Hotel_Address) {
        this.Hotel_Address = Hotel_Address;
    }

    public String getHotel_Phone() {
        return Hotel_Phone;
    }

    public void setHotel_Phone(String Hotel_Phone) {
        this.Hotel_Phone = Hotel_Phone;
    }

    public double getHotel_Rating() {
        return Hotel_Rating;
    }

    public void setHotel_Rating(double Hotel_Rating) {
        this.Hotel_Rating = Hotel_Rating;
    }
    
    public void display() {
        System.out.println("--------------------");
        System.out.println("Hotel ID: " + Hotel_id);
        System.out.println("Hotel Name: " + Hotel_Name);
        System.out.println("Room Available: " + Hotel_room_available);
        System.out.println("Address: " + Hotel_Address);
        System.out.println("Phone: " + Hotel_Phone);
        System.out.println("Rating: " + Hotel_Rating);
        System.out.println("--------------------");
    }

    Object getHotelId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
