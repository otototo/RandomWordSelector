package com.pjinc;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.pjinc.resources.WordSelectorResource;

@ApplicationPath("/rest")
public class ApplicationConfig extends ResourceConfig {
	
	public ApplicationConfig() {
		packages(WordSelectorResource.class.getPackage().toString());
	}

	
//	@Override
//	public Set<Class<?>> getClasses() {
//		Set<Class<?>> s = new HashSet<Class<?>>();
//		s.add(CodeNamesRestApi.class);
//		return s;
//	}
}
