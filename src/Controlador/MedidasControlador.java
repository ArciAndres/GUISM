/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Medidas;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class MedidasControlador {
    Medidas medidasView;
    JLabel[] measureLabels;
    ScheduledExecutorService executor;

    public MedidasControlador(Medidas medidas){
        medidasView = medidas;
        medidasView.setMedidasControlador(this);
    }
    
    public Runnable scriptRunnable = new Runnable() {   
        

//            ArrayList<byte[][]> registros = getRegisters(entrada);
//            JTable table = tabContainer.getTable_values();
//            DefaultTableModel model = (DefaultTableModel)table.getModel();
//            JScrollPane scroll = tabContainer.getScrollTable();
        public void run() {
            measureLabels = medidasView.getMeasureLabels();
            double numero ;
            measureLabels[0].setText("Prueba");

            for (int i = 0; i < 10; i++) {
                numero = (Math.random() * 100) + 1;
                measureLabels[i].setText(String.format("%.2f", numero)) ;
            }
    //         String[] medidas = getMedidas(registros);
    //         model.addRow(medidas);
    //         scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
    //         table.setRowSelectionInterval(model.getRowCount(), 0);
    //         model.fireTableDataChanged();

         }
    };         

    public void startRandom() {
       
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(scriptRunnable, 0, 1, TimeUnit.SECONDS);
        
    }
    
    
    public ScheduledExecutorService getMedidasExecutor(){
        return executor;
    }
};
