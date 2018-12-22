package org.upec.masters.app;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.upec.master.RessourcesRest;

@ApplicationPath("/")
public class Appli extends ResourceConfig {

	public Appli() {
		// Register resources and providers using package-scanning.
		packages("org.upec.master");

		// Register my custom provider - not needed if it's in my.package.
		register(RessourcesRest.class);
		// Register an instance of LoggingFilter.
		

	}
	
	
}
