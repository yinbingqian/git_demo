package com.lnpdit.maintenancetype;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(MaintenanceTypeInterceptor.class)
public class MaintenanceTypeController extends Controller {
	public void index() {
		setAttr("maintenancetypePage", MaintenanceType.dao.paginate(getParaToInt(0, 1), 10));
		render("maintenancetype.html");
	}
	
	public void add() {
	}
	
	@Before(MaintenanceTypeValidator.class)
	public void save() {
		getModel(MaintenanceType.class).save();
		redirect("/maintenancetype");
	}
	
	public void edit() {
		setAttr("maintenancetype", MaintenanceType.dao.findById(getParaToInt()));
	}
	
	@Before(MaintenanceTypeValidator.class)
	public void update() {
		getModel(MaintenanceType.class).update();
		redirect("/maintenancetype");
	}
	
	public void delete() {
		MaintenanceType.dao.deleteById(getParaToInt());
		redirect("/maintenancetype");
	}
}
