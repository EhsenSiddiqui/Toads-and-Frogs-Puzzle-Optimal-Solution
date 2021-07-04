
package toadsandfrogspuzzle;

import java.util.*;


public class Graph {
    
    ArrayList<Vertex> AdjList= new ArrayList();
    
    Vertex States [];
    
    int Predecessors[];
    
    ArrayList<Vertex> ShortestPath = new ArrayList();
    
    public Graph(){
        
        
        
    }
    
    public void insert(StringBuilder ch){
        
        Vertex X=new Vertex(ch);
        
        AdjList.add(X);
        
        
    }
    
    public void createEdge(StringBuilder x, StringBuilder y){
        
        Vertex ref1=null;
        
        Vertex ref2=null;
        
        for(int i=0; i<AdjList.size(); i++){
            
            if(AdjList.get(i).ch.equals(x) || AdjList.get(i).ch.equals(y)){
                
                if(ref1==null){
              //      System.out.println("Putting "+AdjList.get(i).ch+" in ref 1");
                    ref1=AdjList.get(i);
                    
                    continue;
                    
                }
                else{
                    
        //   System.out.println("Putting "+AdjList.get(i).ch+" in ref 2");

                    ref2=AdjList.get(i);
                   // break;
                }
            }
            
            
   }
        
        
        
        
        if(ref1!=null && ref2!=null){
                
               
            ref1.neighbours.add(ref2);
            ref2.neighbours.add(ref1);
            
            }
        
        
        
        
    }
    
    
    public void DisplayAdjList(){
        
        
        for(int i=0; i<AdjList.size(); i++){
            
            System.out.println(AdjList.get(i).ch);
            
        }
    }
    
    public void DisplayGraph(){
        
        
          for(int i=0; i<AdjList.size(); i++){
            
              Vertex x=AdjList.get(i);
            System.out.println(x+" ---> "+x.neighbours);
            
        }
    }
    
    
     public void GenerateGraph(){
       
    
        Queue Q =new <Vertex>Queue(10000000);
      AdjList.add(new Vertex(new StringBuilder("TTTxFFF")));
      
      System.out.print(AdjList.get(0)+"\t");
       
       AdjList.get(0).visited=true;
      Q.Enqueue(AdjList.get(0));
      
      while(!Q.isEmpty()){
          
          Vertex F=(Vertex) Q.Dequeue();

          EnqueueChildrenOf(F, Q);
          
         // System.out.println("Children of "+F+" are "+F.neighbours);
          
      }
       
       
       allUnvisit();
       
   }
   
    public void EnqueueChildrenOf(Vertex X, Queue Q){
       
       ArrayList <StringBuilder> list=CreateNeighbours(X.ch); 
       for(int i=0; i<list.size(); i++){
           
           Vertex x=new Vertex(list.get(i));
           if(AdjList.contains(x)){
               
               int indexOfAlreadyContainedState=AdjList.indexOf(x);
               
              X.neighbours.add(AdjList.get(indexOfAlreadyContainedState));
               
               
           }
           else{
           insert(list.get(i));
        //  createEdge(X.ch, list.get(i));
           X.neighbours.add(AdjList.get(AdjList.size()-1));
           }
        
       } //End of loop for adding created or already existing children
    //   System.out.println("\nNeighbours of "+X+" are :"+X.neighbours+"\n");
               LinkedList <Vertex> L=new LinkedList();
               L=X.neighbours;
       
       
       for(int i=0; i<L.size(); i++){
           
          if(L.get(i).visited==false){
              L.get(i).visited=true;
        //   System.out.print(L.get(i)+"\t"); new update
           Q.Enqueue(L.get(i));
           
           }
           
           
       }
       
       
   }
    
    public ArrayList CreateNeighbours(StringBuilder str){
        
        int IndexOfx=str.indexOf("x");
        
        ArrayList Neighbours=new ArrayList();
        
        for(int i=IndexOfx-2; i<IndexOfx+3; i++){
            
            if(PossibleMove(str, i, IndexOfx)){
                
                StringBuilder Temp=MakeMove(str, i, IndexOfx);
                
                Neighbours.add(Temp);
                
                
            }
        }
        
        return Neighbours;
    }
    
    public StringBuilder MakeMove(StringBuilder str, int SourceIndex, int DestinationIndex){
       
       StringBuilder temp=new StringBuilder(str);
       
       temp.setCharAt(DestinationIndex, str.charAt(SourceIndex));
       
       temp.setCharAt(SourceIndex, 'x');
       
       return temp;
        
   }
    
    
    public boolean PossibleMove(StringBuilder str, int SourceIndex, int DestinationIndex){
        
         if (SourceIndex<0 || SourceIndex>str.length()-1)
             return false;
         else{
        if(str.charAt(SourceIndex)=='T'){
            
            return DestinationIndex > SourceIndex;
        }
        
        else{
            
            return DestinationIndex < SourceIndex;
        }
         }
        
    }
        
    
    public void DFS(){
        
        Stack <Vertex> STK=new Stack();
        Vertex A=AdjList.get(0);
        STK.push(A);
        A.visited=true;
        System.out.println(A);
        
       while(!STK.isEmpty()){
           
           LinkedList <Vertex> L=STK.peek().neighbours;
           
           if(STK.peek().ch.equals(new StringBuilder("FFFxTTT"))){
               
               String str="";
               while(!STK.isEmpty()){
                   System.out.println("Printing peek and popping");
                   str=str+STK.peek();
                   STK.pop();
               }
           }
           
          else if(L.size()==0){
               
               STK.pop();
               
               
           }
           
           else{
           for(int i=0; i<L.size(); i++){    //Iterating through neighbours of peek vertex at Stack
               
               if(L.get(i).visited==false){ //If any neighbour is unvisited
                   
                //   System.out.println(L.get(i));
                   L.get(i).visited=true;
                   STK.push(L.get(i));
             //      System.out.println("New peak "+STK.peek());
                   break;
               }
               
               
               else if(i==L.size()-1){ //If all neighbours have been visited
                   
                 //  System.out.println("Before popping peek is "+STK.peek());
                   STK.pop();
                   
                //   System.out.println("After popping new peak is "+STK.peek());
                   break;
               }
             
        } } } }
    
    
   public void BFS(){
       
       States=new Vertex[AdjList.size()];
       
       Predecessors=new int[AdjList.size()];
       
      Queue Q =new <Vertex>Queue(AdjList.size()+2);
      
      
       System.out.print(AdjList.get(0)+"\t");
       
       AdjList.get(0).visited=true;
      Q.Enqueue(AdjList.get(0));
      
      while(!Q.isEmpty()){
          
          Vertex F=(Vertex) Q.Dequeue();

          EnqueueChildrenForBFS(F, Q);
          
          
       }
      }
   
    public void EnqueueChildrenForBFS(Vertex X, Queue Q){
       
       LinkedList<Vertex> L=X.neighbours;
       int IndexOfPredecessor=AdjList.indexOf(X);
       for(int i=0; i<L.size(); i++){
           
          if(L.get(i).visited==false){
              L.get(i).visited=true;
           System.out.print(L.get(i)+"\t");
           int IndexOfState=AdjList.indexOf(L.get(i));
           States[IndexOfState]=L.get(i);
           Predecessors[IndexOfState]=IndexOfPredecessor;
           Q.Enqueue(L.get(i));
           
           }
           
           
       }
       
       
   }
    
    public void allUnvisit(){
        
        for(int i=0; i<AdjList.size(); i++){
            
            if(AdjList.get(i)==null)
                continue;
            else
                AdjList.get(i).visited=false;
            
            
        }
    }
   
   public void TraceBack(){
       
       int steps=0;
       int AnsIndex=AdjList.indexOf(new Vertex(new StringBuilder("FFFxTTT")));
       int SourceIndex=AdjList.indexOf(new Vertex(new StringBuilder("TTTxFFF")));
       String str=""+"FFFxTTT";
          do {
               
               int PredecessorIndex=Predecessors[AnsIndex];
               str=AdjList.get(PredecessorIndex)+"--->"+str;
               
               AnsIndex=PredecessorIndex;
               steps++;
           } while(AnsIndex!=SourceIndex);      
       
       
          System.out.println("\n\n\n");
          System.out.println(str);
          
          System.out.println("TOTAL STEPS FOR OPTIMAL SOLUTION: "+steps);
   }
   
   
  
       
       
   }
        
                
    


