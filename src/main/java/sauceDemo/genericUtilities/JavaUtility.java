package sauceDemo.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class generic method relate to JavaUtilty like Date , Random Number
 * @author Abhinav Mishra
 */
public class JavaUtility {
	/**
	 * Will return date in "DD-MM-YYYY"
	 * 
	 * @return
	 */

	public String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String strDate = formatter.format(date);
		return strDate;
	}
	/**
	 * This will generate random long number
	 * @param num
	 * @return
	 */

	public long randomNumber(int num) {
		long min = (long) Math.pow(10, num - 1);
		long max = (long) Math.pow(10, num) - 1;
		return min + (long) (Math.random() * (max - min + 1));
	}

}
