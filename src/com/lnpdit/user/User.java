package com.lnpdit.user;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class User extends Model<User> {
	public static final User dao = new User();

	public Page<User> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from User order by userId asc");
	}


	
}
