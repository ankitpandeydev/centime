package com.ap.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {
	@Value("${service2_host}")
	private String service2Host;

	@Value("${service3_host}")
	private String service3Host;

	public String getService2Host() {
		return service2Host;
	}

	public void setService2Host(String service2Host) {
		this.service2Host = service2Host;
	}

	public String getService3Host() {
		return service3Host;
	}

	public void setService3Host(String service3Host) {
		this.service3Host = service3Host;
	}

}
