/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author cemgirgin and cemsertkaya
 */
public class SaveFilePanel extends javax.swing.JPanel  
{
    /**
     * Creates new form SaveFilePanel
     */
    private String textSavePanel = "";
    public SaveFilePanel() 
    {
        initComponents();
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
               
               String fileName = jTextField1.getText();
               if (!fileName.equals("")) //Checks if input is empty or not
               {
                    fileName = fileName + ".txt"; // Adds .txt extend to file name
                    System.out.println(fileName);
                    NewFile newFile = new NewFile("",fileName); //Creates the new file
                    MainController.setCurrentFileName(fileName); //Sets filename to currentfilename
                    try
                    //Gets the text from the textArea and then writes it into the file    
                    {
                        FileWriter myWriter = new FileWriter(MainController.getCurrentFileName()); 
                        myWriter.write(getTextSavePanel());
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    }
                    catch (IOException e) 
                    {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    MainController.popUpSaveFrame.setVisible(false);
                   
                    
               }
           }
        });
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Please enter the file name");

        jButton1.setText("Create File");
        jButton1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the textSavePanel
     */
    public String getTextSavePanel() {
        return textSavePanel;
    }

    /**
     * @param aTextSavePanel the textSavePanel to set
     */
    public void setTextSavePanel(String aTextSavePanel) {
        textSavePanel = aTextSavePanel;
    }

}

