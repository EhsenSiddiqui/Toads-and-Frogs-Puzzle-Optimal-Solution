
package toadsandfrogspuzzle;

import java.util.*;

public class ToadsAndFrogsPuzzle {

   
    public static void main(String[] args) {
       
        
        
       /* Puzzle X=new Puzzle();
        
        
        Stack STK = new Stack();
        
        
        Vertex v=new Vertex(new StringBuilder("xxxx"));
        
        STK.push(v);
        
Vertex f=  (Vertex)STK.peek();

        System.out.println(f.ch);
        
        
        StringBuilder a=new StringBuilder("A");
        StringBuilder b= new StringBuilder(a);
        
        b.setCharAt(0, 'B');
        
        System.out.println(a+" "+b);
        
        
        LinkedList L=new LinkedList();
        
        L.add(new Vertex(new StringBuilder("A")));
        
        
       // System.out.println(X.NoPossibleMovesLeft(6, str));*/
       
       Graph X=new Graph();
       
       X.GenerateGraph();
       
       
       X.DisplayGraph();
       // System.out.println("Printing Stack");
      // X.DFS();
        
      //  System.out.println(X.AdjList.get(3).neighbours);
      
     // ArrayList<Vertex> A=new ArrayList();
      
   X.BFS();
   
   X.TraceBack();
    }
    
   
}
