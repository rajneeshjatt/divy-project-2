package AdditionalLogicCode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
		
		Date dt =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.format(dt);
		
		System.out.println(dt.toString());
		System.out.println(dt.toString());
		
		
		Calendar cl = Calendar.getInstance();
		sdf.format(cl);
		
		
		
	}

}
