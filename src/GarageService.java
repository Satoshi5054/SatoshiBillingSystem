import java.util.*;

public class GarageService {
    private Map<String,Customer> customersMap;
    private List<Service> availableServices;
    Scanner sc = new Scanner(System.in);

    public GarageService() {
        this.customersMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadService();
    }

    public void loadService(){
        availableServices.add(new Service("Car Wash", 500));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
        availableServices.add(new Service("Tyre Replacement", 3000));
        availableServices.add(new Service("Puncher", 50));
    }

    public void addCustomer(String name,String phone,String carNumber,String model){
       Car car = new Car(carNumber,model);
       Customer customer = new Customer(name,phone,car);
        customersMap.put(carNumber,customer);
        System.out.println("Customer added successfully");
    }

    public void createInvoice(String carNumber){
        if(!customersMap.containsKey(carNumber)){
            System.out.println("No Customer found with car number: "+ carNumber);
            return;
        }
        Customer customer = customersMap.get(carNumber);
        Invoice invoice = new Invoice(customer);
        while(true){
            System.out.println("Available Services:");
            for(int i=0 ; i<availableServices.size();i++){
                System.out.println((i+1)+": "+ availableServices.get(i).getName() + " \u20B9"
                                    + availableServices.get(i).getPrice());
            }
            System.out.println("0: To print Invoice \n");
            System.out.println("Enter Service Number to add: ");
            int choice= sc.nextInt();
            if(choice == 0 ) {
                invoice.printInvoice();
                break;
            }
            if(choice>0 && choice<= availableServices.size()){
                invoice.addService(availableServices.get(choice-1));
                System.out.println("Service Finished");
            }
            else{
                System.out.println("Invalid Service");
            }

        }


    }
}
