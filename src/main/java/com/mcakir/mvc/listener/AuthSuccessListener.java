package com.mcakir.mvc.listener;

import com.mcakir.core.model.Menu;
import com.mcakir.core.model.User;
import com.mcakir.core.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

	public static String USER_VAR = "cUser";
	public static String USER_MENUS_VAR = "cUserMenus";

	@Autowired
	IAdminService adminService;

	@Autowired
	HttpSession session;

	@Transactional
	@Override	
	public void onApplicationEvent(AuthenticationSuccessEvent event) {

		UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
		String username = userDetails.getUsername();

		User user = adminService.findUserByUsername(username);
		if(user != null){
			String strDetail = null;
			Object details = (Object) event.getAuthentication().getDetails();
			if(details != null){
				if(details instanceof WebAuthenticationDetails)
					strDetail = "IP: "+((WebAuthenticationDetails)details).getRemoteAddress()+
							" SessionID: "+((WebAuthenticationDetails)details).getSessionId();
				else
					strDetail = details.toString();
			}

			List<Menu> menus = getMenu(user.getRole().getMenus());
			session.setAttribute(USER_VAR, user);
			session.setAttribute(USER_MENUS_VAR, menus);

			user.setLastLoginDetails(strDetail);
			user.setLastLoginTime(new Date());
			user.setNumLoginFailures(0);
			adminService.updateUser(user);
		}
	}

	private List<Menu> getMenu(Set<Menu> menuList){
		List<Menu> menus = new ArrayList<Menu>();
		for (Menu menu : menuList) {
			if(menu.getParent() == null){
				List<Menu> childs = new ArrayList<Menu>();
				for (Menu child : menuList) {
					if(child.getParent() != null && child.getParent().equals(menu)){
						childs.add(child);
					}
				}
				menu.setChilds(childs);
				menus.add(menu);
			}
		}
		return menus;
	}

}
