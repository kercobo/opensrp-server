package org.opensrp.service.reporting.rules;

import static org.opensrp.common.AllConstants.VitaminAFields.VITAMIN_A_DOSE;
import static org.opensrp.common.AllConstants.VitaminAFields.VITAMIN_A_DOSE_3_VALUE;

import org.opensrp.util.SafeMap;
import org.springframework.stereotype.Component;

@Component
public class IsVitaminA3DoseGivenRule implements IRule {

    @Override
    public boolean apply(SafeMap reportFields) {
        return VITAMIN_A_DOSE_3_VALUE.equalsIgnoreCase(reportFields.get(VITAMIN_A_DOSE));
    }
}
