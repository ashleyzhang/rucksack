//Ashley Zhang + Grace Gent

public class Appt implements Comparable<Appt>
{
   private String name;
	private Time start;
	private Time end;
	
	public Appt(String n, Time s, Time e) {
      name = n;
		start = s;
		end = e;
	}
	
	public void setStart(Time s) {
		start = s;
	}
	
	public void setEnd(Time e) {
		end = e;
	}
   
   public Time getStart() {
      return start;
   }
   
   public int minBetween(Appt other) {
      return end.minBetween(other.getStart());
   }
   
   public String toString() {
      if(start != null) {
         return name + " from " + start + " to " + end;
      }
      else {
         return name;
      }
   }
   
   public int compareTo(Appt other) {
      if(start.compareTo(other.getStart()) < 0) {
         return -1;
      }
      else if(start.compareTo(other.getStart()) > 0) {
         return 1;
      }
      return 0;
   }
}