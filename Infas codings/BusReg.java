import java.util.*;
    public class BusReg  {
    BusNode head,tail;
public void init(){
  head= null;
  tail= null;

}
public void addBus (String BN, int TS, String SP,String EP,String ST,int fare,int SA){
    BusNode n1= new BusNode(BN,TS,SP,EP,ST,fare,SA);
   if (head ==null){
     head=n1;
     tail=n1;
     tail.next=null;
   }
   else{
    tail.next= n1;
    n1.next=null;
    tail=n1;
   }
}// end of addBus
public void showBDetails() {
    BusNode a = head;
    while (a != null) {
        System.out.println("BusNO: " + a.BusNo);
        System.out.println("NoOfSeats: " + a.TotalSeat);
        System.out.println("Starting Point: " + a.StartingPoint);
        System.out.println("Ending Point: " + a.EndingPoint);
        System.out.println("Starting Time: " + a.StartingTime);
        System.out.println("Bus Fare: " + a.Fare);
        System.out.println("Seat Available: " + a.SeatAvailable);
        System.out.println();  // Blank line between buses
        a = a.next;
    }//end of while
}// end of showDetails

public void SearchBus(String BN){
BusNode n;
n=head;
boolean found;
found= false;
while(n!=null&& found ==false){
  if (BN.equals(n.BusNo))
       found=true;
  else 
     n=n.next;
}//end while

if (found==true){
  System.out.println("Bus Number: "+n.BusNo);
  System.out.println("Total Seats: "+n.TotalSeat);
  System.out.println("Starting Point: "+n.StartingPoint);
  System.out.println("Ending Point: "+n.EndingPoint);
  System.out.println("Starting Time: "+n.StartingTime);
  System.out.println("Fare: "+n.Fare);
  System.out.println("Available Seats: "+n.SeatAvailable);
}
else 
 System.out.println ("NotFound");
}
public int searchSeats(String BN, int numSeats) {
    BusNode n = head;
    boolean found = false;
    
    while (n != null && !found) {
        if (BN.equals(n.BusNo)) {
            found = true;
        } else {
            n = n.next;
        }
    }
    
    if (found) {
        if (n.SeatAvailable >= numSeats) {
            n.SeatAvailable -= numSeats;
            return 1; // Seats reserved successfully
        } else {
            return 0; // Not enough seats available
        }
    } else {
        return -1; // Bus not found
    }
}
public int searchFare(String BN)
{
  BusNode n=head;
  
  boolean found;
  found=false;
  while (n!=null && found==false)
  {
    if (BN.equals(n.BusNo))
        found=true;
    else
      n=n.next;
  }//end while
  if (found==true){
    return n.Fare;
    
  }
  else 
   return 0;
}


}
    


  


    



