package domain;

import org.springframework.hateoas.Identifiable;

public class Order implements Identifiable<Long> {

	private Long id;
	private String description;
	private long costInCents;
	private boolean isComplete;
	
	@Override
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCostInCents() {
		return costInCents;
	}

	public void setCostInCents(long costInCents) {
		this.costInCents = costInCents;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public void markComplete() {
		setComplete(true);
	}
	
	public void markIncomplete() {
		setComplete(false);
	}
	
}
