/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.Controlador;
import Controlador.MedidasControlador;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JToggleButton;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class MainFrame extends javax.swing.JFrame {
    Controlador controlador;
    MedidasControlador medidasControlador ;   
    ScheduledExecutorService generalExecutor;

    
    public static int numbtns = 5; //Número de botones en la barra principal
    public JToggleButton[] togset = new JToggleButton[numbtns]; //Vector donde se agrupan los botones
    
    public MainFrame() {
        initComponents();
        customInitComponents();
        startclock();
        medidasControlador.startRandom();
        //Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor( new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "blank cursor");  //Para ocultar mouse y proporcionar la experiencia de pntalla táctil
        //this.setCursor(invisibleCursor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maineHeader = new javax.swing.JLabel();
        panelTime = new javax.swing.JPanel();
        lblHour = new javax.swing.JLabel();
        lblDay = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        btonClose = new javax.swing.JButton();
        panelMainCard = new javax.swing.JPanel();
        medidas1 = new Vista.Medidas();
        control1 = new Vista.Control();
        panelBotones = new javax.swing.JPanel();
        togMedidas = new javax.swing.JToggleButton();
        togControl = new javax.swing.JToggleButton();
        togEstimadores = new javax.swing.JToggleButton();
        togSettings = new javax.swing.JToggleButton();
        togRegistros = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 480));
        setMinimumSize(new java.awt.Dimension(800, 480));
        setPreferredSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 480));

        maineHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/Header2.png"))); // NOI18N

        panelTime.setBackground(new java.awt.Color(255, 255, 255));

        lblHour.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        lblHour.setForeground(new java.awt.Color(51, 51, 51));
        lblHour.setText("13:45 ");

        lblDay.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblDay.setForeground(new java.awt.Color(51, 51, 51));
        lblDay.setText("Domingo");

        lblDate.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(51, 51, 51));
        lblDate.setText("30 de Abril de 2017");

        btonClose.setText("x");
        btonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTimeLayout = new javax.swing.GroupLayout(panelTime);
        panelTime.setLayout(panelTimeLayout);
        panelTimeLayout.setHorizontalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addComponent(lblDay)
                        .addGap(30, 30, 30)
                        .addComponent(btonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTimeLayout.setVerticalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTimeLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHour)
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDay)
                            .addComponent(btonClose))
                        .addGap(0, 0, 0)
                        .addComponent(lblDate)))
                .addContainerGap())
        );

        panelMainCard.setPreferredSize(new java.awt.Dimension(400, 330));
        panelMainCard.setLayout(new java.awt.CardLayout());
        panelMainCard.add(medidas1, "medidas");
        panelMainCard.add(control1, "control");

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));

        togMedidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-medidas-off.png"))); // NOI18N
        togMedidas.setBorderPainted(false);
        togMedidas.setContentAreaFilled(false);
        togMedidas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-medidas-on.png"))); // NOI18N
        togMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togMedidasActionPerformed(evt);
            }
        });

        togControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-control-off.png"))); // NOI18N
        togControl.setBorderPainted(false);
        togControl.setContentAreaFilled(false);
        togControl.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-control-on.png"))); // NOI18N
        togControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togControlActionPerformed(evt);
            }
        });

        togEstimadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-estimadores-off.png"))); // NOI18N
        togEstimadores.setBorderPainted(false);
        togEstimadores.setContentAreaFilled(false);
        togEstimadores.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-estimadores-on.png"))); // NOI18N
        togEstimadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togEstimadoresActionPerformed(evt);
            }
        });

        togSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-settings.png"))); // NOI18N
        togSettings.setBorderPainted(false);
        togSettings.setContentAreaFilled(false);
        togSettings.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-settings-on.png"))); // NOI18N
        togSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togSettingsActionPerformed(evt);
            }
        });

        togRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-registros-off.png"))); // NOI18N
        togRegistros.setBorderPainted(false);
        togRegistros.setContentAreaFilled(false);
        togRegistros.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/botones/btn-registros-on.png"))); // NOI18N
        togRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togRegistrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(togMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(togRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(togControl, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(togEstimadores, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(togSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(togMedidas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togControl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togEstimadores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maineHeader, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelMainCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(maineHeader)
                .addGap(2, 2, 2)
                .addComponent(panelMainCard, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void togMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togMedidasActionPerformed
        setbtns(0);
        CardLayout cl = (CardLayout)(panelMainCard.getLayout());
        cl.show(panelMainCard, "medidas");
    }//GEN-LAST:event_togMedidasActionPerformed

    private void btonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonCloseActionPerformed
        if (!generalExecutor.isShutdown()) {
            generalExecutor.shutdown();
        }
        medidasControlador.getMedidasExecutor().shutdown();
        this.dispose();
    }//GEN-LAST:event_btonCloseActionPerformed

    private void togRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togRegistrosActionPerformed
        setbtns(1);
        CardLayout cl = (CardLayout)(panelMainCard.getLayout());
        cl.show(panelMainCard, "registros");
    }//GEN-LAST:event_togRegistrosActionPerformed

    private void togControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togControlActionPerformed
        setbtns(2);
        CardLayout cl = (CardLayout)(panelMainCard.getLayout());
        cl.show(panelMainCard, "control");
    }//GEN-LAST:event_togControlActionPerformed

    private void togEstimadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togEstimadoresActionPerformed
        setbtns(3);
    }//GEN-LAST:event_togEstimadoresActionPerformed

    private void togSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togSettingsActionPerformed
        setbtns(4);
    }//GEN-LAST:event_togSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private void customInitComponents() {
        togset[0] = togMedidas;
        togset[1] = togRegistros;
        togset[2] = togControl;
        togset[3] = togEstimadores;
        togset[4] = togSettings;
        int a = 5;
        //Inicialización de controladores
        medidasControlador = new MedidasControlador(medidas1);
        
    }
    
    private void setbtns(int i) { //Funcióm para evidenciar la presión del botón en la interfaz
        for (int j = 0; j < numbtns; j++) {
            if (j != i) 
                togset[j].setSelected(false);
            else
                togset[j].setSelected(true);            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonClose;
    private Vista.Control control1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel maineHeader;
    private Vista.Medidas medidas1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelMainCard;
    private javax.swing.JPanel panelTime;
    private javax.swing.JToggleButton togControl;
    private javax.swing.JToggleButton togEstimadores;
    private javax.swing.JToggleButton togMedidas;
    private javax.swing.JToggleButton togRegistros;
    private javax.swing.JToggleButton togSettings;
    // End of variables declaration//GEN-END:variables

        
    public Runnable clockThread = new Runnable() {   
        
        public void run() {
            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            //int sec = cal.get(Calendar.SECOND);
            
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year =  cal.get(Calendar.YEAR);
            
            
            lblHour.setText(String.format("%02d", hour) + ":" + String.format("%02d", min));
            lblDay.setText(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("es", "ES")));
            lblDate.setText(day + " de " + cal.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es", "ES")) + ", " + year);
         }
    };     
    
    private void startclock() {
        generalExecutor = Executors.newScheduledThreadPool(1);
        generalExecutor.scheduleAtFixedRate(clockThread, 0, 1, TimeUnit.MINUTES);
    }
    
    
}


