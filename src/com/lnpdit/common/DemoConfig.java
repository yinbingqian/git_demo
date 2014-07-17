package com.lnpdit.common;

import com.demo.blog.Blog;
import com.demo.blog.BlogController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.lnpdit.car.Car;
import com.lnpdit.car.CarController;
import com.lnpdit.equipment.Equipment;
import com.lnpdit.equipment.EquipmentController;
import com.lnpdit.equipmentpermission.EquipmentPermission;
import com.lnpdit.equipmentpermission.EquipmentPermissionController;
import com.lnpdit.failure.Failure;
import com.lnpdit.failure.FailureController;
import com.lnpdit.failurebank.FailureBank;
import com.lnpdit.failurebank.FailureBankController;
import com.lnpdit.maintenance.Maintenance;
import com.lnpdit.maintenance.MaintenanceController;
import com.lnpdit.maintenancetype.MaintenanceType;
import com.lnpdit.maintenancetype.MaintenanceTypeController;
import com.lnpdit.owner.Owner;
import com.lnpdit.owner.OwnerController;
import com.lnpdit.remind.Remind;
import com.lnpdit.remind.RemindController;
import com.lnpdit.user.User;
import com.lnpdit.user.UserController;

/**
 * API引导式配置
 */
public class DemoConfig extends JFinalConfig {
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用getProperty(...)获取值
		loadPropertyFile("a_little_config.txt");
		me.setDevMode(getPropertyToBoolean("devMode", false));
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", CommonController.class);
		me.add("/blog", BlogController.class);
		me.add("/user", UserController.class);
		me.add("/car",CarController.class);
		me.add("/equipment",EquipmentController.class);
		me.add("/equipmentpermission",EquipmentPermissionController.class);
		me.add("/failure",FailureController.class);
		me.add("/failurebank",FailureBankController.class);
		me.add("/maintenance",MaintenanceController.class);
		me.add("/maintenance",MaintenanceTypeController.class);
		me.add("/owner",OwnerController.class);
		me.add("/remid",RemindController.class);

	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("blog", Blog.class);	// 映射blog 表到 Blog模型
		arp.addMapping("user", User.class);
		arp.addMapping("car", Car.class);
		arp.addMapping("equipment", Equipment.class);
		arp.addMapping("equipmentpermission", EquipmentPermission.class);
		arp.addMapping("failure", Failure.class);
		arp.addMapping("failurebank", FailureBank.class);
		arp.addMapping("maintenance", Maintenance.class);
		arp.addMapping("maintenance", MaintenanceType.class);
		arp.addMapping("owner", Owner.class);
		arp.addMapping("remid", Remind.class);
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler());	//解决取路径问题
	}
	
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
