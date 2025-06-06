import java.util.Scanner;

public class GarageServicesApp {
    public static void main(String[] args) {
        GarageService garageservice = new GarageService();
        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.println("-----------Satoshi Car Service Center-----------");
            System.out.println("1: Add Customer");
            System.out.println("2: Offered Services");
            System.out.println("3: Exit");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter phone number: ");
                    String phone = sc.next();
                    System.out.print("Enter car number: ");
                    String carNum = sc.next();
                    System.out.print("Enter the car Model: ");
                    String model = sc.next();
                    garageservice.addCustomer(name,phone,carNum,model);
                    break;

                case 2:
                    System.out.print("Enter the car number: ");
                    String carNo = sc.next();
                    garageservice.createInvoice(carNo);
                    break;

                case 3:
                    System.out.println("Exiting... Thank You");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
