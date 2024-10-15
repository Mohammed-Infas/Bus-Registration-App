import java.util.*;
    public class Reservation {
    ReserveNode head, tail;

    public void init() {
        head = null;
        tail = null;
    }

    public void Reservebus(String BN, int MN, String name, int fare, int numSeats) {
        ReserveNode r1 = new ReserveNode(BN, MN, name, fare, numSeats);
        if (head == null) {
            head = r1;
            tail = r1;
            tail.next = null;
        } else {
            tail.next = r1;
            r1.next = null;
            tail = r1;
        }
    }

    public void showReservation() {
        ReserveNode r1 = head;
        while (r1 != null) {
            System.out.println("BusNumber: " + r1.BusNo);
            System.out.println("Mobile No: " + r1.MobileNo);
            System.out.println("Name: " + r1.Name);
            System.out.println("Fare: " + r1.Fare);
            System.out.println("Seats Reserved: " + r1.seatsReserved);
            System.out.println();  // Blank line between reservations
            r1 = r1.next;
        }
    }

    public boolean searchMobile(int MN) {
        ReserveNode n = head;
        while (n != null) {
            if (MN == n.MobileNo) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean searchBus(String BN) {
        ReserveNode n;
        n = head;
        boolean found = false;
        while (n != null && !found) {
            if (BN.equals(n.BusNo))
                found = true;
            else
                n = n.next;
        }
        return found;
    }

    public boolean cancelSeats(String BN, int numSeats) {
        ReserveNode n = head;
        ReserveNode prev = null;
        while (n != null) {
            if (BN.equals(n.BusNo)) {
                if (n.seatsReserved > numSeats) {
                    n.seatsReserved -= numSeats;
                    return true;
                } else if (n.seatsReserved == numSeats) {
                    if (prev == null) {
                        head = n.next;
                    } else {
                        prev.next = n.next;
                    }
                    if (n == tail) {
                        tail = prev;
                    }
                    return true;
                } else {
                    return false; // Not enough seats to cancel
                }
            }
            prev = n;
            n = n.next;
        }
        return false;
    }
}
