package com.lnpdit.equipment;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class EquipmentInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before invoking " + ai.getActionKey());
		ai.invoke();
		System.out.println("After invoking " + ai.getActionKey());

	}

}
