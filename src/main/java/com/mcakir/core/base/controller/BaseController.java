package com.mcakir.core.base.controller;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Enumeration;

public abstract class BaseController {

	private String viewBase = "";

    protected BaseController() {
    }
    
    protected BaseController(String viewBase){
		setViewBase(viewBase);
    }
    
    protected String render(String viewName) {
        return viewBase + viewName;
    }

	protected String forwardTo(String location){
		return "forward:/" + location;
	}

	protected String redirectTo(String location){
		return "redirect:/" + location;
	}

	public void setViewBase(String viewBase){
		if (viewBase != null) {
			viewBase = viewBase.trim();
			if (viewBase.length() > 0){
				this.viewBase = viewBase + "/";
			}
		}
	}

	public String getViewBase() {
		return viewBase;
	}

	@SuppressWarnings("unchecked")
	protected String getMethodParameters(HttpServletRequest request){
	
    	StringBuilder result = new StringBuilder();
	
    	Enumeration<String> params = request.getParameterNames();
	
    	while (params.hasMoreElements()) {
    		String paramName = (String) params.nextElement();
    		String value = paramName + ":" + request.getParameter(paramName) + " ";
    		result.append(value);
    	}
    	return result.toString();
    }
    
    protected String getClientIP(HttpServletRequest request){
		 String remoteIp = request.getRemoteAddr();
	     String proxyIp = request.getHeader("X-Forwarded-For");
	     if (proxyIp.isEmpty()) 
	     	return remoteIp;
	     else {
	    	String forwardedIp = proxyIp;
	      	String [] ipTokens = forwardedIp.split(",");
	      	if(ipTokens != null && ipTokens.length > 1) forwardedIp = ipTokens[ipTokens.length -2].trim();
	       	return forwardedIp.isEmpty() ? remoteIp : forwardedIp;
	 	}    	
    }
    
    protected String getServerIP(){
    	try{
    		return InetAddress.getLocalHost().getHostAddress();
    	} catch(Exception ex){
    		return null;
    	}
    }
}
