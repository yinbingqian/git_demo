package com.lnpdit.failure;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class FailureValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("failure.carId", "carIDMsg", "请输入车辆ID!");
		validateRequiredString("failure.ownerId", "ownerIdMsg", "请输入车主ID!");
		validateRequiredString("failure.failureLevelId", "failureLevelIdMsg", "请输入故障等级ID!");
		validateRequiredString("failure.failureCode", "failureCodeMsg", "请输入故障代码!");
		validateRequiredString("failure.failureDescription", "failureDescriptionMsg", "请输入故障描述!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Failure.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/failure/save"))
			controller.render("add.html");
		else if (actionKey.equals("/failure/update"))
			controller.render("edit.html");
	}

}
