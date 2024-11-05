package HmsUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int randomNum() {
		Random ran = new Random();
		int rannum = ran.nextInt(1000);

		return rannum;

	}

	public String systemDate() {
		Date ref = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		String current = sim.format(ref);

		return current;

	}
	public void requirsdDate(int num) {
		Date ref=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,  num);
		String Acttime = sim.format(cal.getTime());
		
	}
}
