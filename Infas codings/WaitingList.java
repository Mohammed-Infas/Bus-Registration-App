public class WaitingList {
    WaitingNode head, tail;

    // Method to add a reservation to the waiting list
    public void add(String no, int mob) {
        WaitingNode n1 = new WaitingNode(no, mob);
        if (head == null) {
            head = n1;
            tail = n1;
            tail.next = null;
        } else {
            tail.next = n1;
            n1.next = null;
            tail = n1;
        }
        System.out.println("Your Reservation is successful");
    }

    // Method to show the waiting list
    public void show() {
        WaitingNode n = head;
        if (n == null) {
			System.out.println(" ");
            System.out.println("--Waiting List Is Empty--");
        } else {
            System.out.println("***** Waiting List *****");
            while (n != null) {
                System.out.println("Bus Number: " + n.bus_number);
                System.out.println("Mobile Number: " + n.mobno);
                System.out.println();  // Blank line between waiting nodes
                n = n.next;
            }
        }
    }

    // Method to delete a reservation from the waiting list
    public WaitingNode deletewaiting() {
        if (head == null) {
            return null;
        } else {
            WaitingNode p = head;
            head = head.next;
            return p;
        }
    }
}