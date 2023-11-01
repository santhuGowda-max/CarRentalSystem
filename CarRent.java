package CarRentalSystem;

import java.util.ArrayList;

public class CarRent {
  private Car car;
  private Coustemer coustemer;
  private int days;
public CarRent(Car car, Coustemer coustemer, int days) {
	this.car = car;
	this.coustemer = coustemer;
	this.days = days;
}
public Car getCar() {
	return car;
}
public Coustemer getCoustemer() {
	return coustemer;
}
public int getDays() {
	return days;
}

 

	
}
