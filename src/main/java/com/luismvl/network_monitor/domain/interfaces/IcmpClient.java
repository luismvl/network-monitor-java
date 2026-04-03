package com.luismvl.network_monitor.domain.interfaces;

import java.time.Duration;

import com.luismvl.network_monitor.domain.IcmpResult;

public interface IcmpClient {
    IcmpResult ping(String ip, Duration timeout);
}
