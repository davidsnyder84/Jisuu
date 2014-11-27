package jisuu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;

public class FileLoaderStory {
	
	
	public static final String STORY_FILENAME = "stories/story.txt";
	
	
	
	
	
	
	//loads all vocab from a given file and returns it as a TangoList
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
	public static StoryReport loadStoryFromFile(){return loadStoryFromFile(STORY_FILENAME);}
	public static StoryReport loadStoryFromFile(String inputFileString){return loadStoryFromFile(new File(inputFileString));}
	
	
	
	
	
	
	
	
}
