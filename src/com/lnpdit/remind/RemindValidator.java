package com.lnpdit.remind;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class RemindValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		// TODO Auto-generated method stub
		validateRequiredString("remind.carId", "carIdMsg", "请输入车辆ID!");
		validateRequiredString("remind.ownerId", "ownerIdMsg", "请输入车主ID!");
		validateRequiredString("remind.remindLevel", "remindLevelMsg", "请输入提醒类别!");
		validateRequiredString("remind.remindDate", "remindDateMsg", "请输入提醒时间!");
		validateRequiredString("remind.remindContent", "remindContentMsg", "请输入提醒内容!");
		validateRequiredString("remind.sendState", "sendStateMsg", "请输入发送状态!");
		validateRequiredString("remind.sendDate", "sendDayeMsg", "请输入发送时间!");
		validateRequiredString("remind.orderDate", "orderDateMsg", "请输入预约时间!");
	}

	@Override
	protected void handleError(Controller controller) {
		controller.keepModel(Remind.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/remind/save"))
			controller.render("add.html");
		else if (actionKey.equals("/remind/update"))
			controller.render("edit.html");
	}
}
