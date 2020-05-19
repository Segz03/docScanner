
package documentscanner;

import java.util.*;
import java.io.*;

/**
 * @author Francisco J Segarra Jr, Tanya Badrljica
 */

public class DocScan
{
    // Constructor
    BST scan = new BST();
    
    public void ScanDocument(String file) throws IOException
    {
        // Scanner for reading in Alice
        File Alice = new File(file);
        Scanner alice = new Scanner(Alice);
        
        while(alice.hasNextLine())
        {
            String line = alice.nextLine();
            Scanner word = new Scanner(line);
            
            while(word.hasNext())
            {
                String key = word.next();
                key = key.replaceAll("\\." ,"");
                
                scan.insert(key);
                
            } // end while loop  
        } // end while loop    
        
        alice.close();
        
    } // end method
    
    public void search(String key)
    {
        scan.search(key);
    } // end method
    
    public void delete(String key)
    {
        scan.delete(key);
    } // end method
    
    public void PrintMaxWord()
    {
        Node max = scan.MaxWord();
        System.out.println(max.getKey() + " " + max.getCount());
    }        
    
    public void Print_Pre()
    {
        scan.Print_Preorder();
    } // end method
    
    public void Print_Post()
    {
        scan.Print_Postorder();
    } // end method
    
    public void Print_Inorder()
    {
        scan.Print_Inorder();
    } // end method
} // end class