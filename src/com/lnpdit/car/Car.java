package com.lnpdit.car;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Car extends Model<Car> {
	public static final Car dao = new Car();

	public Page<Car> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Car order by carId asc");
	}


	
}
