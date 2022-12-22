package com.validation.jpa.validation.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class ConfigProperties {

	@Value("${fcnl.service.url}")
	public String fcurl;
}
