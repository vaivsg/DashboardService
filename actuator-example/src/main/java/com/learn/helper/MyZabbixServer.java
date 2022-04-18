package com.learn.helper;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyZabbixServer implements HealthIndicator {
	
	public static final String Zabbix_Service="Zabbix Service";
	
	public boolean isHealthGood() {
		return true;
	}
	
	@Override
	public Health health()
	{
		if(isHealthGood()) {
			return Health.up().withDetail(Zabbix_Service, "Zabbix Server is running").build();
		}
		
		return Health.down().withDetail(Zabbix_Service, "Zabbix Server is down").build();
	}

}
