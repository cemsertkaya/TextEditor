/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import oop_project1.MainController;
import oop_project1.Word;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cemgirgin and cemsertkaya
 */
public class NewJUnitTest {
    
    public NewJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testCorrectMistakes() // Tests if correctMistakes method works properly
    {
        ArrayList<Word> newArrList = new ArrayList<>();
        MainController newClass = new MainController();
        String expected = "aalii"; // Expected value after the process executed
        Word newWord = new Word(expected);
        newArrList.add(newWord);
        newClass.setWordList(newArrList);
        String falseOne = "aaili";
        String newString = newClass.correctMistakes(falseOne);
        assertEquals(expected,newString); // Checks if the value from the method executed matches the expected value. If so test been executed successfully
    }
    @Test 
    public void testMainControllerClass()  // Tests if object is created in MainController 
    {
        MainController newClass = new MainController();
        assertNotNull("Object is not created ", newClass); 
    }
    @Test
    public void removeLastCharTest() // Tests if removeLastCharachter method works properly
   {
        MainController newClass = new MainController();
        String expected = "Ce"; // Expected value after the process executed
        String tryOut = "Cem";
        String newStr = newClass.removeLastCharacter(tryOut);
        assertEquals(expected,newStr); // Checks if the value from the method executed matches the expected value. If so test been executed successfully
    }
    
    @Test
    public void testFindAndChange() // Tests if findAndChange method works properly
    {
        MainController newClass = new MainController();
        String expected = "Besiktas, Fenerbahce, Basaksehir"; // Expected value after the process executed
        String wordToChange = "Galatasaray";
        String newWord = "Basaksehir";
        String text = "Besiktas, Fenerbahce, Galatasaray";
        String returnVal = newClass.findAndChange(text, wordToChange, newWord);
        assertEquals(expected,returnVal); // Checks if the value from the method executed matches the expected value. If so test been executed successfully
    }
    
}
