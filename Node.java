
package documentscanner;

/**
 * @author Francisco J Segarra Jr, Tanya Badrljica
 */

public class Node 
{
    Node leftChild;
    Node rightChild;
    private String key;
    private int count;
    
    // Constructor
    public Node(String k)
    {
        this.key = k;
        this.count = 0;
        leftChild = null;
        rightChild = null;
    } // end Constructor
    
    // setters
    public void setKey(String k)
    {
        key = k;
    }        
    
    public void setCount()
    {
        count++;        
    }
    
    public void setCount(int c)
    {
        count = c;
    }        
    
    public void setLeftChild(Node n)
    {
        leftChild = n;
    }        
    
    public void setRightChild(Node n)
    {
        rightChild = n;
    }
    
    
    
    // getters
    public String getKey()
    {
        return key;
    }        
    
    public int getCount()
    {
        return count;
    }        
    
    public Node getLeftChild()
    {
        return leftChild;
    }        
    
    public Node getRightChild()
    {
        return rightChild;
    }        
} // end class