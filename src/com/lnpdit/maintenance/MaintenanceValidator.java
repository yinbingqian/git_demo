package com.lnpdit.maintenance;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class MaintenanceValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("maintenance.carId", "carIdMsg", "请输入车辆ID!");
		validateRequiredString("maintenance.ownerId", "ownerIdMsg", "请输入车主ID!");
		validateRequiredString("maintenance.maintenanceTypeId", "maintenanceTypeIdMsg", "请输入保养类型ID!");
		validateRequiredString("maintenance.currentMileage", "currentMileageMsg", "请输入当前里程!");
		validateRequiredString("maintenance.lastMaintenanceMileage", "lastMaintenanceMileageMsg", "请输入上次保养里程!");
		validateRequiredString("maintenance.maintenanceMaturityDate", "maintenanceMaturityDateMsg", "请输入保养到期时间!");
		validateRequiredString("maintenance.lastMaintenanceDate", "lastMaintenanceDateMsg", "请输入上次保养时间!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Maintenance.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/maintenance/save"))
			controller.render("add.html");
		else if (actionKey.equals("/maintenance/update"))
			controller.render("edit.html");
	}

}
