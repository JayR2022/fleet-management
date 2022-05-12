package com.jr.fleet.main.service;

import com.jr.fleet.main.exceptions.CarNotFoundException;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jr.fleet.main.persistence.Cars;
import com.jr.fleet.main.persistence.FleetRepo;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FleetService {

//	 private List<Cars> garage = new ArrayList<>();
//	@Autowired
	private FleetRepo fleetRepo;
	
	public FleetService(FleetRepo fleetRepo) {
		super();
		this.fleetRepo = fleetRepo;
	}

	public List<Cars> addCar(List<Cars> car) {
		// Add new Person
//	        this.garage.add(car);
		return this.fleetRepo.saveAllAndFlush(car);
//		return this.fleetRepo.saveAndFlush(car);
		// Return last added Person from List
//	        return this.garage.get(this.garage.size() - 1);
	}

	public List<Cars> getAllCars() {
		// Return the whole List
//	        return this.garage;
		return this.fleetRepo.findAll();
	}

	public Cars updateCar(Long id, Cars car) {
//	        // Remove existing Person with matching 'id'
//	        this.garage.remove(id);
//	        // Add new Person in its place
//	        this.garage.add(id, car);
//	        // Return updated Person from List
//	        return this.garage.get(id);

		Optional<Cars> existingOptional = Optional.of(this.fleetRepo.findById(id).orElseThrow(CarNotFoundException::new));
		Cars existingCar = existingOptional.get();
		existingCar.setMake(car.getMake());
		existingCar.setModel(car.getModel());
		existingCar.setDoors(car.getDoors());
		existingCar.setEngineSize(car.getEngineSize());

		return this.fleetRepo.save(existingCar);
	}

	public boolean removeCar(Long id) {
		// Remove Person and return it

		this.fleetRepo.findById(id).orElseThrow(CarNotFoundException::new);
		this.fleetRepo.deleteById(id);
		return fleetRepo.existsById(id);

//		 return response;

//	        return this.garage.remove(id);
	}
	
	public List<Cars> findByEngineSize(int engineSize){
		return this.fleetRepo.findByEngineSize(engineSize);
	}
	
	public List<Cars> findByModel(String str){
		return this.fleetRepo.findByModel(str);
	}
	
	public List<Cars> findByMake(String makeName){
		return this.fleetRepo.findByMake(makeName);
	}

}
