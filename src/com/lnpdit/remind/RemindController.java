package com.lnpdit.remind;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(RemindInterceptor.class)
public class RemindController extends Controller{
	public void index() {
		setAttr("remindPage", Remind.dao.paginate(getParaToInt(0, 1), 10));
		render("remind.html");
	}
	
	public void add() {
	}
	
	@Before(RemindValidator.class)
	public void save() {
		getModel(Remind.class).save();
		redirect("/remind");
	}
	
	public void edit() {
		setAttr("remind", Remind.dao.findById(getParaToInt()));
	}
	
	@Before(RemindValidator.class)
	public void update() {
		getModel(Remind.class).update();
		redirect("/remind");
	}
	
	public void delete() {
		Remind.dao.deleteById(getParaToInt());
		redirect("/remind");
	}
}
