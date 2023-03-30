package com.example.HL7Project.Entity;

import java.util.HashMap;
import java.util.Map;

public class Parser {

	static String CATEGORY_KEY[] = { "Message Header", "Encoding Characters", "Sending Application", "Sending Facility",
			"Receiving Application", "Receiving Facility", "DateTime Of Message", "Security", "Message Type",
			"Message Control ID", "Processing ID", "Version ID", "Sequence Number", "Continuation Pointer",
			"Accept Acknowledgment Type", "Application Acknowledgment Type", "Country Code" };

	public static Map<String, String> messageParser(String msg) throws Exception {

		if (msg == null) {
			throw new Exception("Message should not be null");
		}
		Map<String, String> result = new HashMap<>();

		int counter = 0;
		String[] values = msg.split("\\^");
		result.put("Field Separator", "^");
		for (String value : values) {
			result.put(CATEGORY_KEY[counter], value);
			counter++;
		}
		return result;
	}
	public static void main(String[] args) {
		Parser tt = new Parser();
		String msg = " MSH^~|\\&^HTAPPL^200TSQA~SQA-VENDOR~DNS^HT CENSUS^688HT~SQA-VA~DNS^20170426112936^^MDM~T02^200TSQAApplication620170426112936^T^2.4^^^AL^AL^USA^";
		try {
			Map<String, String> result = tt.messageParser(msg);

			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}