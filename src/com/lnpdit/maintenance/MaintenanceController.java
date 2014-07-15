package com.lnpdit.maintenance;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(MaintenanceInterceptor.class)
public class MaintenanceController extends Controller {
	public void index() {
		setAttr("maintenancePage", Maintenance.dao.paginate(getParaToInt(0, 1), 10));
		render("maintenance.html");
	}
	
	public void add() {
	}
	
	@Before(MaintenanceValidator.class)
	public void save() {
		getModel(Maintenance.class).save();
		redirect("/maintenance");
	}
	
	public void edit() {
		setAttr("maintenance", Maintenance.dao.findById(getParaToInt()));
	}
	
	@Before(MaintenanceValidator.class)
	public void update() {
		getModel(Maintenance.class).update();
		redirect("/maintenance");
	}
	
	public void delete() {
		Maintenance.dao.deleteById(getParaToInt());
		redirect("/maintenance");
	}
}
