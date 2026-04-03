package com.luismvl.network_monitor.domain.impl;

import org.springframework.stereotype.Service;

import com.luismvl.network_monitor.domain.DeviceConfig;
import com.luismvl.network_monitor.domain.PollResult;
import com.luismvl.network_monitor.domain.interfaces.IcmpClient;

@Service
public class FakeIcmpClient implements IcmpClient {
    @Override
    public PollResult ping(DeviceConfig config) {
        // Simulate a ping result for testing purposes
        return new PollResult(
                config.id(),
                Math.random() > 0.1, // reachable, 90% chance of being reachable
                (long) (Math.random() * 220) // latency between 0 and 220 ms
        );
    }
}
