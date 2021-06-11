package com.easytocourse.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.easytocourse.model.Medicine;

public class Csvhelper {
	public static String TYPE = "text/csv";
	

	public static List<Medicine> csvToMedicines(InputStream is) throws NumberFormatException, ParseException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Medicine> Medicines = new ArrayList<Medicine>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			for (CSVRecord csvRecord : csvRecords) {
				Medicine Medicine = new Medicine(csvRecord.get(0), csvRecord.get(1), formatter.parse(csvRecord.get(2)),
						Integer.parseInt(csvRecord.get(3)), csvRecord.get(4), csvRecord.get(5), csvRecord.get(6),
						Double.parseDouble(csvRecord.get(7)), csvRecord.get(8), Integer.parseInt(csvRecord.get(9))

				);

				Medicines.add(Medicine);
			}

			return Medicines;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}