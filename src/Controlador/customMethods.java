/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloInterno.FormatMeasure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.net.InetAddress;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class customMethods {

    static String getJsonAddrees() {
         if (customMethods.getHost().equals("raspberrypi")) { //Se asigna la ruta para leerse desde la página web
         String dirString = "/home/pi/webApp/SGMUdenarApp/public/json/";
         File dir = new File(dirString);

             if (!dir.exists()) {   
                try{
                    System.out.println("creating directory: " + dir.getName());
                    new File(dirString).mkdirs(); //Se rean los respectivos directorios
                    try (Writer writer = new FileWriter("Output.json")) {
                    Gson gson = new GsonBuilder().create();}
                }
                catch(Exception ex){
                    System.out.println(ex.toString());
                }
             }
             return("/home/pi/webApp/SGMUdenarApp/public/json/db.json");
             //jsonAddress = "db.json";
         }
         else{
             return("D:\\Dropbox\\Tesis\\SGMUdenarApp\\public\\json\\db.json"); //Debería ser algo más general, pero para este caso la dejaremos así
         }
    }
    
    static String getHost(){
        String hostname = "Unknown";
        try{
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            System.out.println(hostname);

        }
        catch(Exception ex){
            System.out.println("Host could not be resolved");
        }
        return hostname;
    }
    
    public static FormatMeasure getFromJson(FileReader address){
       Gson gson = new Gson();
       FormatMeasure obj = gson.fromJson(address,FormatMeasure.class);
       return obj;
    }
    
    public void getQuantityByID(){
        
    }
}
