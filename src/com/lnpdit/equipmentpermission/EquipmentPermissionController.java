package com.lnpdit.equipmentpermission;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(EquipmentPermissionInterceptor.class)
public class EquipmentPermissionController extends Controller {
	public void index() {
		setAttr("equipmentpermissionPage", EquipmentPermission.dao.paginate(getParaToInt(0, 1), 10));
		render("equipmentpermission.html");
	}
	
	public void add() {
	}
	
	@Before(EquipmentPermissionValidator.class)
	public void save() {
		getModel(EquipmentPermission.class).save();
		redirect("/equipmentpermission");
	}
	
	public void edit() {
		setAttr("equipmentpermission", EquipmentPermission.dao.findById(getParaToInt()));
	}
	
	@Before(EquipmentPermissionValidator.class)
	public void update() {
		getModel(EquipmentPermission.class).update();
		redirect("/equipmentpermission");
	}
	
	public void delete() {
		EquipmentPermission.dao.deleteById(getParaToInt());
		redirect("/equipmentpermission");
	}
}
