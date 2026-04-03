package com.luismvl.network_monitor.domain;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.luismvl.network_monitor.domain.interfaces.IcmpClient;
import com.luismvl.network_monitor.domain.interfaces.SnmpClient;
import java.time.Instant;

@Service
public class PollWorker {
    private final IcmpClient icmpClient;
    private final SnmpClient snmpClient;
    private final StatusCalculator statusCalculator;

    public PollWorker(IcmpClient icmpClient, SnmpClient snmpClient, StatusCalculator statusCalculator) {
        this.icmpClient = icmpClient;
        this.snmpClient = snmpClient;
        this.statusCalculator = statusCalculator;
    }

    public PollResult pollOne(DeviceConfig config) {
        IcmpResult icmp = icmpClient.ping(config.ip(), Duration.ofMillis(800));

        SnmpResult snmp = null;
        if (icmp.reachable() && config.snmpEnabled()) {
            snmp = snmpClient.poll(config, Duration.ofMillis(800), 2);
        }

        DeviceStatus status = statusCalculator.compute(icmp, snmp);

        // Error message
        String errorMessage = null;
        if (icmp.errorMessage() != null) {
            errorMessage = "ICMP: " + icmp.errorMessage();
        } else if (snmp != null && snmp.errorMessage() != null) {
            errorMessage = "SNMP: " + snmp.errorMessage();
        }

        return new PollResult(
                config.id(),
                icmp.reachable(),
                icmp.latencyMs(),
                snmp != null && config.snmpEnabled(),
                snmp != null && snmp.successful(),
                status,
                Instant.now(),
                errorMessage);
    }
}
