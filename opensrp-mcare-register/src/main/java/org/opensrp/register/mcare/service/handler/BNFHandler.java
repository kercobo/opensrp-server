/**
 * @author julkar nain 
 */
package org.opensrp.register.mcare.service.handler;

import org.opensrp.form.domain.FormSubmission;
import org.opensrp.register.mcare.service.BNFService;
import org.opensrp.service.formSubmission.handler.FormSubmissionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BNFHandler implements FormSubmissionHandler {

	private BNFService bnfService;

	@Autowired
	public BNFHandler(BNFService bnfService) {
		this.bnfService = bnfService;
	}
	@Override
	public void handle(FormSubmission submission) {
		bnfService.bnfFollowUpVisit(submission);
	}
}
