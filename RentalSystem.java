package CarRentalSystem;

import java.util.List;
import java.util.*;

public class RentalSystem {
     private List<Car> cars;
     private List<Coustemer> coustomers;
     private List<CarRent> rentals;
     
     public RentalSystem() {
    	 cars=new ArrayList<>();
    	 coustomers=new ArrayList<>();
    	 rentals=new ArrayList<>();
     }
     
     public void addCar(Car car) {
    	 cars.add(car);
     }
     public void addCoustomer(Coustemer coustemer) {
    	 coustomers.add(coustemer);
     }

     public void rentCar(Car car1,Coustemer coustemer1,int days) {
    	 if(car1.getAvilable()) {
    		 car1.carRent();
    		 rentals.add(new CarRent(car1,coustemer1,days));
    	 }
    	 else {
    		 System.out.println("Car is not avilablr for Rent7");
    	 }
     }
     
     public void returnCar(Car car) {
    	 car.carReturn();
    	 CarRent rentRemove=null;
    	 for(CarRent rental:rentals) {
    		if( rental.getCar()==car) {
    			rentRemove=rental;
    			break;
    		}
    	 }
    	 if(rentRemove!=null) {
    		 rentals.remove(rentRemove);
    		 System.out.println("Car returned Successfully");
    	 }
    	 else {
    		 System.out.println("Car was not returned : ");
    	 }
     }
     
     public void menu() {
    	 Scanner sc=new Scanner(System.in);
    	 boolean notExit=true;
    	 while(notExit) {
    		 System.out.println("*=====Car Rental System =====*");
    		 System.out.println("1. Rent a Car");
    		 System.out.println("2. Return a Car");
    		 System.out.println("3. Exit");
    		 System.out.println("Enter your choice");
    		 
    		 int choice=sc.nextInt();
    		 sc.nextLine();
    		 if(choice==1) {
    			 System.out.println("\n==Rent a car");
    			 System.out.print("Enter your name : ");
    			 String CostomerName=sc.next();
    			 for(Car car:cars) {
    				 if(car.getAvilable()) {
    					 System.out.println(car.getCarId()+" - "+car.getModule()+" "+car.getBrand());
    				 }
    			 }
    			 System.out.println("Enter the car ID you want to rent: ");
    			 String carId=sc.next();
    			 System.out.println("Enter the number of days for rent: ");
    			 int rentDays=sc.nextInt();
    			 sc.nextLine();
    			 
    			 
    			 Coustemer newCostomer =new Coustemer("CUS"+(coustomers.size()+1),CostomerName);
    			 addCoustomer(newCostomer);
    			 
    			 Car selectCar=null;
    			 for(Car car:cars) {
    				 if(car.getCarId().equals(carId)&&car.getAvilable()) {
    					 selectCar=car;
    					 break;
    				 }
    			 }
    			 
    			 if(selectCar!=null) {
    				 double totalPrice=selectCar.getBasePrice(rentDays);
    				 System.out.println("\n==Rental Information ==\n");
    				 System.out.println("Customer Id: "+newCostomer.getCoustomerId());
    				 System.out.println("Customer name: "+newCostomer.getCustomerName());
    				 System.out.println("Car :"+selectCar.getModule()+" "+selectCar.getBrand());
    				 System.out.println("Rental Days: "+rentDays);
    				 System.out.println("Total Price : "+totalPrice);
    				 
    				 System.out.println("\nConform rental(Y/N");
    				  String confirm =sc.next();
    				  
    				 if(confirm.equalsIgnoreCase("Y")) {
    					 rentCar(selectCar,newCostomer,rentDays);
    					 System.out.println("Car rented successfully");
    				 }else {
    					 System.out.println("Rental Canceled");
    				 }
    			 }
    			 else {
    				 System.out.println("\nInvalid car Selection or car not available for rent");
    			 }
    		
    		 
    		 }
    		 else if(choice==2) {
    			 System.out.println("\n==Return a Car==\n");
    			 System.out.print("Enter the car you want to return: ");
    			 String carId=sc.next();
    			 Car carReturn=null;
    			 Coustemer CustomerName=null;
//    			 Car car=null;
    			for(CarRent findCar:rentals) {
    				carReturn=findCar.getCar();
    				  CustomerName=findCar.getCoustemer();
    				if(carReturn.getCarId().equals(carId)) {
    					carReturn=findCar.getCar();
    					break;
    				}
    			}
    			if(carReturn!=null) {
    				System.out.println("Car return successfully :"+CustomerName.getCustomerName());
    				returnCar(carReturn);
    			}
    			else {
    				System.out.println("Car was not returned");
    			}
    			
    
    			
    		 }
    		 else if(choice==3) {
    			 System.out.println("Thanks you for using Car Renatal Sysytem");
    			 notExit=false;
    		 }
    	 }
    	 
    	
    
    	 
     }
  

}
