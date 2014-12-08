package jisuu.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;


/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * FileLoaderStory
 * class for reading and returning information from the story file
 * 
 */
public class FileLoaderStory {
	
	
	public static final String STORY_FILENAME = "stories/story.txt";
	
	
	
	
	
	/*
	 * reads the given file, and returns a StoryReport for the file
	 */
	public static StoryReport loadStoryFromFile(File inputFile){
		
		//return null if file cannot be opened
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new FileInputStream(inputFile), "utf-8");
		} catch (FileNotFoundException e) {
			System.out.printf("\n!!!---Error reading input file (%s).\n\n", inputFile.getAbsolutePath());
			return null;
		}
		
		
		int linesRead = 0;
		KanjiSet kanjiSet = new KanjiSet();
		
		String inputLine = "";
		
		//for each line, add its kanji to the kanjiSet
		while (fileReader.hasNext()){
			linesRead++;
			inputLine = fileReader.nextLine();
			kanjiSet.add(inputLine);
		}
		

		fileReader.close();

		System.out.println(".........Loaded " + linesRead + " lines from " + inputFile.getName());
		StoryReport storyReport = new StoryReport(kanjiSet, linesRead, inputFile.getName());
		
		return storyReport;
	}
	//overloeaded for String filename instead of a File object
	public static StoryReport loadStoryFromFile(){return loadStoryFromFile(STORY_FILENAME);}
	public static StoryReport loadStoryFromFile(String inputFileString){return loadStoryFromFile(new File(inputFileString));}
	
	
	
	
	
	
	
	
}
