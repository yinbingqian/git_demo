package com.lnpdit.failurebank;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class FailureBankValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("failurebank.failureLevel", "failureLevelMsg", "请输入故障等级!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(FailureBank.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/failurebank/save"))
			controller.render("add.html");
		else if (actionKey.equals("/failurebank/update"))
			controller.render("edit.html");
	}

}
