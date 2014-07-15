package com.lnpdit.equipmentpermission;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public class EquipmentPermission extends Model<EquipmentPermission> {
	public static final EquipmentPermission dao = new EquipmentPermission();

	public Page<EquipmentPermission> paginate(int pageNumber, int pageSize) {
		
		return paginate(pageNumber, pageSize, "select * ","from EquipmentPermission order by equipmentpermissionId asc");
	}


	
}
