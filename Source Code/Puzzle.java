
package toadsandfrogspuzzle;
import java.util.*;

public class Puzzle {
    
    
    Graph Problem = new Graph();
    
    Stack STK=new Stack();
    
    public Puzzle(){
        
        
    }
    
    
    
  /*  public void RunSolution(){
        
        STK.push(new Vertex(new StringBuilder("TTTxFFF")));
        
                
        while(!STK.isEmpty()){
            
            Vertex temp=(Vertex) STK.peek();
            StringBuilder str=temp.ch;
            
            if(!PossibleMovesLeft((StringBuilder) STK.peek())){
                
                STK.pop();
            }
            
            else {
                int IndexOfx=str.indexOf("x");
                for(int i=IndexOfx-2; i<IndexOfx+3; i++ ){
                    
                    if(PossibleMove(str, i, IndexOfx)){
                        
                        StringBuilder newState=MakeMove(str,i,IndexOfx);
                        
                        if(temp.neighbours.contains(newState))
                            continue;
                        else{
                            
                            Vertex newVertex=new Vertex(newState);
                            temp.neighbours.add(newVertex);
                            STK.push(newVertex);
                            
                            
                            
                        }
                            
                        
                        
                    }
                    
                }
                
            }
            
            
            
        }
        
        
     }*/
    
  
    
    
  
   
   
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
   
     
     public boolean PossibleMovesLeft(StringBuilder str){
         
         int indexOfx=str.indexOf("x");
         
         for(int i=indexOfx-2; i<indexOfx+3; i++){
             
            if(PossibleMove(str, i, indexOfx)){
                
                return true;
            }
             
         }
         
         return false;
         
     }
   
    
   /* public boolean NoPossibleMovesLeft(int IndexOfx, StringBuilder str){
         
        //x here is index of x 
        
        if(IndexOfx==0){
            
            if(!(PossibleMove(str.charAt(IndexOfx+1),IndexOfx+1, IndexOfx) || PossibleMove(str.charAt(IndexOfx+2),IndexOfx+2, IndexOfx)))
            return true;
        }
        
        else if (IndexOfx==str.length()-1){
            
            if( !(PossibleMove(str.charAt(IndexOfx-1),IndexOfx-1,IndexOfx) || PossibleMove(str.charAt(IndexOfx-2),IndexOfx-2,IndexOfx)))
                return true;
        }
        
        else if(IndexOfx==1){
            
            if( !(PossibleMove(str.charAt(0),0,IndexOfx) || PossibleMove(str.charAt(2),2,IndexOfx)  || PossibleMove(str.charAt(3),3,IndexOfx)))
              return true;
             }
        
        else if(IndexOfx==str.length()-2){
        if( !(PossibleMove(str.charAt(str.length()-1),str.length()-1,IndexOfx) || PossibleMove(str.charAt(IndexOfx-1),IndexOfx-1,IndexOfx)  || PossibleMove(str.charAt(IndexOfx-2),IndexOfx-2,IndexOfx)) ) // TTTFFxF
          return true;
            
            }
        else if(!(IndexOfx-2<0) && !(IndexOfx+2>=str.length())){
            
            if( !(PossibleMove(str.charAt(IndexOfx-2),IndexOfx-2,IndexOfx) || PossibleMove(str.charAt(IndexOfx-1),IndexOfx-1,IndexOfx) || PossibleMove(str.charAt(IndexOfx+1),IndexOfx+1,IndexOfx) || PossibleMove(str.charAt(IndexOfx+2),IndexOfx+2,IndexOfx))  )
               
                return true;
                
        }
        
        return false;
    }
    
    public boolean PossibleMove(char X, int SourceIndex, int DestinationIndex){
        
        if(X=='T'){
            
            return DestinationIndex > SourceIndex;
        }
        
        else{
            
            return DestinationIndex < SourceIndex;
        }
        
    }*/
    
    
    
    
    
    
    
    
    
    
}
