package com.luismvl.network_monitor.domain.interfaces;

import com.luismvl.network_monitor.domain.DeviceConfig;
import com.luismvl.network_monitor.domain.SnmpResult;

import java.time.Duration;

public interface SnmpClient {
    SnmpResult poll(DeviceConfig config, Duration timeout, int retries);
}
