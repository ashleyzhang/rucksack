//Ashley Zhang + Grace Gent

public class Task extends Appt
{
   private String name;
	private double duration;
	private Time deadline;
	private int priority;
	
	public Task(String n, Time s, Time e, double du, Time de, int p) {
		super(n, s, e);
		duration = du;
		deadline = de;
		priority = p;
	}
	
	public void setDuration(double du) {
		duration = du;
	}
	
	public void setDeadline(Time de) {
		deadline = de;
	}
	
	public void setPriority(int p) {
		priority = p;
	}

	public int getPriority() {
		return priority;
	}
	
	public int getValue() {
		return priority;
	}
}