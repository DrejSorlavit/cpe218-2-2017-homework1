import java.util.Stack;
import java.util.Scanner;
 
public class Homework1 {
 
    public static Stack<Character> queStack = new Stack<Character>();
    public static Node tree;
    static class Node{
        Character data;
        Node left,right;
        public Node(char key) {
            data = key;
        }
        public String toString() {
            return data.toString();
        }
    }
   
    public static void main(String[] args) {
        // Begin of arguments input sample
        System.out.print("input : ");
        Scanner Question = new Scanner(System.in);
        String input = Question.nextLine();
       
        // TODO: Implement your project here
 
        for(int i = 0; i < input.length(); i++)
        {
            queStack.add(input.charAt(i));
        }
 
        tree = new Node(queStack.pop());
        infix(tree);
        inorder(tree);
 
 
        System.out.print(" = ");
        System.out.print(calculate(tree));
 
        TreeDemo.main(args);
 
    }
   
    static void infix(Node n){
 
        if(isOperator(n.data)){
               
            n.right = new Node(queStack.pop());
            infix(n.right);
            n.left = new Node(queStack.pop());
            infix(n.left);
        }
    }
           
    static void inorder(Node n){
       
        if(isOperator(n.data))
        {
            if(n!=tree)
            {
                System.out.print("(");
            }
            inorder(n.left);
            System.out.print(n.data);
            inorder(n.right);
                if(n!=tree)
                {
                    System.out.print(")");
                }
 
        }else{ System.out.print(n.data);
            }
    }
    
    static boolean isOperator(char sign){
        return sign== '+' || 
	       sign== '-' ||
	       sign== '*' || 
	       sign== '/';
    }
	
    static int calculate(Node n) {
       
            if (n.data == '+') return calculate(n.left) + calculate(n.right);
            
            if (n.data == '-') return calculate(n.left) - calculate(n.right);
            
            if (n.data == '*') return calculate(n.left) * calculate(n.right);
            
            if (n.data == '/') return calculate(n.left) / calculate(n.right);
            
	    return Integer.parseInt(n.data.toString());
    }
}
