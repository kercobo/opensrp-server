package org.opensrp.register.mcare.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.HouseHold;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AllHouseHolds extends MotechBaseRepository<HouseHold> {

	private static Logger logger = LoggerFactory.getLogger(AllHouseHolds.class);

	@Autowired
	public AllHouseHolds(
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(HouseHold.class, db);
	}

	@GenerateView
	public HouseHold findByCaseId(String caseId) {
		List<HouseHold> houseHolds = queryView("by_caseId", caseId);
		if (houseHolds == null || houseHolds.isEmpty()) {
			return null;
		}
		return houseHolds.get(0);
	}

	@View(name = "all_households", map = "function(doc) { if (doc.type === 'HouseHold') { emit(doc.PROVIDERID, doc.caseId); } }")
	public List<HouseHold> findAllHouseHolds() {
		return db.queryView(createQuery("all_households").includeDocs(true),
				HouseHold.class);
	}

	@View(name = "all_open_hhs_for_provider", map = "function(doc) { if (doc.type === 'HouseHold' && doc.PROVIDERID) { emit(doc.PROVIDERID); } }")
	public List<HouseHold> allOpenHHsForProvider(String providerId) {
		return db.queryView(
				createQuery("all_open_hhs_for_provider").key(providerId)
						.includeDocs(true), HouseHold.class);
	}

	@View(name = "all_hhs_prev_7_days", map = "function(doc) { if (doc.type === 'HouseHold' && doc.PROVIDERID && doc.TODAY) { emit(doc.PROVIDERID, doc.TODAY); } }")
	public List<HouseHold> allHHsVisited7Days(String providerId) {

		LocalDate today = LocalDate.now();
		
		List<HouseHold> houseHolds = db.queryView(
				createQuery("all_hhs_prev_7_days")
						.startKey(today.minusDays(100))
						.endKey(today)
						//.key(providerId)
						.includeDocs(true), HouseHold.class);

		return houseHolds;
	}
}
