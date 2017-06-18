//Ashley Zhang + Grace Gent

public class Time implements Comparable<Time>
{
	private int hour;
	private int minute;
	
	public Time(int h, int m) {
		hour = h;
		minute = m;
	}
	
	public void setHour(int hr) {
		hour = hr;
	}
   
   public int getHour() {
      return hour;
   }
	
	public void setMinute(int min) {
		minute = min;
	}
   
   public int getMinute() {
      return minute;
   }
	
	public void advance(int min) {
		if(minute + min < 60) {
			minute += min;
		}
		else {
			hour += (minute + min) / 60;
			minute = (minute + min) % 60;
		}
	}
   
   public int minBetween(Time other) {
      if(hour == other.getHour()) {
         return Math.abs(other.getMinute() - minute);
      }
      else if(hour < other.getHour()) {
         return (other.getHour() - hour) * 60 + other.getMinute() - minute;
      }
      else {
         return(hour - other.getHour()) * 60 + minute - other.getMinute();
      }
   }
	
	public String toString() {
		if(minute < 10) {
			return hour + ":0" + minute;
		}
		else { 
			return hour + ":" + minute;
		}
	}
   
   public int compareTo(Time other) {
      if(hour < other.getHour()) {
         return -1;
      }
      else if(hour > other.getHour()) {
         return 1;
      }
      else {
         if(minute < other.getMinute()) {
            return -1;
         }
         else if(minute > other.getMinute()) {
            return 1;
         }
      }
      return 0;
   }
}
   
