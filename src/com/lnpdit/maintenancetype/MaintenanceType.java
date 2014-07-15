package com.lnpdit.maintenancetype;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class MaintenanceType extends Model<MaintenanceType> {
	public static final MaintenanceType dao = new MaintenanceType();

	public Page<MaintenanceType> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from MaintenanceType order by maintenanceTypeId asc");
	}


	
}
