/// Implement and Interfaces

/// Interface : similar to abstract but a class can implements many interface
Ex 1 : Example of interfaces
interface IVolume{ 
	public void increaseVolume();     
	public void decreaseVolume();
 }  
interface IChanel {  
   public void nextChangel(); 
   public void previousChangel(); 
}  
interface INetwork{ 
	public void connectNetwork(); 
    public void disconnectNetwork(); 
}

Ex 2 : Class implementation by using interfaces
class Radio implements IVolume, IChanel {
	  public void increaseVolume(){ }
      public void decreaseVolume(){}
       public void nextChangel() {         ...     }    
      public void previousChangel() {         ...     } 
 }






