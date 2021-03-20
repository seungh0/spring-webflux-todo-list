package com.reactivetodo.config;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("local")
@Configuration
public class H2Config {

	private Server webServer;

	@Value("${spring.h2.port}")
	private Integer h2ConsolePort;

	@EventListener(ContextRefreshedEvent.class)
	public void start() throws SQLException {
		log.info("starting h2 console at port {}", h2ConsolePort);
		this.webServer = Server.createWebServer("-webPort", h2ConsolePort.toString());
		this.webServer.start();
	}

	@EventListener(ContextClosedEvent.class)
	public void stop() {
		log.info("stopping h2 console at port {}", h2ConsolePort);
		this.webServer.stop();
	}

}