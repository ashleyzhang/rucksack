//Ashley Zhang + Grace Gent

import java.util.Date;

public class Deadline
{
	private Date date;
	private Time time;
	
	public Deadline(Date d, Time t) {
		date = d;
		time = t;
	}
	
	public void setDate(Date d) {
		date = d;
	}
	
	public void setTime(Time t) {
		time = t;
	}
}