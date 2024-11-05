package Com.comcast.crm.genaric.WebDriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum() {
		Random ran = new Random();
		int rancount = ran.nextInt(5000);

		return rancount;

	}

	public String getSystemDate() {
		Date ref = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		String current = sim.format(ref);
		return current;

	}

	public String getendDtae(int value) {
		Date ref=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy/MM/dd");
		sim.format(ref);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, value);
		String endDate = sim.format(cal.getTime());

		return endDate;

	}

}
