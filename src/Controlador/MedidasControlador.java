/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloInterno.Fmeasure;
import ModeloInterno.FormatMeasure;
import Modelos.Magnitude;
import Modelos.Quantity;
import Vista.Medidas;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
    JLabel[] unitLabels;
    JLabel[] magLabels;
    ScheduledExecutorService executor;

    public MedidasControlador(Medidas medidas){
        medidasView = medidas;
        medidasView.setMedidasControlador(this);
    }
    
    public Runnable scriptRunnable = new Runnable() {   
        
        int measureSource = 1; //0 es aleartorio sencillo, 1 es desde el archivo de JSON
        List<Quantity> quantities = new OperacionesDB().getQuantitiesFromDB(); //Trae una lista de magnitudes, con cantidades incluídas de la base de datos
        int[] quantityIndex = {18,19,32,13};
//            ArrayList<byte[][]> registros = getRegisters(entrada);
//            JTable table = tabContainer.getTable_values();
//            DefaultTableModel model = (DefaultTableModel)table.getModel();
//            JScrollPane scroll = tabContainer.getScrollTable();
       
        int f = 2+3;
        
        public void run() {
            measureLabels = medidasView.getMeasureLabels();
            unitLabels = medidasView.getUnitLabels();
            magLabels = medidasView.getMagLabels();
            //measureLabels[0].setText("Prueba");
            double numero;
            numero = 0;
            
            if (measureSource == 0) {       
                for (int i = 0; i < 3; i++) { //Cada fila es una Línea (Fase)
                    for (int j = 0; j < 4; j++) { //Cada columna es una magnitud que se muestra
                         numero = (Math.random() * 100) + 1;
                         measureLabels[4*i+j].setText(String.format("%.2f", numero)) ;
                    }
                }
            }
            if (measureSource == 1) {
                FormatMeasure formatMeasure = null;
                try {
                    formatMeasure = customMethods.getFromJson(new FileReader(customMethods.getJsonAddrees()));
                     
                    Fmeasure fmeasure = null;
                    for (int i = 0; i < 3; i++) { //Cada fila es una Línea (Fase)
                        List<Fmeasure> fmeasures = formatMeasure.getFphases().get(i).getFmeasures();
                        for (int j = 0; j < 4; j++) { //Cada columna es una magnitud que se muestra
                            int quantityInd = quantityIndex[j];
                            fmeasure = fmeasures.stream().filter(f -> f.getQuantityID() == quantityInd).findFirst().get();
                            Fmeasure fmeasureFinal = fmeasure;
                            Quantity quantity = quantities.stream().filter(q -> q.getId() == fmeasureFinal.getQuantityID()).findFirst().get();
                            Magnitude magnitude = quantity.getMagnitude();
                                                        
                            measureLabels[i*4+j].setText(String.format("%.2f", fmeasure.getValue())) ;
                            if (j!=3) {
                                unitLabels[i*3+j].setText(magnitude.getUnitSymbol()) ; //Se pone i*3 porque solamente en esta ventana hay 3 columnas de unidades (Factor de Potencia no tiene unidad)
                                //Por cuestiones de tiempo se deja así, pero este procesimiento de indicar la unidad debería hacerse solamente una vez, y no iterar
                            }
                            if (i == 0){ //Se ejecuta solamente una vez por columna
                                magLabels[j].setText(quantity.getDescriptionShort());
                            }                            
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MedidasControlador.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error en Json probablemente. Puede que la medida que solicita no está en el archivo");

            }
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
