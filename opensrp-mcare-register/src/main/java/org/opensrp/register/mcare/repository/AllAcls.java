package org.opensrp.register.mcare.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.Acl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AllAcls  extends MotechBaseRepository<Acl>{
	@Autowired
	public AllAcls(
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(Acl.class, db);
	}
	@GenerateView
	public Acl findByRoleName(String roleName) {
		List<Acl> acls = queryView("by_roleName", roleName);
		if (acls == null || acls.isEmpty()) {
			return null;
		}
		return acls.get(0);
	}
	
	@View(name = "all_role", map = "function(doc) { if (doc.type === 'Acl') { emit(doc.roleName); } }")
	public List<Acl> roles() {
		return db.queryView(
				createQuery("all_role")
						.includeDocs(true), Acl.class);
	}
	
	@View(name = "all_active_role", map = "function(doc) { if (doc.type === 'Acl' && doc.status ==='Active') { emit(doc.roleName); } }")
	public List<Acl> allActiveRoles() {
		return db.queryView(
				createQuery("all_active_role")
						.includeDocs(true), Acl.class);
	}
	
}
