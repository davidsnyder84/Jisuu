package jisuu.fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;



/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * FileWriterReport
 * class for saving a report to a file
 * 
 */
public class FileWriterReport {
	
	
	
	
	/*
	 * writes the received string to a file named after the current date/time
	 */
	public static boolean writeReportToFile(String reportContents){
		
		//create a filename with the current date
		String filename = "jisuu_report_";
		filename += new SimpleDateFormat("yyyy-MM-dd_HH;mm").format(new Date());
		filename += ".txt";
		
		
		
		//try to open the file
		OutputStreamWriter fileWrite;
		try {
			fileWrite = new OutputStreamWriter(new FileOutputStream(filename), "UTF-8");
		} catch (Exception e) {
			System.out.println("---Error creating file " + filename + " for writing---");
			e.printStackTrace();
			return false;
		}
		
		//write the report to the file
		try {
			fileWrite.write(reportContents);
			System.out.println("...Report saved to " + filename);
		} catch (IOException e) {
			System.out.println("---Error writing to file " + filename + "---");
			e.printStackTrace();
		}
		
		
		//close file and return true if successful
		try {
			fileWrite.close();
		} catch (IOException e) {
			System.out.println("---Error closing file " + filename + "---");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
