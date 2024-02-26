/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import hotel.Hotel;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ManagementSystem{

    private ArrayList<Hotel> hotels;
    private final Scanner sc;
    private FileManager fm;

    // Constructor
    public ManagementSystem() throws EOFException {
        this.sc = new Scanner(System.in);
        this.hotels = new ArrayList<>();
        fm = new FileManager();
        
        fm.readFromFile("Hotel.dat", hotels);
    }

  
    //Formant ID
    public String getHotelId(String mess) {
        String id = formatData(mess, "H\\d{2}");
        return id.toUpperCase();
    }
    
    public void display_A_Hotel(Hotel object) {
        System.out.println("==========*==========");
        System.out.println("Hotel_ID: " + object.getHotel_id());
        System.out.println("Hotel_Name: " + object.getHotel_Name());
        System.out.println("Hotel_Room_Available: " + object.Hotel_room_available());
        System.out.println("Hotel_Address: " + object.getHotel_Address());
        System.out.println("Hotel_Phone: " + object.getHotel_Phone());
        System.out.println("Hotel_Rating: " + object.getHotel_Rating());
        System.out.println("==========*==========");
    }
    
    private String formatData(String mess, String pattern) {
        String result = "";
        Scanner sc= new Scanner(System.in);
        do {
            System.out.print(mess);
            result = sc.nextLine().toUpperCase();
            if(!result.matches(pattern)) {
                System.out.println("Wrong format");
            }
        }while(!result.matches(pattern));
        return result;
    }
    
    public boolean checkInputYN(String mess) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            
            if(input.equalsIgnoreCase("Y")||input.equalsIgnoreCase("Yes")) return true;
            
            else if(input.equalsIgnoreCase("N")||input.equalsIgnoreCase("No")) return false;
            
            else {
                System.err.println("Please input Yes(Y) or No(N).");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public boolean checkDuplicateID(ArrayList<Hotel> hotels, String hotel_Id) {
        for(Hotel i : hotels) {
            if(i.getHotel_id().equalsIgnoreCase(hotel_Id)) {return true;}
        }
        return false;
    }
    
    public boolean checkDuplicatePhone(ArrayList<Hotel> hotels, String hotel_Phone) {
        for(Hotel i : hotels) {
            if(i.getHotel_Phone().equalsIgnoreCase(hotel_Phone)) {return true;}
        }
        return false;
    }
    
    public String Hotel_ID(String mess){
        Scanner sc= new Scanner(System.in);
        String id = formatData(mess, "H\\d{2}");
        return id.toUpperCase();
    }
    
    public String nonBlank(String mess) {
    String input = "";
    do {
        System.out.print(mess);
        input = sc.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Data can not be empty");
        }
    } while (input.trim().isEmpty());
    return input;
}
    
    public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            
            try {
                int number = Integer.parseInt(input);
                
                //check max min
                if((number < min || number > max) || number < 0) {
                    System.err.print("Please input between from " + min + " to " + max + " please : ");
                    continue;
                }
                return number;
            }catch(Exception e) {
                System.err.print("Please input an integer number: ");
            }
        }
    }
    
     public double inputRate(String mess, double min, double max) {
        System.out.print(mess);

        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());

                // check min and max range
                if (number < min || number > max || number < 0) {
                    System.err.print("Please input a number between " + min + " and " + max + " (non-negative): ");
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.err.print("Please input a valid number: ");
            }
        }
    }
    
    //1.Add Hotel
    public void AddHotel(){
        String ID = Hotel_ID("Enter Hotel ID (HXX): ");
        if(checkDuplicateID(hotels, ID)){
            System.out.println("The Hotel Already Exists");
            return;
        }
        
        String Name = nonBlank("Enter Hotel Name(No Blank): ");
        
        String Address = nonBlank("Enter Hotel Address(No Blank): ");

        String Phone = formatData("Enter Hotel Phone(09XXXXXXXXX): ","09\\d{8}");
        if(checkDuplicatePhone(hotels, Phone)){
            System.out.println("Duplicate Phone Numbers");
            return;
        }
        
        int Room = inputInt("Enter Current Avaiable Room: ",0,Integer.MAX_VALUE);
        
        double Rate = inputRate("Enter Hotel Rating: ",0,9) ;
        
        boolean choice = checkInputYN("Do You Want To Add This Hotel?(Yes(Y) or No(N)): ");
        if(choice){
//            hotels.add(new Hotel(hotel_Id, hotel_Name, room_Avaiable, hotel_Adress, hotel_Phone, hotel_Rate));
            fm.writeToFile("Hotel.dat", hotels);
            System.out.println("Hotel added successfully!");
        }
        
        boolean re = checkInputYN("Do You Want To Create New Hotel?(Yes(Y) or No(N)): ");
        if(re){
            AddHotel();
        }
    }   
    
    //2.Checking exits Hotel.
    public void CheckHotelExits(){
        String ID = Hotel_ID("Enter Hotel ID you want to sreach (HXX): ");
        if(checkDuplicateID(hotels, ID)){
            System.out.println("The Hotel Already Exists");
        } else {
            System.out.println("The Hotel Hasn't In The Database");
        }
        boolean re = checkInputYN("Do You Want To Check Another Hotel?(Yes(Y) or No(N)): ");
        if(re){
            CheckHotelExits();
        }
    }
    
    //3. Updating Hotel information.
    public void UpdateHotel(){
        String ID = Hotel_ID("Enter Hotel ID you want to sreach (HXX): ");
        if(checkDuplicateID(hotels, ID)){
            System.out.println("Found The Hotel.");
             String Name = nonBlank("Enter Hotel Name(No Blank): ");
        
        String Address = nonBlank("Enter Hotel Address(No Blank): ");

        String Phone = formatData("Enter Hotel Phone(09XXXXXXXXX): ","09\\d{8}");
        
        int Room = inputInt("Enter Current Avaiable Room: ",0,Integer.MAX_VALUE);
        
        double Rate = inputRate("Enter Hotel Rating: ",0,9) ;
        
        boolean choice = checkInputYN("Do You Want To Add This Hotel?(Yes(Y) or No(N)): ");
        if(choice){
        fm.writeToFile("Hotel.dat", hotels);

        System.out.println("Hotel updated successfully!");
        }
        } else {
            System.out.println("The Hotel Hasn't In The Database");
        }
    }
    
    //4. Deleting Hotel
    public void deleteHotel() {
    String ID = Hotel_ID("Enter Hotel ID you want to delete (HXX): ");
    Hotel hotelToDelete = null;

    for (Hotel hotel : hotels) {
        if (hotel.getHotel_id().equalsIgnoreCase(ID)) {
            hotelToDelete = hotel;
            break;
        }
    }

    if (hotelToDelete != null) {
        boolean confirmation = checkInputYN("Do you really want to delete this hotel (Yes(Y) or No(N)): ");
        
        if (confirmation) {
            hotels.remove(hotelToDelete);
                fm.writeToFile("Hotel.dat", hotels);
                System.out.println("Delete hotel success");
        } else {
            System.out.println("Deletion canceled.");
        }
    } else {
        System.out.println("No hotel found for Hotel ID " + ID);
    }
}
    
    //5. Searching
    public void searchHotel(){
        boolean continueSearching = true;
                
        do{
            System.out.println("*==========*Hotel Searching*==========*");
            System.out.println("1. Search By ID");
            System.out.println("2. Search By Name");
            System.out.println("3. Return To Menu");
            int choice = inputInt("Enter Your Choice:",1,3);
            
            switch(choice){
            case 1:
                int countID=0;
                String ID = Hotel_ID("Enter ID Hotel: ");
                Collections.sort(hotels, (Hotel hotel1, Hotel hotel2) -> hotel1.getHotel_id().compareTo(hotel2.getHotel_id()));
                for(Hotel i : hotels) {
                    if(i.getHotel_id().contains(ID.toUpperCase())) {
                        Hotel found1 = i;
                        display_A_Hotel(found1);
                        countID++;
                    }
                    
                }
                if(countID == 0)
                {System.out.println("Hotel does not exist!");}
                continueSearching = checkInputYN("Do You Want To Make Another Search(Yes(Y) or No(N)): ");
                break;
                
                
                
            case 2:
                int countName=0;
                String name = nonBlank("Enter Hotel Name: ");
                for(Hotel i: hotels){
                    if(i.getHotel_Name().contains(name)){
                        Hotel found = i;
                        countName++;
                        display_A_Hotel(found);
                        System.out.println("Total: "+countName);
                        System.out.println("==========*==========");
                        
                    }
                }
                continueSearching = checkInputYN("Do You Want To Make Another Search(Yes(Y) or No(N)): ");
                break;
            
            case 3:
                System.out.println("Returning To The Main Menu");
                continueSearching = false;
                break;
                
            default:
                System.out.println("Invalid Choice");
                break;
            }
        } while(continueSearching);
    }

    
    
    
    public void display_Hotel_List() {
        Collections.sort(hotels, (Hotel hotel1, Hotel hotel2) -> -hotel1.getHotel_Name().compareTo(hotel2.getHotel_Name()));
        if(hotels.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        
         System.out.println("==========*==========");
        for(Hotel i : hotels) {
            System.out.println("Hotel ID: " + i.getHotel_id());
            System.out.println("Hotel Name: " + i.getHotel_Name());
            System.out.println("Hotel Room Available: " + i.Hotel_room_available());
            System.out.println("Hotel Address: " + i.getHotel_Address());
            System.out.println("Hotel Phone: " + i.getHotel_Phone());
            System.out.println("Hotel Rating: " + i.getHotel_Rating());
         System.out.println("==========*==========");
                        }
    }
}
