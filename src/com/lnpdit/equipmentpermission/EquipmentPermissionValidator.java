package com.lnpdit.equipmentpermission;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class EquipmentPermissionValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("user.userAcc", "userAccMsg", "请输入账号!");
		validateRequiredString("user.userPass", "userPassMsg", "请输入密码!");
		validateRequiredString("user.userName", "userNameMsg", "请输入真实姓名!");
		validateRequiredString("user.userSex", "userSexMsg", "请输入性别!");
		validateRequiredString("user.userPhone", "userPhoneMsg", "请输入联系电话!");
		validateRequiredString("user.userJob", "userJobMsg", "请输入职位!");
		validateRequiredString("user.userBirth", "userBirthMsg", "请输入出生年月日!");
		validateRequiredString("user.userStore", "userStoreMsg", "请输入所属4S店!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(EquipmentPermission.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/equipmentpermission/save"))
			controller.render("add.html");
		else if (actionKey.equals("/equipmentpermission/update"))
			controller.render("edit.html");
	}

}
