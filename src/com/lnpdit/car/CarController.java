package com.lnpdit.car;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(CarInterceptor.class)
public class CarController extends Controller {
	public void index() {
		setAttr("carPage", Car.dao.paginate(getParaToInt(0, 1), 10));
		render("car.html");
	}
	
	public void add() {
	}
	
	@Before(CarValidator.class)
	public void save() {
		getModel(Car.class).save();
		redirect("/car");
	}
	
	public void edit() {
		setAttr("car", Car.dao.findById(getParaToInt()));
	}
	
	@Before(CarValidator.class)
	public void update() {
		getModel(Car.class).update();
		redirect("/car");
	}
	
	public void delete() {
		Car.dao.deleteById(getParaToInt());
		redirect("/car");
	}
}
