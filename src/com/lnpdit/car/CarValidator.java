package com.lnpdit.car;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class CarValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("car.ownerId", "ownerIdMsg", "请输入车主ID!");
		validateRequiredString("car.carNumber", "carNumberMsg", "请输入车牌号!");
		validateRequiredString("car.carModel", "carModelMsg", "请输入型号!");
		validateRequiredString("car.carVin", "carVinMsg", "请输入车架号!");
		validateRequiredString("car.carSellDate", "carSellDateMsg", "请输入购买日期!");
		validateRequiredString("car.equipmentId", "equipmentIdMsg", "请输入车辆设备号!");
		validateRequiredString("car.maintenanceTypeId", "maintenanceTypeIdMsg", "请输入保养类型ID!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Car.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/car/save"))
			controller.render("add.html");
		else if (actionKey.equals("/car/update"))
			controller.render("edit.html");
	}

}
