package com.lnpdit.equipment;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class Equipment extends Model<Equipment> {
	public static final Equipment dao = new Equipment();

	public Page<Equipment> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from Equipment order by equipmentId asc");
	}


	
}
