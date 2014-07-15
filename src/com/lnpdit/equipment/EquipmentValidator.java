package com.lnpdit.equipment;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class EquipmentValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("equipment.equipmentNumber", "equipmentNumberAccMsg", "请输入设备号!");
		validateRequiredString("equipment.equipmentType", "equipmentTypeMsg", "请输入型号!");
		validateRequiredString("equipment.ownerId", "ownerIdMsg", "请输入车主ID!");
		validateRequiredString("equipment.equipmentState", "equipmentStateSexMsg", "请输入设备状态!");
		validateRequiredString("equipment.equipmentProductionDate", "equipmentProductionDateMsg", "请输入生产日期!");
		validateRequiredString("equipment.equipmentAddDate", "equipmentAddDateMsg", "请输入录入日期!");
		validateRequiredString("equipment.equipmentAddId", "equipmentAddIdMsg", "请输入录入人员!");
		validateRequiredString("equipment.equipmentBindDate", "equipmentBindDateMsg", "请输入启用日期!");
		validateRequiredString("equipment.equipmentBindId", "equipmentBindIdMsg", "请输入启用人员!");
		validateRequiredString("equipment.equipmentActivationDate", "equipmentActivationDateMsg", "请输入激活日期!");
		validateRequiredString("equipment.equipmentDestroyRegister", "equipmentDestroyRegisterMsg", "设备销毁登记!");
		validateRequiredString("equipment.equipmentDestroyDate", "equipmentDestroyDateMsg", "请输入销毁日期!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Equipment.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/equipment/save"))
			controller.render("add.html");
		else if (actionKey.equals("/equipment/update"))
			controller.render("edit.html");
	}

}
