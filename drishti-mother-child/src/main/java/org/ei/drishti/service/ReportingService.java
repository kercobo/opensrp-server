package org.ei.drishti.service;

import org.ei.drishti.common.domain.ReportingData;
import org.ei.drishti.listener.ReportEvent;
import org.motechproject.gateway.OutboundEventGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {

    private OutboundEventGateway gateway;

    @Autowired
    public ReportingService(OutboundEventGateway gateway) {
        this.gateway = gateway;
    }

    public void sendReportData(ReportingData data) {
        gateway.sendEventMessage(new ReportEvent(data).toEvent());
    }
}
