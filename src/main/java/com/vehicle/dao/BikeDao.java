package com.vehicle.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bike;
import com.vehicle.repository.BikeRepository;

@Repository
public class BikeDao {
	@Autowired
	BikeRepository br;
	public String setBike(List<Bike> bd) {
		br.saveAll(bd);
		return "Success";
	}
	public List<Bike> getAllBike(){
	   return br.findAll();
	}
	public String delete(int id) {
		br.deleteById(id);
		return "Deleted";
	}
}
