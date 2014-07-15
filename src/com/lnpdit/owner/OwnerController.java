package com.lnpdit.owner;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(OwnerInterceptor.class)
public class OwnerController extends Controller {
	public void index() {
		setAttr("ownerPage", Owner.dao.paginate(getParaToInt(0, 1), 10));
		render("owner.html");
	}
	
	public void add() {
	}
	
	@Before(OwnerValidator.class)
	public void save() {
		getModel(Owner.class).save();
		redirect("/owner");
	}
	
	public void edit() {
		setAttr("owner", Owner.dao.findById(getParaToInt()));
	}
	
	@Before(OwnerValidator.class)
	public void update() {
		getModel(Owner.class).update();
		redirect("/owner");
	}
	
	public void delete() {
		Owner.dao.deleteById(getParaToInt());
		redirect("/owner");
	}
}
