/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class Controlador {
    
    public Controlador(){};
    
    ScheduledExecutorService executor;
    
    

    
    private static Runnable clockRunnable = new Runnable(){
        
        public void run(){
            
        }
    };
}


