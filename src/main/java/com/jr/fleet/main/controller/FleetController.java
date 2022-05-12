package com.jr.fleet.main.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jr.fleet.main.persistence.Cars;
import com.jr.fleet.main.service.FleetService;



@RestController
public class FleetController {

    private FleetService service;

    public FleetController(FleetService service) {
        super();
        this.service = service;
    }

    // CRUD methods
    @PostMapping("/create")
    public ResponseEntity<List<Cars>> addCar(@RequestBody List<Cars> car) {
        return new ResponseEntity<List<Cars>>(this.service.addCar(car),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cars>> getAllCars() {
        return new ResponseEntity<List<Cars>>(this.service.getAllCars(),HttpStatus.OK);
    }
    
    @GetMapping("/engine/{engineSize}")
    public ResponseEntity<List<Cars>> getByEngineSize(@PathVariable int engineSize){
    	return new ResponseEntity<List<Cars>>(this.service.findByEngineSize(engineSize),HttpStatus.OK);
    }
    
    @GetMapping("/model/{model}")
    public ResponseEntity<List<Cars>> getByModel(@PathVariable String model){
    	return new ResponseEntity<List<Cars>>(this.service.findByModel(model),HttpStatus.OK);
    }
    
    @GetMapping("/make/{make}")
    public ResponseEntity<List<Cars>> getByMake(@PathVariable String make){
    	return new ResponseEntity<List<Cars>>(this.service.findByMake(make),HttpStatus.OK);
    }
    

    @PutMapping("/update/{id}")
    public ResponseEntity<Cars> updateCar(@PathVariable int id, @RequestBody Cars car) {
        return new ResponseEntity<Cars>(this.service.updateCar((long) id, car),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> removePerson(@PathVariable long id) {
        return new ResponseEntity<Boolean>(this.service.removeCar(id),HttpStatus.OK);
    }
}
//@RestController
//public class FleetController {
//
//	protected List<Cars> fleetList = new ArrayList<Cars>() {
//
//		{
//			add(new Cars(1L, "toyota", "auris", 5, 1400));
//			add(new Cars(2L, "volkswagon", "polo", 3, 1000));
//			add(new Cars(3L, "mercedes", "a180", 5, 1500));
//		}
//	};
//
//	@GetMapping("/getAll")
//	public List<Cars> showfleetList() {
//		return this.fleetList;
//	}
//	
//	@PostMapping("/register")
//	public Cars registerCars(@RequestBody Cars cars) {
//		fleetList.add(cars);
//		return cars;
//
//	}
//	
//	@PatchMapping(path="/update/{id}")
//	public List<Cars> replace(@PathParam("engineSize") int engineSize, Cars car) {
//		
//		Cars Updatecar = fleetList.get(id);
//		Updatecar.setEngineSize(engineSize);
//		fleetList.add(id, Updatecar);
//		return fleetList;
//		
//	}
//	
//	
//
//}
