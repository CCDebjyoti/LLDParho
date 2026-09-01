ParkingLot --> Manager class

// Assuming we are having same no of spots for Cars, Bike and BigCars in every floor
// parkingFloor.getNoOfCarSpots() -->
// 2 Design Patterns -> Proxy, Builder Pattern
// We are assuming that we go ahead with a flat hourlyRate for now, else we can go ahead with diff StrategyPattern

import java.util.*;

public class ParkingLot {
	
private final Map<Integer, ParkingFloor> parkingFloorMap; // Map<int,parkingFloorConfiguration of that floor>
private final int noOfFloors;
private final double hourlyRate;

// Constructor for DI
// We are using a Dummy ParkingFloor class to get all the required details
// Ideally this should come from FloorConfig class

public ParkingLot(int noOfFloors, double hourlyRate, ParkingFloor parkingFloorConfig) {
	parkingFloorMap = new HashMap<>();
	this.noOfFloors = noOfFloors;
	this.hourlyRate = hourlyRate;
	populateFloorConfiguration(noOfFloors, parkingFloorConfig);
}


private void populateFloorConfiguration(int noofFloors, ParkingFloor parkingFloorConfig) {
	
	for(int currentFloor = 0; currentFloor < noOfFloors; currentFloor++) {
		int noOfCarSpots = parkingFloorConfig.getNoOfCarSpots();
		int noOfBikeSpots = parkingFloorConfig.getNoOfBikeSpots();
		int noOfBigCarSpots = parkingFloorConfig.getNoOfBigCarSpots();

		parkingFloorMap.put(currentFloor, new ParkingFloor(noOfCarSpots, noOfBikeSpots, noOfBigCarSpots));
	}	
}

public ParkingTicket entry(Vehicle currentVehicle) {

	for(int currentFloor = 0; currentFloor < noOfFloors; currentFloor++)
	{
		ParkingFloor currentFloor = parkingFloorMap.get(currentFloor);

		ParkingSpot currentSpot = currentFloor.getFreeSpot(currentVehicle.vehicleType);
		currentSpot.occupy();
		Instant entryTime = Instant.now();
		return new Ticket(currentSpotId, vehicle.getVehicleId(), entryTime);
	}
}

public double exit(Ticket ticket) {
	int currentSpotId = ticket.getParkingSpotId();
	ParkingSpot occupiedSpot = ParkingFloor.getActiveParkingSpotById(currentSpotId);

	occupiedSpot.free();
	ParkingFloor.freeActiveSpot(occupiedSpot.getVehicleType(), occupiedSpot);

	Duration parked = Duration.between(ticket.getEntryTime(), Instant.now());
	long billedHours = Math.max(1, (parked.toMinutes() + 59) / 60);  // ceil, min 1 hour
	return billedHours * hourlyRate;
	}

}
