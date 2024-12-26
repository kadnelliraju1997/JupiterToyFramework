package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {

	public String getSystemDateYYYYMMDD() {
		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd_hhmmss");
		String date = sdf.format(d);
		return date;
	}


}
