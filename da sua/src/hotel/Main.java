/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import static hotel.Menu.displayMenu;
import java.io.EOFException;
import java.util.Scanner;
import system.ManagementSystem;
/**
 *
 * @author ASUS
 */
public class Main {
    
    public static void main(String[] args) throws EOFException{
        boolean check = false;
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        ManagementSystem manage= new ManagementSystem();
        do{
            displayMenu();
            int choice = manage.inputInt("Enter Your Choice (1-7): ",1,7);
            switch(choice){
                case 1:
                    manage.AddHotel();
                    break;
                    
                case 2:
                    manage.CheckHotelExits();
                    break;
                
                case 3:
                    manage.UpdateHotel();
                    break;
                    
                case 4:
                    manage.deleteHotel();
                    break;
                    
                case 5:
                    manage.searchHotel();
                    break;
                    
                case 6:
                    manage.display_Hotel_List();
                    break;
                    
                default:
                    check = true;
                    System.out.println("Ending The Programing, Ciao~");
                    break;
            }
        } while(!check);
        
    }
}
