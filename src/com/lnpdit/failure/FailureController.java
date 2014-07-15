package com.lnpdit.failure;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(FailureInterceptor.class)
public class FailureController extends Controller {
	public void index() {
		setAttr("failurePage", Failure.dao.paginate(getParaToInt(0, 1), 10));
		render("failure.html");
	}
	
	public void add() {
	}
	
	@Before(FailureValidator.class)
	public void save() {
		getModel(Failure.class).save();
		redirect("/failure");
	}
	
	public void edit() {
		setAttr("failure", Failure.dao.findById(getParaToInt()));
	}
	
	@Before(FailureValidator.class)
	public void update() {
		getModel(Failure.class).update();
		redirect("/failure");
	}
	
	public void delete() {
		Failure.dao.deleteById(getParaToInt());
		redirect("/failure");
	}
}
