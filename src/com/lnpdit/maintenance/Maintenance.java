package com.lnpdit.maintenance;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Maintenance extends Model<Maintenance> {
	public static final Maintenance dao = new Maintenance();

	public Page<Maintenance> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Maintenance order by maintenanceId asc");
	}


	
}
