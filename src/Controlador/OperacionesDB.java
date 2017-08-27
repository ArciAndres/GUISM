package Controlador;

import ModeloInterno.FormatMeasure;
import Modelos.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.lang.Object;

public class OperacionesDB {
    
    double[] quantityValues = new double[]{120,30,360,10,365,60,0.7};
    ScheduledExecutorService executor;
    
    public static void getSingleObject()
    {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Quantity.class);
        criteria.add(Restrictions.eq("id", 23));
//        criteria.add(Restrictions.eq("unit", "volio"));

        Quantity quantity = (Quantity)criteria.uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        //JOptionPane.showMessageDialog(null, "Single Measurement inserted correctly");
        JOptionPane.showMessageDialog(null, "Ejecutado correctamente: " + quantity.getDescription());
    }
    
        public static void getLastObject()
    {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Magnitude> result = session.createQuery("from Magnitude ORDER BY id DESC")
                          .setMaxResults(10)
                          .list();
        session.getTransaction().commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Single Measurement inserted correctly");
        
    }
        
    public static void getQuantityFromDB(){
        
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Magnitude.class)
                            .createAlias("quantities", "qt")
                            .add(Restrictions.like("qt.id", 19))
                            ;
        Magnitude magnitude = (Magnitude)criteria.uniqueResult();
        tx.commit();
       // instRegisters.stream().filter(r -> r.getPhase() == phaseFinal).collect(Collectors.toList()); //Ejemplo de filter
        //Quantity voltaje = quantities.stream().filter(q -> q.getId()==19).findFirst().get(); //18 = Voltaje RMS
        session.close();
    }
    public static List<Magnitude> getMagnitudesFromDB(){
        List<Magnitude> magnitudes;
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Magnitude");
        magnitudes = query.list();
        tx.commit();
        session.close();
        return magnitudes;
    }   
    
    public static List<Quantity> getQuantitiesFromDB(){
        List<Magnitude> magnitudes;
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Magnitude");
        magnitudes = query.list();
        tx.commit();
        
        List<Quantity> quantities = new ArrayList<Quantity>();
        for (Iterator<Magnitude> iterator = magnitudes.iterator(); iterator.hasNext();) {
             Magnitude next = iterator.next();
             for (Iterator<Quantity> iterator1 = next.getQuantities().iterator(); iterator1.hasNext();) {
                Quantity next1 = iterator1.next();
                quantities.add(next1);
            }
        }
        
        session.close();
        
        return quantities;
    }   
    
    public static void main(String[] args) throws FileNotFoundException {     
        //getSingleObject();
       // getLastObject();
       //getQuantitiesFromDB();
      
       //getMagnitudesFromDB();
    }
}
