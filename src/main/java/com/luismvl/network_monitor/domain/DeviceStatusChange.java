package com.luismvl.network_monitor.domain;

public record DeviceStatusChange(
        Long deviceId,
        DeviceStatus oldStatus,
        DeviceStatus newStatus,
        Long timestamp

) {
}
