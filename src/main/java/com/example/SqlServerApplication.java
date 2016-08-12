package com.example;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SqlServerApplication {


	private static final Logger LOG = LoggerFactory.getLogger(SqlServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SqlServerApplication.class, args);
	}

	// jdbc:h2:tcp:localhost:7071/mem:testdb
	@Bean
	public Server h2TcpServer(@Value("${h2.tcp.port}") String port) {
		Server server = null;
		try {
			server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", port).start();

			LOG.info("Start H2 TCP server on port {}", port);

		} catch (Exception e) {
			LOG.error("Error start  H2 TCP server on port " + port, e);
			e.printStackTrace();
		}
		return server;
	}


	// h2-console  http://localhost:7072/
	@Bean
	public Server h2WebServer(@Value("${h2.web.port}") String port) {
		Server server = null;

		try {
			server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", port).start();

			LOG.info("Start H2 WEB server on port {}", port);

		} catch (Exception e) {
			LOG.error("Error start  H2 WEB server on port " + port, e);
			e.printStackTrace();
		}

		return server;
	}


}
