package com.jr.fleet.main.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "a_make")
	private String make;
	
	@Column(nullable = false, name ="b_model")
	private String model;
	
	@Column(nullable = false, name="c_doors")
	private int doors;
	
	@Column (nullable = false, name="d_engineSize")
	private int engineSize;


	public Cars(Long inId, String inMake, String inModel, int inDoors, int inEngineSize) {
		super();
		this.id = inId;
		this.make = inMake;
		this.model = inModel;
		this.doors = inDoors;
		this.engineSize = inEngineSize;
	}	

}
