package com.mcakir.mvc.listener;

import com.mcakir.core.model.User;
import com.mcakir.core.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class AuthFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	private int maxFailures = 5;

	@Autowired
	IAdminService adminService;

	@Transactional
	@Override	
	public void onApplicationEvent( AuthenticationFailureBadCredentialsEvent event) {
		String username = (String) event.getAuthentication().getPrincipal();

		User user = adminService.findUserByUsername(username);
		if(user != null){
			int numLoginFailures = user.getNumLoginFailures() + 1;
			if(numLoginFailures >= maxFailures){
				user.setActive(false);
			}

			String strDetail = null;
			Object details = (Object) event.getAuthentication().getDetails();
			if(details != null){
				if(details instanceof WebAuthenticationDetails)
					strDetail = "IP: "+((WebAuthenticationDetails)details).getRemoteAddress()+
							" SessionID: "+((WebAuthenticationDetails)details).getSessionId();
				else
					strDetail = details.toString();
			}

			user.setLastLoginDetails(strDetail);
			user.setLastLoginTime(new Date());
			user.setNumLoginFailures(numLoginFailures);
			adminService.updateUser(user);
		}
	}

	public int getMaxFailures() {
		return maxFailures;
	}

	public void setMaxFailures(int maxFailures) {
		this.maxFailures = maxFailures;
	}
}
