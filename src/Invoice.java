import java.util.*;

public class Invoice {
    private Customer customer;
    private List<Service> serviceList;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addService(Service service){
        serviceList.add(service);
        totalAmount += service.getPrice();
    }

    public void printInvoice(){
        System.out.println("------------------Invoice------------------");
        System.out.println("Customer: "+customer.getName()+ " | Phone: "+customer.getPhone());
        System.out.println("Car: "+customer.getCar().getMadel()+ " | Number: "+customer.getCar().getCarNumber());
        System.out.println("Service: ");
        for(int i=0; i < serviceList.size(); i++){
            System.out.println(i+1+ " " + serviceList.get(i).getName()+ ": \u20B9"+serviceList.get(i).getPrice());
        }
        System.out.println("Total Amount: \u20B9" + totalAmount);
        System.out.println("------------------Thank You------------------");
    }
}
