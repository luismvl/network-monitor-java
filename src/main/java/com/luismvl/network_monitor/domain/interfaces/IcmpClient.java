package com.luismvl.network_monitor.domain.interfaces;

import com.luismvl.network_monitor.domain.DeviceConfig;
import com.luismvl.network_monitor.domain.PollResult;

public interface IcmpClient {
    PollResult ping(DeviceConfig config);

}
