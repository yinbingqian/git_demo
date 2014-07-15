package com.lnpdit.maintenancetype;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class MaintenanceTypeValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("maintenancetype.mileage", "mileageMsg", "请输入里程!");
		validateRequiredString("maintenancetype.maintenanceTime", "maintenanceTimeMsg", "请输入时间!");

	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(MaintenanceType.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/maintenancetype/save"))
			controller.render("add.html");
		else if (actionKey.equals("/maintenancetype/update"))
			controller.render("edit.html");
	}

}
