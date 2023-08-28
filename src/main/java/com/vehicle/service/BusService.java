package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.customException.BrandNotFoundException;
import com.vehicle.customException.IdNotFoundException;
import com.vehicle.customException.InvalidBoardException;
import com.vehicle.dao.BusDao;
import com.vehicle.entity.Bus;
@Service
public class BusService {
	@Autowired
	BusDao bd;
	public String setBus(Bus b) throws InvalidBoardException {
	try {	if(b.getBoard().equalsIgnoreCase("white")) {
		return bd.setBus(b);
		}
		else {
			throw new InvalidBoardException("Mismatched Board");
		}
	}
	catch(InvalidBoardException e){
		return "Invalid info";
	}
	}
	public String setAllBus(List<Bus> b) throws InvalidBoardException {
		List<Bus> v=b.stream().filter(x->x.getBoard().equalsIgnoreCase("white")|| x.getBoard().equalsIgnoreCase("yellow")).toList();
//		List<Bus> i=b.stream().filter(x->!x.getBoard().equalsIgnoreCase("white")&& x.getBoard().equalsIgnoreCase("yellow")).toList();
		if( v.isEmpty()) {
			throw new InvalidBoardException("Mismatched Board");
		}
		else {
			return bd.setAllBus(v);
		}
	}
	public List<Bus> getByBrand(String a){
		return bd.getByBrand(a);
	}
	public Bus getById(int a) throws IdNotFoundException{
		return bd.getById(a);
	}
	
	public List<Bus> getByBrands(String j) throws BrandNotFoundException{
		List<Bus> h=bd.getByBrand(j);
		if(h.isEmpty()) {
			throw new BrandNotFoundException("");
		}
		else {
			return h;
		}
	}
	public String update(int g, Bus j) throws IdNotFoundException, InvalidBoardException {
		Bus x = getById(g);
		Bus y = j;
		x.setId(g);
		x.setBoard(y.getBoard());
		x.setBrand(y.getBrand());
		x.setColor(y.getColor());
		x.setName(y.getName());
		x.setNumberPlate(y.getNumberPlate());
		x.setType(y.getType());
		
		return setBus(x);
		
	}
}
