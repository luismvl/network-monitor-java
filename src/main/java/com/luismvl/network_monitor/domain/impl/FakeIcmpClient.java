package com.luismvl.network_monitor.domain.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.luismvl.network_monitor.domain.IcmpResult;
import com.luismvl.network_monitor.domain.interfaces.IcmpClient;

@Service
public class FakeIcmpClient implements IcmpClient {
    @Override
    public IcmpResult ping(String ip, Duration timeout) {
        try {
            long simulatedDelay = ThreadLocalRandom.current().nextLong(10, 120);
            Thread.sleep(simulatedDelay);

            boolean reachable = ThreadLocalRandom.current().nextInt(100) >= 15; // 85% chance of being reachable
            Long latency = reachable ? ThreadLocalRandom.current().nextLong(5, 80) : null; // latency between 5 and 80
                                                                                           // ms if reachable
            return new IcmpResult(
                    reachable,
                    latency,
                    Instant.now(),
                    reachable ? null : "Host unreachable");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return new IcmpResult(
                    false,
                    null,
                    Instant.now(),
                    "Ping operation interrupted");
        }
    }
}
