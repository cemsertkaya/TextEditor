/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project1;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author cemgirgin and cemsertkaya
 */
public class Word 
{
    private String wordString;
    private ArrayList<String> possibleTranspositions;
    
    public static ArrayList<ArrayList<String>> twoDimensionPossibleTranspositions = new ArrayList<ArrayList<String>>();
    public Word(String word_String)
    {
        this.wordString = word_String;
        this.possibleTranspositions = createPossibleTranspositions(word_String);
    }

    /**
     * @return the word_String
     */
    public String getWord_String() {
        return wordString;
    }

    /**
     * @param word_String the word_String to set
     */
    public void setWord_String(String word_String) {
        this.wordString = word_String;
    }

    /**
     * @return the possible_Transpositions
     */
    public ArrayList<String> getPossible_Transpositions() {
        return possibleTranspositions;
    }

    /**
     * @param possible_Transpositions the possible_Transpositions to set
     */
    public void setPossible_Transpositions(ArrayList<String> possible_Transpositions) {
        this.possibleTranspositions = possible_Transpositions;
    }
    
    public ArrayList<String> createPossibleTranspositions(String word)
    // Creates the possible transpositions by interchanging places ONLY two letters from the word
    {
        ArrayList<String> arr_list = new ArrayList<String>();
        for(int i = 0; i<word.length() ; i++)
        {
            for(int j = i+1; j<word.length() ; j++)
            {
                StringBuilder new_word = new StringBuilder(word);
                new_word.setCharAt(i,word.charAt(j));
                new_word.setCharAt(j, word.charAt(i));
                arr_list.add(new_word.toString());
            }
        }
        return arr_list;
    }
}
