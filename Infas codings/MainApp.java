import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Customer s1 = new Customer();
        BusReg b1 = new BusReg();
        Reservation r1 = new Reservation();
        WaitingList w1 = new WaitingList();
        Scanner obj = new Scanner(System.in);
        s1.init();
        int choice = 0;
        while (choice <= 400) {
            System.out.println(" ");
            System.out.println("<<<<<<<<<<<<BusReserveApp>>>>>>>>>>>");
            System.out.println(" ");
            System.out.println("1. Register Customer");
            System.out.println("2. Show Customer");
            System.out.println("3. Register Bus");
            System.out.println("4. Show Registered Bus");
            System.out.println("5. Search Bus");
            System.out.println("6. Reserve Seat");
            System.out.println("7. Show Reserved Seat");
            System.out.println("8. Cancel Reserved Seat");
            System.out.println("9. Show Waiting List");
            System.out.println("10. Exit");
            System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
            System.out.println(" ");
            System.out.print("Please choose a number from 1 to 10: ");
            choice = obj.nextInt();
            if (choice == 1) {
                System.out.print("Enter Customer's Name: ");
                String na = obj.next();
                System.out.print("Enter Customer's Mobile Number: ");
                int mk = obj.nextInt();
                System.out.print("Enter Customer's E-Mail ID: ");
                String em = obj.next();
                System.out.print("Enter Customer's City: ");
                String city = obj.next();
                System.out.print("Enter Customer's Age: ");
                int age = obj.nextInt();
                s1.addCustomer(na, mk, em, city, age);
                System.out.println(" ");
                System.out.println("<<<----Customer Registered Successfully!!----->>>");
            } else if (choice == 2) {
                System.out.println(" ");
                System.out.println("<<<<---Registered_Customers---->>>>");
                System.out.println(" ");
                s1.showDetails();
            } else if (choice == 3) {
                System.out.print("Enter Bus's Number: ");
                String BN = obj.next();
                System.out.print("Enter Bus's total seats: ");
                int TS = obj.nextInt();
                System.out.print("Enter Bus's Starting Point: ");
                String SP = obj.next();
                System.out.print("Enter Bus's Ending Point: ");
                String EP = obj.next();
                System.out.print("Enter Bus's Starting Time: ");
                String ST = obj.next();
                System.out.print("Enter Bus's Fare: ");
                int fare = obj.nextInt();
                System.out.print("Enter Bus's Available Seat: ");
                int SA = obj.nextInt();
                b1.addBus(BN, TS, SP, EP, ST, fare, SA);
                System.out.println(" ");
                System.out.println("Bus Registered Successfully");
            } else if (choice == 4) {
                System.out.println(" ");
                System.out.println("<<<<<<<<<<Registered_Bus>>>>>>>>>>");
                System.out.println(" ");
                b1.showBDetails();
            } else if (choice == 8) {
                System.out.println("Enter Telephone Number");
                int tel = obj.nextInt();
                boolean searchMobile = r1.searchMobile(tel);
                if (!searchMobile) {
                    System.out.println(" ");
                    System.out.println("<<--No Reservation in This Mobile Number-->>");
                } else {
                    System.out.println("Enter Bus Number");
                    String BN = obj.next();
                    boolean searchBus = r1.searchBus(BN);
                    if (!searchBus) {
                        System.out.println(" ");
                        System.out.println("<<--No Reservation For This Bus Number-->>");
                    } else {
                        System.out.println("Enter Number of Seats to Cancel:");
                        int numSeats = obj.nextInt();
                        boolean result = r1.cancelSeats(BN, numSeats);
                        if (!result) {
                            System.out.println(" ");
                            System.out.println("<<--Failed to Cancel Reservation. Check Seat Count.-->>");
                        } else {
                            System.out.println(" ");
                            System.out.println("<<--Your booking has been cancelled-->>");
                            WaitingNode w = w1.deletewaiting();
                            if (w == null) {
                                System.out.println("<<--Waiting List is Empty-->>");
                            } else {
                                System.out.println("Bus Number: " + w.bus_number + " and mobile number: " + w.mobno + " Deleted from waiting list ");
                                int fare = b1.searchFare(w.bus_number);
                                String na = s1.searchCus(w.mobno);
                                r1.Reservebus(w.bus_number, w.mobno, na, fare, 1); // Assuming one seat reserved from waiting list
                                System.out.println(" ");
                                System.out.println("<<--Reservation Added-->>");
                            }
                        }
                    }
                }
            } else if (choice == 7) {
                r1.showReservation();
            } else if (choice == 6) {
                System.out.println("Enter mobile number:");
                int MN = obj.nextInt();
                String na = s1.searchCus(MN);
                if (na.equals("null")) {
                    System.out.println("Invalid Customer");
                } else {
                    System.out.println("Enter Bus Number:");
                    String BN = obj.next();
                    int fare = b1.searchFare(BN);
                    if (fare > 0) {
                        System.out.println("Enter Number of Seats to Reserve:");
                        int numSeats = obj.nextInt();
                        int result = b1.searchSeats(BN, numSeats); // Pass numSeats here
                        if (result == 1) {
                            r1.Reservebus(BN, MN, na, fare, numSeats);
                            System.out.println(" ");
                            System.out.println(numSeats + " Seat(s) Reserved Successfully.");
                        } else if (result == 0) {
                            System.out.println(" ");
                            System.out.println("<<--No Seats Available, Adding to Waiting List.-->>");
                            w1.add(BN, MN);
                            w1.show(); // Optionally show the waiting list
                        } else if (result == -1) {
                            System.out.println(" ");
                            System.out.println("<<--Bus Not Found.-->>");
                        }
                    }
                }
            } else if (choice == 5) {
                System.out.println("Enter Bus Number: ");
                String n = obj.next();
                b1.SearchBus(n);
            } else if (choice == 9) {
                w1.show();
            } else if (choice == 10) {
                break;
            }
        }
    }
}