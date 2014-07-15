package com.lnpdit.failurebank;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(FailureBankInterceptor.class)
public class FailureBankController extends Controller {
	public void index() {
		setAttr("failurebankPage", FailureBank.dao.paginate(getParaToInt(0, 1), 10));
		render("failurebank.html");
	}
	
	public void add() {
	}
	
	@Before(FailureBankValidator.class)
	public void save() {
		getModel(FailureBank.class).save();
		redirect("/failurebank");
	}
	
	public void edit() {
		setAttr("failurebank", FailureBank.dao.findById(getParaToInt()));
	}
	
	@Before(FailureBankValidator.class)
	public void update() {
		getModel(FailureBank.class).update();
		redirect("/failurebank");
	}
	
	public void delete() {
		FailureBank.dao.deleteById(getParaToInt());
		redirect("/failurebank");
	}
}
