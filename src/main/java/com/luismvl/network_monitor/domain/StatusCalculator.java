package com.luismvl.network_monitor.domain;

import org.springframework.stereotype.Component;

/**
 * A calculator for determining the status of a device based on ICMP and SNMP
 * results.
 */
@Component
public class StatusCalculator {
    public DeviceStatus compute(IcmpResult icmp, SnmpResult snmp) {
        if (icmp == null)
            return DeviceStatus.UNKNOWN;
        if (!icmp.reachable())
            return DeviceStatus.DOWN;
        if (snmp == null)
            return DeviceStatus.UP;
        if (snmp.successful())
            return DeviceStatus.UP;

        return DeviceStatus.DEGRADED;
    }

}
