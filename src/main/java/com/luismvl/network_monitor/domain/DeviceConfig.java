package com.luismvl.network_monitor.domain;

public record DeviceConfig(
        Long id,
        String name,
        String ip,
        Integer snmpPort,
        String snmpVersion,
        String community,
        boolean snmpEnabled,
        boolean active
) {
}