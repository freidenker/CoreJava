package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetCurrentDateTime {

	public GetCurrentDateTime() {
		// TODO Auto-generated constructor stub
	}
	
	  public static void main(String[] args) {

          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          DateFormat dateFormat2 = new SimpleDateFormat("E yyyy.MM.dd 'at' HH:mm:ss ");
          //get current date time with Date()
          Date date = new Date();
          System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);
          System.out.println(dateFormat.format(date));
          System.out.println(dateFormat2.format(date));

    //      Date todayWithZeroTime = dateFormat.parse(dateFormat.format(date));
          //get current date time with Calendar()
          Calendar cal = Calendar.getInstance();
          System.out.println(dateFormat.format(cal.getTime()));

 }


}
