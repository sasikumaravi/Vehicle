package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bike;
import com.vehicle.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	@Autowired
	BikeService bs;
	@PostMapping(value="/setBikes")
	public String setBike(@RequestBody List<Bike> bc) {
		return bs.setBike(bc);
	}
	@GetMapping(value="/getAll")
	public List<Bike> getAllBike(){
		return bs.getAllBike();
	}
	@GetMapping(path="/remove/{id}")
	public String delete(@PathVariable int id) {
		return bs.delete(id);
	}
	@GetMapping(path="/getByBrand/{b}")
	public List<Bike> getByBrand(@PathVariable String b ){
		return bs.getByBrand(b);
	}
	@GetMapping(path="getByRange/{s}/{e}")
	public List<Bike> getByRange(@PathVariable int s,@PathVariable int e){
		return bs.getByRange(s,e);
	}
	@GetMapping(path="getBrandBikeColor/{c}")
	public List<String> getBrandBikeColor(@PathVariable String c) {
		return bs.getBrandBikeColor(c);
	}
	
	@GetMapping(value="/getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value="/getMin")
	public Bike getMin() {
		return bs.getMin();
	}
	@GetMapping(path="/addAmountBike/{p}")
	public List<Bike> addAmountBike(@PathVariable int p){
		return bs.addAmountBike(p);
	}
	@GetMapping(path="/getPetrolBikeCount/{b}")
	public Long getPetrolBikeCount(@PathVariable String b){
		return bs.getPetrolBikeCount(b);
	}


}
