package com.luismvl.network_monitor.domain.impl;

import com.luismvl.network_monitor.domain.DeviceConfig;
import com.luismvl.network_monitor.domain.SnmpResult;
import com.luismvl.network_monitor.domain.interfaces.SnmpClient;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class FakeSnmpClient implements SnmpClient {

    @Override
    public SnmpResult poll(DeviceConfig device, Duration timeout, int retries) {
        try {
            long simulatedDelay = ThreadLocalRandom.current().nextLong(30, 180);
            Thread.sleep(simulatedDelay);

            boolean success = ThreadLocalRandom.current().nextInt(100) >= 20;

            return new SnmpResult(
                    true,
                    success,
                    success ? "fake-device-" + device.id() : null,
                    Instant.now(),
                    success ? null : "Simulated SNMP timeout/error");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new SnmpResult(
                    true,
                    false,
                    null,
                    Instant.now(),
                    "SNMP fake interrupted");
        }
    }
}