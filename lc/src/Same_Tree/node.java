package Same_Tree;

public class node   
{   
    public String nodevalue;   
    public node leftchild, rightchild;  

    public node()   
    { }   
    public node(String value)   
    {   
        nodevalue = value;   
    }  

    public void assignchild(node left, node right)//设定左右孩子   
    {   
        this.leftchild = left;   
        this.rightchild = right;   
    }  

    public boolean hasleftchild()//是否有左孩子   
    {   
           
        {   
            return (leftchild != null);   
        }   
    }  

    public boolean hasrightchild()//是否有右孩子   
    {   
           
        {   
            return (rightchild != null);   
        }   
    }  

    public boolean haschild()//是否有右孩子   
    {   
           
        {   
            return hasleftchild() || hasrightchild();   
        }   
    }   
}   
