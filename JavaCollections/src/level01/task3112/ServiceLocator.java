package level01.task3112;

import level01.task3112.context.InitialContext;
import level01.task3112.service.Service;

public class ServiceLocator {
	private static Cache cache;
	
	static {
		cache = new Cache();
	}
	
	/**
	 * First, check for a service object in the cache
	 * If a service object is not in the cache, perform a lookup using
	 * the JNDI initial context and get the service object. Add it to
	 * the cache for future use.
	 *
	 * @param jndiName The name of the service object in the context
	 * @return Object mapped to the name in context
	 */
	public static Service getService(String jndiName) {
		Service serviceCache = cache.getService(jndiName);
		if (serviceCache != null) {
			return serviceCache;
		}
		InitialContext context = new InitialContext();
		Service serviceContext = (Service) context.lookup(jndiName);
		cache.addService(serviceContext);
		return serviceContext;
	}

}
