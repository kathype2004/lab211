/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import hotel.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class FileManager {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public boolean writeToFile(String fileName, ArrayList<Hotel> hotels) {
        try {
            
            File f = new File(fileName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutput o = new ObjectOutputStream(fos);        
            for(Hotel i : hotels) {
                o.writeObject(i);
            }
            
            fos.close();
            o.close();
            System.err.println("Save data sucessfully!!");
            return true;
            
        }catch(Exception e) {
            System.err.println("Error write");
            return false;
        }
    }
    /**
     * read file
     */
    public boolean readFromFile(String fileName, ArrayList<Hotel> hotels) {
        try {
            // check file exist
            File f = new File(fileName);
            if(!f.exists()) {return false;}
            
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fis);
            
            if(f.length() == 0) {System.err.println("File is Empty!");}
            
            boolean check = true;   //use to break loop
            do {
                try {
                    Hotel h = (Hotel) oi.readObject();
                    hotels.add(h);
                }catch(Exception e) {
                    check = false;}
            }while(check);
            
            fis.close();
            oi.close();
            
        }catch(Exception e) {
            System.err.println("Error read");
            return false;
        }
        return true;
    }
}