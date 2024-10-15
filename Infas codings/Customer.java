import java.util.*;
public class Customer {
    CusNode head,tail;
public void init(){
  head= null;
  tail= null;
}
public void addCustomer( String na, int mk, String em,String city,int age){
    CusNode n1= new CusNode(na,mk,em,city,age);
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
}// end of addCustomer
public void showDetails() {
        CusNode a = head;
        while (a != null) {
            System.out.println("Name: " + a.CustomerName);
            System.out.println("MobNo: " + a.MobileNo);
            System.out.println("EmailID: " + a.Email);
            System.out.println("City: " + a.City);
            System.out.println("Age: " + a.Age);
            System.out.println();  // Blank line between customers
            a = a.next;
        } //end of while
}// end of showDetails

public String searchCus(int mk){
  CusNode n;
  n=head;
  boolean found;
  found = false;
  while(n!=null && found ==false){
    if(mk ==n.MobileNo)
      found=true;
    else
      n= n.next;
  }
  if (found==true){
    return n.CustomerName;
  }
  else{
    return("null");
  }
  }
}
    
 


    

