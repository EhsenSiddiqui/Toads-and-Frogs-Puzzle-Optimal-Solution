
package toadsandfrogspuzzle;


public class Queue<T> {
    
     Vertex[] Q; int F; int R;
//Constructor
 Queue(){
 Q=new Vertex[100];
 F=9; R=9;
 }
// Constructor
 Queue(int size){
 Q=new Vertex[size];
 F=size-1; R=size-1;
}

 public void Enqueue(Vertex obj){
     
     if(isFull()){
         
         System.out.println("The queue is FULL");
     }
     else{
         
         R=(R+1)%Q.length;
         Q[R]=obj;
     }
     
 }
public Vertex Dequeue(){
    
    if(isEmpty()){
        
        //System.out.println("The queue is empty");
       // throw new NullPointerException("The queue is empty");
        return null;
    }
    
    else{
        
        F=(F+1)%Q.length;
        return Q[F];
    }
    
    

}

public boolean isEmpty(){
    
return F==R;
}
public boolean isFull(){
    
    
    return ((R+1)%Q.length==F);


}


public String toString(){
    
    
    String str="";
    int i=0;
    
    if(isEmpty()){
        
        return null;
    }
    else{
        
        for( i=(F+1)%Q.length; i!=R; i=(i+1)%Q.length){
            
          
            str=str+Q[i]+" ";
            
        }
        
        
        
        return str+Q[i];
        
    }
    
   
    
}


}// class end