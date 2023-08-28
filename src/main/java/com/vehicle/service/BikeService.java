package com.vehicle.service;

import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.dao.BikeDao;
import com.vehicle.entity.Bike;


@Service
public class BikeService {
	@Autowired
	BikeDao bd;
	public String setBike(List<Bike> bs) {
		return bd.setBike(bs);
	}
	public List<Bike> getAllBike(){
		return bd.getAllBike();
	}
	public String delete(int id) {
		return bd.delete(id);
	}
	public List<Bike> getByBrand(String b){
		List<Bike> x=getAllBike();
		List<Bike> z=x.stream().filter(y->y.getBrand().equalsIgnoreCase(b)).collect(Collectors.toList());
		return z;
	}
	public List<Bike> getByRange(int s,int e){
		List<Bike> h=getAllBike();
		List<Bike> j=h.stream().filter(x->x.getPrice()>s && x.getPrice()<e).collect(Collectors.toList());
		return j;
	}
	public List<String> getBrandBikeColor(String c) {
		List<Bike> b=getAllBike();
		List<String> x=b.stream().filter(a->a.getColor().equalsIgnoreCase(c)).map(i->i.getBrand()).collect(Collectors.toList());
		return x;
	}
	public Bike getMax() {
		List<Bike> m=getAllBike();
		Bike a=m.stream().max(Comparator.comparingInt(Bike::getPrice)).get();
		return a;
	}
	public Bike getMin() {
		List<Bike> n=getAllBike();
		Bike b=n.stream().min(Comparator.comparingInt(Bike::getPrice)).get();
		return b;
	}
	public List<Bike> addAmountBike(int p){
//		List<Bike> ab=getAllBike();
//		List<Bike> bc=ab.stream().map(a-> {
//			a.setPrice(a.getPrice()+a.getPrice()*p/100);
//			return a;
//		}).collect(Collectors.toList());
//		return bc;
		
		List<Bike> je=getAllBike();
		List<Bike> jp=je.stream().peek(x->x.setPrice(x.getPrice()-x.getPrice()*p/100)).collect(Collectors.toList());
		return jp;
	}
	public Long getPetrolBikeCount(String b) {
		Long h=getAllBike().stream().filter(l->l.getFuel_type().equalsIgnoreCase(b)).count();
		return h;
	}
	
	
	
}
