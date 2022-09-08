package com.codemobiles.stock.backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	String todayString() {
		return simpleDateFormat.format(new Date());
	}

}
