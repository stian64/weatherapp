package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

	private String todaysdate;

	public String yrdatoformatering() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		todaysdate = dateFormat.format(date);
		return todaysdate = todaysdate.substring(0, 10) + "T"
				+ todaysdate.substring(11, 19);
	}

	public String showtimeformat(String dates) {

		dates = dates.substring(11, 16) + " til  " + dates.substring(33, 38);

		return dates;

	}

}
