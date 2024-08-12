package techround.microsoft;

public class FindLastBusLeftWithCurrentTIme {
	
public static int LastBus(String[] schedule, String time) {
    	
    	if(schedule == null || schedule.length<1 || time == null || time.isEmpty())
    		return -1;
    	
    	String[] tarr = time.split(":");
    	int hour = Integer.valueOf(tarr[0])*60;
    	int sec = Integer.valueOf(tarr[1]);
    	
    	int totalTime = hour+sec;
    	int busleft = 0;
    	int result = 0;
    	
    	for(int i=0; i<schedule.length; i++) {
    		String st = schedule[i];
    		String[] sarr = st.split(":");
    		
    		int hour1 = Integer.valueOf(sarr[0])*60;
        	int sec1 = Integer.valueOf(sarr[1]);
        	
        	int totalTime1 = hour1+sec1;
        	
        	if(totalTime1<totalTime) {
        		busleft = totalTime1;
        		continue;
        	}else {
        		if(busleft>0) {
        			result = totalTime - busleft;
        		}else {
        			result = totalTime - totalTime1;
        		}
        		
        	}
    	}
    	
    	
    	if(result == 0) {
    		result = totalTime - busleft;
    	}else if(result<0) {
    		return -1;
    	}
    	
    	return result;
    	
    }


	public static void main(String[] args) {
		
		String[] str = {"12:30", "15:00", "19:30"};
		String time = "20:30";
		
		System.out.println("last bus :::"+LastBus(str, time));
		
	}

}
