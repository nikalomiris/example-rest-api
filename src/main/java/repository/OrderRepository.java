package repository;

import org.springframework.stereotype.Repository;

import domain.Order;

@Repository // allows our class to be injected into other classes by the Spring DI framework,
			// but also includes additional database-related capabilities
public class OrderRepository extends InMemoryRepository<Order> {
	
	protected void updateIfExists(Order original, Order updated) {
		original.setDescription(updated.getDescription());
		original.setCostInCents(updated.getCostInCents());
		original.setComplete(updated.isComplete());
	}
}
