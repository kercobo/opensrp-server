package org.opensrp.register.mcare.repository;

import java.util.List;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.motechproject.dao.MotechBaseRepository;
import org.opensrp.common.AllConstants;
import org.opensrp.register.mcare.domain.Acl;
import org.opensrp.register.mcare.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AllRoles  extends MotechBaseRepository<Role>{
	@Autowired
	public AllRoles(
			@Qualifier(AllConstants.OPENSRP_DATABASE_CONNECTOR) CouchDbConnector db) {
		super(Role.class, db);
	}
	@GenerateView
	public Role findByUserName(String userName) {
		List<Role> roles = queryView("by_userName", userName);
		if (roles == null || roles.isEmpty()) {
			return null;
		}
		return roles.get(0);
	}
	@View(name = "all_user_with_role", map = "function(doc) { if (doc.type === 'Role' && doc.status ==='Active') { emit(doc.userName); } }")
	public List<Role> roles() {
		return db.queryView(
				createQuery("all_user_with_role")
						.includeDocs(true), Role.class);
	}
	
}
