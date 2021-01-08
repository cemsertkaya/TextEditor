/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author cemgirgin and cemsertkaya
 */
class Main
{
    public static ArrayList<Word> word_list = new ArrayList<Word>(); // Array list in order to hold words from the txt file
    public static  ArrayList<String> transposition_list = new ArrayList<String>(); // Array list in order to hold all the possible transpositions
    public static void main(String args[])
     {
        
        try 
         // Attempt to read the txt file   
        {
          File myObj = new File("words.txt");
          Scanner myReader = new Scanner(myObj);
          int count = 0;
          while (myReader.hasNextLine()) 
          {
            String data = myReader.nextLine();
            Word new_word = new Word(data);// Creates a word object for each word in the txt file
            word_list.add(new_word);// Adds words into the array list
            ArrayList<String> dimension = new ArrayList<String>();
            dimension.add(new_word.getWord_String());
            for(String var : new_word.getPossible_Transpositions())// For each word, creates the possible transpositions
            {
                transposition_list.add(var);
                dimension.add(var);
            }
            
          }
          
          myReader.close();
        } catch (FileNotFoundException e) 
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                MainController newUIclass = new MainController();
                newUIclass.setWordList(word_list);
                newUIclass.setVisible(true);   
            }
            });           
    }
}
                