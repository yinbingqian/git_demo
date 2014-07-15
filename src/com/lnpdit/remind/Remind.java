package com.lnpdit.remind;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Remind extends Model<Remind>{
	public static final Remind dao = new Remind();

	public Page<Remind> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Remind order by remindId asc");
	}
	
	
}
