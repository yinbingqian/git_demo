package com.lnpdit.failurebank;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class FailureBank extends Model<FailureBank> {
	public static final FailureBank dao = new FailureBank();

	public Page<FailureBank> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from FailureBank order by failureBankId asc");
	}


	
}
