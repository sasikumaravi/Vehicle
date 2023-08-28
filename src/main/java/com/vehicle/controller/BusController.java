package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.customException.BrandNotFoundException;
import com.vehicle.customException.IdNotFoundException;
import com.vehicle.customException.InvalidBoardException;
import com.vehicle.entity.Bus;
import com.vehicle.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
	BusService bs;
	@PatchMapping(value="/setBus")
	public String setBus(@RequestBody Bus b ) throws InvalidBoardException {
		return bs.setBus(b);
	}
	@PostMapping(value="/setAllBus")
	public String setAllBus(@RequestBody List<Bus> b) throws InvalidBoardException {
		return bs.setAllBus(b);
	}
	@GetMapping(value="/getByBrand/{br}")
	public List<Bus> getByBrand(@PathVariable String br){
		return bs.getByBrand(br);
	}
	@GetMapping(value="/getById/{br}")
		public Bus getById(@PathVariable int br) throws IdNotFoundException{
			return bs.getById(br);
	}
	@GetMapping(value="/getByBrands/{br}")
	public List<Bus> getByBrands(@PathVariable String br) throws BrandNotFoundException{
		return bs.getByBrands(br);
	}
	@PutMapping(value="/updateData/{g}")
	public String update(@PathVariable int g,@RequestBody Bus j) throws IdNotFoundException, InvalidBoardException {
		return bs.update(g,j);
	}
}
