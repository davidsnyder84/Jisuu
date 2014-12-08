package jisuu.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter fileWriter;
		try {
			fileWriter = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			System.out.println("---Error creating file " + filename + " for writing---");
			return false;
		}
		
		
		//write the report to the file
		fileWriter.println(reportContents);
		
		
		//close file and return true (success)
		System.out.println("...Report saved to " + filename);
		fileWriter.close();
		return true;
	}
	
	
}
