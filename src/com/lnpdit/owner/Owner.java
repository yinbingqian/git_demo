package com.lnpdit.owner;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Owner extends Model<Owner> {
	public static final Owner dao = new Owner();

	public Page<Owner> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Owner order by ownerId asc");
	}


	
}
