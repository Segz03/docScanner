/*

WARNING: we have not finished the delete method but everything else works
perfectly and we will be sending you a revised copy when delete is finished

*/
package documentscanner;

/**
 * @author Francisco J Segarra Jr, Tanya Badrljica
 */

import java.io.*;

public class DocumentScanner
{ 
    public static void main(String[] args) throws IOException
    {
        DocScan MJ = new DocScan();
        
        MJ.ScanDocument("AliceDemo.txt");
        
        //MJ.search("the");
        
        //MJ.Print_Pre();
        //MJ.Print_Post();
        //MJ.Print_Inorder();
        
        //MJ.PrintMaxWord();
        
    } // end main 
} // end class