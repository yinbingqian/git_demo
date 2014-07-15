package com.lnpdit.user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(UserInterceptor.class)
public class UserController extends Controller {
	public void index() {
		setAttr("userPage", User.dao.paginate(getParaToInt(0, 1), 10));
		render("user.html");
	}
	
	public void add() {
	}
	
	@Before(UserValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	@Before(UserValidator.class)
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToInt());
		redirect("/user");
	}
}
