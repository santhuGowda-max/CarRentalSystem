package CarRentalSystem;

public class Car {
  private String id;

  private String module;
  private double basePrice;
  private String brand;
  private boolean isAviable;
  public Car(String id, String module, String brand,double basePrice) {
	this.brand=brand;
	this.id = id;
	
	this.module = module;
	this.basePrice = basePrice;
	this.isAviable=true;
}
  
  public String getCarId() {
	  return id;
  }

  public String getModule() {
	  return module;
  }
  public double getBasePrice(int days) {
	  return basePrice*days;
  }
  public boolean getAvilable() {
	  return isAviable;
  }
  
  public void carRent() {
	  isAviable=false;
  }
  
  public void carReturn() {
	  isAviable=true;
  }
  
  public String getBrand() {
	  return brand;
  }
	

}
