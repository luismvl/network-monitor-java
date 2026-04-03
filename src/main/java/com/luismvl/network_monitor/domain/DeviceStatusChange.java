package com.luismvl.network_monitor.domain;

import java.time.Instant;

public record DeviceStatusChange(
        Long deviceId,
        DeviceStatus oldStatus,
        DeviceStatus newStatus,
        Instant occurredAt

) {
}
