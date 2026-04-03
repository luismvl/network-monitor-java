package com.luismvl.network_monitor;

import org.springframework.boot.SpringApplication;

public class TestNetworkMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.from(NetworkMonitorApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
