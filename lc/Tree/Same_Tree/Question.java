package Same_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node node_a = new node("a");   
        node node_b = new node("b");   
        node node_c = new node("c");   
        node node_d = new node("d");   
        node node_e = new node("e");   
        node node_f = new node("f");   
        node node_g = new node("g");   
        node node_h = new node("h");   
        node node_i = new node("i");   
        //构造一棵二叉树   
        node_a.assignchild(node_b, node_c);   
        node_b.assignchild(node_d, node_e);   
        node_c.assignchild(node_f, node_g);   
        node_e.assignchild(node_h, node_i);  

        System.out.println("maxDepth:" + maxDepth(node_a));   
        preorder_visit_depth(node_a, 1);   
        System.out.println();  

        node node_1 = new node("1");   
        node node_2 = new node("2");   
        node node_3 = new node("3");   
        node node_4 = new node("4");   
        node node_5 = new node("5");   
        node node_6 = new node("6");   
        node node_7 = new node("7");   
        node node_8 = new node("8");   
        node node_9 = new node("9");   
        node node_10 = new node("10");   
        node node_11 = new node("11");   
        node node_12 = new node("12");   
        node node_13 = new node("13");  

        //构造一棵二叉树   
        node_1.assignchild(node_2, node_3);   
        node_2.assignchild(node_4, node_5);   
        node_3.assignchild(null, node_7);   
        node_5.assignchild(node_6, null);   
        node_7.assignchild(node_8, null);   
        node_8.assignchild(node_9, null);   
        node_9.assignchild(node_10, node_11);   
        node_10.assignchild(null, node_12);   
        node_6.assignchild(null, node_13); 
        
        node nodeA1 = new node("1");   
        node nodeA2 = new node("2");  
        node nodeB1 = new node("1");   
        node nodeB2 = new node("2");  
        nodeA1.assignchild(nodeA2, null);  
        nodeB1.assignchild(null, nodeB2);  


        System.out.println("maxDepth:"+maxDepth(node_1));   
        preorder_visit_depth(node_1, 1);   
        System.out.println();  
        StringBuffer sb = new StringBuffer(""); 
        if (isSameTree(nodeA1, nodeB1)){
            System.out.println("Same!");  

        }else{
        	System.out.println("NOT Same!");  
        }
        preorder_visit_depth(nodeA1, 1); 
        preorder_visit_depth(nodeB1, 1); 
/*        StringBuffer sb1 = StringBuffer("abc");
        StringBuffer sb2 = "abc";*/

	}
	
	
	//计算深度   search from web
    static int maxDepth(node root)   
    {   
        if (root == null)   
        {   
            return 0;   
        }   
        else   
        {   
            int leftdepth = maxDepth(root.leftchild);//递归计算左孩子的深度   
            int rightdepth = maxDepth(root.rightchild);//递归计算右孩子的深度  

            if (leftdepth >= rightdepth)   
            {   
                return leftdepth + 1;   
            }   
            else   
            {   
                return rightdepth + 1;   
            }   
        }   
    } 
    
    //先序遍历 //DLR   
    static void preorder_visit_depth(node Anode,int depth)   
    {   
        System.out.println(Anode.nodevalue + "-depth:" + depth);   
        depth++; 
        if (Anode.hasleftchild())   
        {   
            preorder_visit_depth(Anode.leftchild, depth);   
        }  

        if (Anode.hasrightchild())   
        {   
            preorder_visit_depth(Anode.rightchild, depth);   
        }   
    } 
   
    //this method will time out in leedcode oj...REASON is StringBuffer! Try StringBuilder
 public static boolean isSameTree(node p, node q) {	 
	 StringBuilder sb1 = new StringBuilder("");
	 StringBuilder sb2 = new StringBuilder("");
	 StringBuilder sb3 = new StringBuilder("");
	 StringBuilder sb4 = new StringBuilder("");
     return (preOrder(p, sb1).equals(preOrder(q, sb2)) && inOrder(p, sb3).equals(inOrder(q, sb4)) );
    }
 
 public static String preOrder(node root,StringBuilder sb){
	 
	 if ( root!= null){
		 sb.append(root.nodevalue);
		 System.out.println(root.nodevalue + ","); 
		 preOrder(root.leftchild,sb);
		 preOrder(root.rightchild,sb);
	 }
	 return sb.toString();
 }
 
 public static String inOrder(node root, StringBuilder sb){
	
	 if ( root!= null){		 
		 inOrder(root.leftchild, sb);
		 sb.append(root.nodevalue);
     	 System.out.println(root.nodevalue + ",");  
		 inOrder(root.rightchild, sb);
	 }
	 return sb.toString();
 }
 

	
	

}
