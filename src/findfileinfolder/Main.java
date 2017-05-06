/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findfileinfolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 *
 * @author wook82
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FindFile ff = new FindFile();
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner("texto4.txt");
        //System.out.println("Enter the file to be searched.. " );
        String name = scan.next();
        //System.out.println("Enter the directory where to search ");
        //String directory = scan.next();
        String directory = "/Users/wook82/Documents";
        ff.findFile(name,new File(directory), true);
        
        
        String fileName = "/Users/wook82/Documents/carpeta/texto4.txt";
        String textSearch = "o349130964";
        Integer count = 1;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                //System.out.println(line);
                if(searchInLine(line, textSearch.trim())) {
                    System.out.println(count + " >> " +line);
                }
                count++;
            }
            // line is not visible here.
        } //end read file ... 
        
    }
    
    public static boolean searchInLine(String line, String textSearch){
        
        boolean finding = false ; 
        
        Scanner s = new Scanner(line);
         
        s.findInLine(textSearch);
        try {
            MatchResult result = s.match();
            for (int i=1; i<=result.groupCount(); i++)
                System.out.println(result.group(i));
            finding = true;
        } catch (IllegalStateException e) {
            //e.printStackTrace();
        }
        
        s.close();  
        return finding;
    }
    
}
