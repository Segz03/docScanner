
package documentscanner;

/**
 * @author Francisco J Segarra Jr, Tanya Badrljica
 */

public class BST 
{
    private Node root;
    
    // Constructor that creates an empty BST
    public BST()
    {
        root = null;        
    }
    
    public BST(Node r)
    {
        root = r;
    }
    
    public boolean isEmpty()
    {
        if (root == null)
            return true;
        else
            return false;
    } 
    
    public int HashGenerator(String key)
    {
        double hash = 0.0;
        int base;
        int power;
        
        for (int i=0; i<key.length(); i++)
        {
            base = (int)key.charAt(i)-96;
            power = (i==0)?3:2;
            hash += Math.pow(base, power)*Math.PI/(i+1);
        }
        
        return (int)(hash*Math.E*5/key.length());
    } // end method

    public void insert(String key)
    {
        Node newNode = new Node(key);
        
        insert(newNode, root);
        
    } // end method 
    
    public void insert(Node newNode, Node temp)
    { 
        // creating the edge cases 
        // if the root is empty
        if(this.isEmpty())
        {
            root = newNode;
            root.setCount();
            
        } // end if
        
        else
        {
            
            int HVTemp = HashGenerator(temp.getKey());
            int HVNewNode = HashGenerator(newNode.getKey());
            
            if (HVTemp == HVNewNode)
            {
                temp.setCount();
            } // end else if
        
            else
            {    
                if (HVTemp > HVNewNode)
                {   
                    if (temp.getLeftChild() == null)
                    {
                        temp.setLeftChild(newNode);
                        newNode.setCount();
                    } // end if

                    else
                    {
                        temp = temp.getLeftChild();
                        insert(newNode, temp);
                    } // end if
                } // end if

                else 
                {   
                    if(temp.getRightChild() == null)
                    {
                       temp.setRightChild(newNode);
                       newNode.setCount();
                    } // end if

                    else
                    {
                        temp = temp.getRightChild();
                        insert(newNode, temp);
                    } // end else
                } // end else
            } // end else 
        } // end else
    } // end method
      
  
    public void search(String key)
    {
        Node newNode = new Node(key);
        
        search(newNode, root);
        
    } // end method
    
    public void search(Node newNode, Node temp)
    {
        if(this.isEmpty())
        {
            System.out.println("The tree is empty");
        } // end if
        else
        {
            int HVTemp = HashGenerator(temp.getKey());
            int HVNewNode = HashGenerator(newNode.getKey());
            
            if (HVTemp == HVNewNode)
            {
                System.out.println(temp.getKey()+ " " + temp.getCount());
            } // end if
            
            else
            {
                if (HVTemp > HVNewNode)
                {   
                    if (temp.getLeftChild() == null)
                    {
                        System.out.println("Does Not Exist");
                    } // end if

                    else
                    {
                        temp = temp.getLeftChild();
                        search(newNode, temp);
                    } // end else
                } // end if
                
                else
                {
                    if(temp.getRightChild() == null)
                    {
                        System.out.println("Does Not Exist");
                    } // end if

                    else
                    {
                        temp = temp.getRightChild();
                        search(newNode, temp);
                    } // end else 
                } // end else 
            } // end else
        } // end else
    } // end method
    
    boolean found = false;
    
    public void delete(String key)
    {
        Node newNode = new Node(key);
        
        delete(newNode, root);
           
    } // end method
    
    public void delete(Node newNode, Node temp)
    {
        if(this.isEmpty())
        {
            System.out.println("The tree is empty");
        } // end if
        
        else
        {
            int HVTemp = HashGenerator(temp.getKey());
            int HVNewNode = HashGenerator(newNode.getKey());
            
            if (HVTemp == HVNewNode)
            {
                System.out.println(temp.getKey()+ " " + temp.getCount());
            } // end if
            
            
            
        } // end else    
    } // end method
    
    public boolean isLeaf(Node temp)
    {
        if (temp.getLeftChild() == null && temp.getRightChild() == null)
            return true;
        
        else
            return false;
    } // end method
    
    public void Print_Preorder()
    {
        Print_Preorder(root);  
    } // end method
    
    public void Print_Postorder()
    {
        Print_Postorder(root);  
    } // end method
    
    public void Print_Inorder()
    {
        Print_Inorder(root);  
    } // end method
    
    public void Print_Preorder(Node root) 
    {
        System.out.println(root.getKey() + " " + root.getCount());
        if (root.getLeftChild() != null)
            Print_Preorder(root.getLeftChild());
        if (root.getRightChild() != null)
            Print_Preorder(root.getRightChild());
    } // end method
    
    // method to print post order
    private void Print_Postorder(Node root) 
    {
        if (root.getLeftChild()!= null)
            Print_Postorder(root.getLeftChild());
        if (root.getRightChild() != null)
            Print_Postorder(root.getRightChild());
            System.out.println(root.getKey() + " " + root.getCount());
    } // end method
    
    // method to print in order
    private void Print_Inorder(Node root) 
    {
        if (root.getLeftChild() != null)
            Print_Inorder(root.getLeftChild());
            System.out.println(root.getKey() + " " + root.getCount());
        if (root.getRightChild() != null)
            Print_Inorder(root.getRightChild());
    } // end method
    
    // creating a node to send back for the max count
    Node max = new Node("name");
    
    public Node MaxWord()
    {        
        Node max = MaxWord(root);
        return max;
    } // end Method
    
    public Node MaxWord(Node root)
    { 
        if (max.getCount() < root.getCount())
        {
            max.setKey(root.getKey());
            max.setCount(root.getCount());
            
            if (root.getLeftChild() != null)
            {
                MaxWord(root.getLeftChild());
            }

            if (root.getRightChild() != null)
            {
                MaxWord(root.getRightChild());
            }
        } // end if
        
        return max;
    } // end method
} // end class