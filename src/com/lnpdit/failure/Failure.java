package com.lnpdit.failure;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Failure extends Model<Failure> {
	public static final Failure dao = new Failure();

	public Page<Failure> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Failure order by failureId asc");
	}


	
}
