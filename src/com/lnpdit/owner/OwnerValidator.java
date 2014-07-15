package com.lnpdit.owner;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class OwnerValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("owner.ownerName", "ownerNameMsg", "请输入车主姓名!");
		validateRequiredString("owner.ownerSex", "ownerSexMsg", "请输入车主性别!");
		validateRequiredString("owner.ownerPhone", "ownerPhoneMsg", "请输入车主联系电话!");
		validateRequiredString("owner.ownerDate", "ownerDateMsg", "请输入车主出生年月日!");
		validateRequiredString("owner.ownerCreditLine", "ownerCreditLineMsg", "请输入车主信用度!");
		validateRequiredString("owner.ownerAddDate", "ownerAddDateMsg", "请输入添加时间!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Owner.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/owner/save"))
			controller.render("add.html");
		else if (actionKey.equals("/owner/update"))
			controller.render("edit.html");
	}

}
