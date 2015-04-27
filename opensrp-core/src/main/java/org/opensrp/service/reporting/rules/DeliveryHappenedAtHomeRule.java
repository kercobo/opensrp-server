package org.opensrp.service.reporting.rules;

import static org.opensrp.common.AllConstants.CommonFormFields.HOME_FIELD_VALUE;
import static org.opensrp.common.AllConstants.DeliveryOutcomeFields.DELIVERY_PLACE;

import org.opensrp.util.SafeMap;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHappenedAtHomeRule implements IRule {
    @Override
    public boolean apply(SafeMap reportFields) {
        return HOME_FIELD_VALUE.equalsIgnoreCase(reportFields.get(DELIVERY_PLACE));
    }
}
