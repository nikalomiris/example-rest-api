package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import domain.Order;

@Component
public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource> {

	// Provides helper methods that provide for the construction of links 
	// using just the domain object type. This is accomplished by having 
	// a REST endpoint class use the@ExposesResourceFor(Class domainClass) 
	// annotation
	@Autowired
	protected EntityLinks entityLinks;
	
	private static final String UPDATE_REL = "update";
	private static final String DELETE_REL = "delete";
	
	@Override
	public OrderResource toResource(Order order) {
		
		OrderResource resource = new OrderResource(order);
		
		final Link selfLink = entityLinks.linkToSingleResource(order);
		
		resource.add(selfLink.withSelfRel());
		resource.add(selfLink.withRel(UPDATE_REL));
		resource.add(selfLink.withRel(DELETE_REL));
		
		return resource;
	}

}
