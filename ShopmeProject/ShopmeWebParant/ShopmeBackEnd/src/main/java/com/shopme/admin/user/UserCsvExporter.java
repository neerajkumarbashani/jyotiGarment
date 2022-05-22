package com.shopme.admin.user;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.shopme.common.entity.User;

public class UserCsvExporter {

	public void export(List<User> list,	HttpServletResponse response) throws IOException {
		
		DateFormat formator = new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss");
		String timestamp = formator.format(new Date());

		String filename = "users" + timestamp + ".csv";
		response.setContentType("text/csv");
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=" + filename;
		response.setHeader(headerkey, headervalue);

		ICsvBeanWriter csv = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "User ID", "Email", "first name", "Roles", "Enables" };
		String[] fieldMappingr = { "id", "email", "firstName", "roles", "enabled" };
		
		
		
		csv.writeHeader(csvHeader);
		
		
		for(User user:list) {
			csv.write(user, fieldMappingr);
		}
		csv.close();

	}
}
