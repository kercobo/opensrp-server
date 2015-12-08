package org.opensrp.register.mcare.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.Elco;
import org.opensrp.register.mcare.domain.HouseHold;
import org.opensrp.register.mcare.domain.Mother;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AllElcos extends MotechBaseRepository<Elco> {

	@Autowired
	public AllElcos(
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(Elco.class, db);
	}

	@GenerateView
	public Elco findByCaseId(String caseId) {
		List<Elco> elcos = queryView("by_caseId", caseId);
		if (elcos == null || elcos.isEmpty()) {
			return null;
		}
		return elcos.get(0);
	}

	public boolean exists(String caseId) {
		return findByCaseId(caseId) != null;
	}
	public void close(String caseId) {
		Elco elco = findByCaseId(caseId);
		update(elco.setIsClosed(true));
	}
	@View(name = "all_open_elcos_for_provider", map = "function(doc) { if (doc.type === 'Elco' && doc.PROVIDERID) { emit(doc.PROVIDERID); } }")
	public List<Elco> allOpenELCOsForProvider(String providerId) {
		return db.queryView(
				createQuery("all_open_elcos_for_provider").key(providerId)
						.includeDocs(true), Elco.class);
	}
	@View(name = "all_open_elcos_for_provider", map = "function(doc) { if (doc.type === 'Elco' && doc.PROVIDERID) { emit(doc.PROVIDERID); } }")
	public List<Elco> allOpenELCOs() {
		return db.queryView(
				createQuery("all_open_elcos_for_provider")
						.includeDocs(true), Elco.class);
	}

}
