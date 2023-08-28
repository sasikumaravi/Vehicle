package com.vehicle.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.customException.IdNotFoundException;
import com.vehicle.entity.Bus;
import com.vehicle.repository.BusRepository;

@Repository
public class BusDao {
	@Autowired
	BusRepository br;
	public String setBus(Bus b) {
		br.save(b);
		return "Saved Succesfully";
	}
	public String setAllBus(List<Bus> b) {
		br.saveAll(b);
		return "All data stored";
	}
	public List<Bus> getByBrand(String a) {
		return br.getByBrand(a) ;
	}
	public Bus getById(int m) throws IdNotFoundException{
		 return br.findById(m).orElseThrow(()->new IdNotFoundException("Id found"));
	}
}
