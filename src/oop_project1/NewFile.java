/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_project1;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author cemgirgin and cemsertkaya
 */
public class NewFile 
{
    private String text;
    private String path;
    
    public NewFile(String text, String path)
    {
        this.text = text;
        this.path = path;
        createNewPath(path);
    }
    public String getText()
    {
        return text;
    }
    public void setText(String newText)
    {
        text = newText;
    }
    public void createNewPath(String newPath)
    {
        try
        {
            File newFile = new File(newPath);
   
        if(newFile.createNewFile())
        {
            System.out.println("File created: " + newFile.getName());
            
        }
        else
        {
            System.out.println("File already exists");

        }
        }
        catch(IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        
    }
    
    
}
