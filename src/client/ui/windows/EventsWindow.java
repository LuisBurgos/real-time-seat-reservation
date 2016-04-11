/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ui.windows;

import client.controllers.EventsWindowCotroller;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import server.domain.Event;

/**
 *
 * @author JoseJulio
 */
public class EventsWindow extends javax.swing.JFrame implements ListSelectionListener {

    private EventsWindowCotroller mController;
    private ArrayList<Event> mEventList;
    
    public EventsWindow() {
        initComponents();
        mController = new EventsWindowCotroller(this);
    }

    public EventsWindow(ArrayList<Event> events) {
        this();
        mEventList = events;
        
        DefaultListModel listModel = new DefaultListModel();
        for (Event event : mEventList){
            listModel.addElement(event.getName());
            System.out.println(event.getName());
        }
        
        eventListView.setModel(listModel);
        eventListView.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        eventListView.setLayoutOrientation(JList.VERTICAL);
        eventListView.setVisibleRowCount(-1);
        eventListView.addListSelectionListener(this);
    }
    
     //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        
        if(!e.getValueIsAdjusting()){
            int rowSelect = eventListView.getSelectedIndex();
        
            if(rowSelect != -1){
                openSeatWindow();
            }
        }
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventListViewScrollPane = new javax.swing.JScrollPane();
        eventListView = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eventListView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        eventListView.setAutoscrolls(false);
        eventListViewScrollPane.setViewportView(eventListView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventListViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventListViewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EventsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventsWindow().setVisible(true);
            }
        });
    }
    
    public void openSeatWindow(){
        new ButtonSelectWindow().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> eventListView;
    private javax.swing.JScrollPane eventListViewScrollPane;
    // End of variables declaration//GEN-END:variables
}
