public class ReserveNode {
    String BusNo;
    int MobileNo;
    String Name;
    int Fare;
    int seatsReserved; // New field to track the number of seats reserved
    ReserveNode next;

    public ReserveNode(String BN, int MN, String name, int fare, int seatsReserved) {
        this.BusNo = BN;
        this.MobileNo = MN;
        this.Name = name;
        this.Fare = fare;
        this.seatsReserved = seatsReserved; // Initialize the new field
    }
}
