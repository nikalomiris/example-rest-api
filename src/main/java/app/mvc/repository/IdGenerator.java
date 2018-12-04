package app.mvc.repository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // This Spring annotation makes the class "injectable" to other classes
@Scope(BeanDefinition.SCOPE_PROTOTYPE) // Every time it is injected a new instance is created 
									   // instead of being treated as a Singleton
public class IdGenerator {
	
	// AtomicLong type makes sure that no identical ids are generated. 
	// Synchronization logic necessary in a concurrent web application
	private AtomicLong nextId = new AtomicLong(1);
	
	public long getNextId() {
		return nextId.getAndIncrement();
	}
}
