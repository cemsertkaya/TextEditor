/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project1;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;



/**
 *
 * @author cemgirgin and cemsertkaya
 */
public class MainController extends javax.swing.JFrame implements ActionListener {

    private ArrayList<Word> word_list = new ArrayList<>();
    public static JFrame popUpSaveFrame = new JFrame();//JFrame of the popUpScreen of save button
    public static JFrame selectorFrame = new JFrame();//JFrame of the selectorScreen of open button
    public static JFrame findAndChangeFrame = new JFrame();//JFrame of the findAndChangePanel of find&Change button
    private static String currentFileName = "";// holds the name of the current file's name
    private static boolean isFirstChange = false;
    private static boolean findAndChangeActivation = false;
   
    public MainController() 
    { 
        initComponents();
        //This module works in every 500 ms, for detecting the change of the currentFileName
        //This module works in every 500 ms, in order to detect if the FindAndChangePanel has been compeleted or not 
        Timer timer = new Timer();
                timer.schedule(new TimerTask() 
        {
           @Override
           public void run() {
              if (isFirstChange)//if it's first the opening of this file
              {
                  onChangeOfCurrentFile();
                  isFirstChange = false;
                  selectorFrame.setVisible(false);
              }
            if(getFindAndChangeActivation())
              {
                  jTextArea1.setText(findAndChange(getjTextArea1().getText(), FindAndChangePanel.getWordToFind(), FindAndChangePanel.getWordToChange()));
                  findAndChangeFrame.setVisible(false);
                  setFindAndChangeActivation(false);

              }  
           }
           
        }, 0, 500);
       
    }
    
    public void setWordList(ArrayList<Word> arrList){word_list = arrList;}
    public static void setFindAndChangeActivation(boolean bool){findAndChangeActivation = bool;}
    public static boolean getFindAndChangeActivation(){return findAndChangeActivation;}
    public javax.swing.JTextArea getjTextArea1() {return jTextArea1;}
     public static void setCurrentFileName(String newCurrent)
    {
        currentFileName = newCurrent;
        isFirstChange = true;        
    }
    public static String getCurrentFileName(){return currentFileName;}
        
    
    
    //opens the selected file
    public void onChangeOfCurrentFile()
    {
        if (getCurrentFileName() != "") // Checks if currrent file name is nor empty
        {
          try
          {
              String data = ""; 
              data = new String(Files.readAllBytes(Paths.get(MainController.currentFileName))); //Reads the file
              getjTextArea1().setText(data);
          }
          catch(IOException e)
          {
              System.out.print("IO ERROR");
          }      
        }
    }
    
    
    //Removes last character that is written
    public static String removeLastCharacter(String str) 
    {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
           result = str.substring(0, str.length() - 1);
        }
        return result;
     }
    
   
    public String correctMistakes(String text)
    {
        String[] newWords = text.split("[,\\.\\ \\;\\:\\\n\\\"\\!\\?]"); //Using .split() methods in order to ignore stated chars.
        for(int z = 0;z<newWords.length; z++)// Looping through newWords array
        {
            Word newWord = new Word(newWords[z].toLowerCase(Locale.ENGLISH));// Turning each index of the newWords into a lowercased word type object
            for(int k = 0; k<word_list.size(); k++)// Looping through word_list which contains the words from given txt file
            {
                boolean isFound = false;// bool variable to check if we found the match
                for(int y = 0; y<newWord.getPossible_Transpositions().size();y++ )// Looping through possible transpositions 
                {
                    if(word_list.get(k).getWord_String().equals(newWord.getPossible_Transpositions().get(y))) 
                    {
                        /*If the given word is a single transposition of a word from the text file then one
                        *of the transpositions of the given word must match the word from the txt file
                        */
                        String correctedString = word_list.get(k).getWord_String();// Correction of the transpositon with the equivalent word from txt file
                        if(!newWords[z].toLowerCase(Locale.ENGLISH).equals(correctedString))
                        {
                            text = findAndChange(text,newWords[z],correctedString);// Passing the corrected word into findAndChange method to fix single transpositions
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound) break;
                }
            }
        }
        return text;
    }
    public String findAndChange(String text, String wordToFind, String wordToChanged)
    {
        String[] newWords = text.split("[,\\.\\ \\;\\:\\\n\\\"\\!\\?]");//Using .split() methods in order to ignore stated chars.
        for(int z = 0;z<newWords.length; z++)// Looping through newWords array
        {
            String lowerNewWord = newWords[z].toLowerCase(Locale.ENGLISH);// Turning words into lowecased from the newWords array 
            String lowerWordToFind = wordToFind.toLowerCase(Locale.ENGLISH);// Turning wordToFind into lowercased
            if(lowerNewWord.equals(lowerWordToFind))//Checking if two words matched
                {
                   text = text.replaceAll(newWords[z], wordToChanged);//Finds it and replaces it
                }
        }
        return text;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        jMenuItem2.setText("New File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Open File");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setText("Save File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Close File");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem6.setText("Undo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Find&Change");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Correct Typos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //UNDO BUTTON
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jTextArea1.setText(removeLastCharacter(getjTextArea1().getText()));
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    //SEARCH&CHANGE BUTTON 
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FindAndChangePanel findPanel = new FindAndChangePanel();
        findAndChangeFrame.add(findPanel);
        findAndChangeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        findAndChangeFrame.setVisible(true);
        findAndChangeFrame.setSize(400,271);

    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    //CORRECT TYPOS BUTTON
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       jTextArea1.setText(correctMistakes(getjTextArea1().getText()));
    }//GEN-LAST:event_jMenuItem8ActionPerformed
    
    //CREATE BUTTON
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        setCurrentFileName("");
        getjTextArea1().setText("");
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    //OPEN BUTTON
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileSelector fileSelector = new JFileSelector();
        selectorFrame.add(fileSelector);
        selectorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selectorFrame.setVisible(true);
        selectorFrame.setSize(562,412);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    //SAVE BUTTON
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         //if the file has already created just saves
               if (getCurrentFileName().equals(""))
               {
                    SaveFilePanel newPanel = new SaveFilePanel();
                    popUpSaveFrame.add(newPanel);
                    popUpSaveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    popUpSaveFrame.setVisible(true);
                    popUpSaveFrame.setSize(269,249);
                    newPanel.setTextSavePanel(jTextArea1.getText());
               }
               else
               {
                   try
                   {
                        FileWriter newFileToWrite = new FileWriter(getCurrentFileName(), false);
                        newFileToWrite.write(getjTextArea1().getText());
                        newFileToWrite.close();
                   }
                   catch (IOException e)
                    {
                        e.printStackTrace();
                    }   
               }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    //CLOSE BUTTON
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        setCurrentFileName("");
        getjTextArea1().setText("");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
