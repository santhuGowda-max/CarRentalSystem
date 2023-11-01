package CarRentalSystem;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentalSystem rental=new RentalSystem();
		Car car=new Car("CSU01","@HO73","Honda",200);
		Car car1=new Car("CSU02","@TO86","Toyota",300);
		Car car2=new Car("CSU03","@SH73","Shift",150);
		rental.addCar(car);
		rental.addCar(car1);
		rental.addCar(car2);
		rental.menu();
		
		
	}

}
