import java.util.* ;

public class ParkingSpot(){

	private final String vehicleType;
	private final int floorNumber;
	private final String spotId ;
	private boolean isEmpty; //true

	public ParkingSpot(String vehicleType, int floorNumber){

		this.vehicleType = vehicleType;
		this.floorNumber = floorNumber;
		this.spotId = UUID.randomUUID().toString();
		this.isEmpty = true;
	}

	public boolean isParkingSpotEmpty(){

		return this.isEmpty;
	}

	public void occupy(){

		this.isEmpty = false;

	}

	public void freeSpot(){

		this.isEmpty = true;

	}
	
}
