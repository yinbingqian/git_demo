package com.lnpdit.equipment;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(EquipmentInterceptor.class)
public class EquipmentController extends Controller {
	public void index() {
		setAttr("equipmentPage", Equipment.dao.paginate(getParaToInt(0, 1), 10));
		render("equipment.html");
	}
	
	public void add() {
	}
	
	@Before(EquipmentValidator.class)
	public void save() {
		getModel(Equipment.class).save();
		redirect("/equipment");
	}
	
	public void edit() {
		setAttr("equipment", Equipment.dao.findById(getParaToInt()));
	}
	
	@Before(EquipmentValidator.class)
	public void update() {
		getModel(Equipment.class).update();
		redirect("/equipment");
	}
	
	public void delete() {
		Equipment.dao.deleteById(getParaToInt());
		redirect("/equipment");
	}
}
