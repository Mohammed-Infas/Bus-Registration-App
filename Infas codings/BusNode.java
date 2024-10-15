public class BusNode {
    //Bus number, Total seat, starting point, ending point, Starting time, Fare)
    String BusNo;
    int TotalSeat;
    String StartingPoint ;
    String EndingPoint ;
    String StartingTime;
    int Fare;
    int SeatAvailable;
    BusNode next;

public BusNode (String BN, int TS, String SP,String EP,String ST,int fare,int SA){
    this.BusNo= BN;
    this.TotalSeat= TS;
    this.StartingPoint=SP;
    this.EndingPoint= EP;
    this.StartingTime=ST;
    this.Fare=fare;
    this.SeatAvailable=SA;
}
}
