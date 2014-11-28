package jisuu.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

import jisuu.vocab.Tango;
import jisuu.vocab.TangoDictionary;

public class FileLoaderVocab {
	
	
	public static final String VOCABLIST_DIR = "vocabLists";
	
	
	
	/*
	 * loads vocab from all files in the vocab directory, and returns it all in a list
	 */
	public static TangoDictionary loadAllVocabFiles(){
		
		
		TangoDictionary currentDict = null;
		TangoDictionary overallDict = new TangoDictionary();
		
		
		File vocabListDir = new File(VOCABLIST_DIR);
		
		
		
		//load each file into the list
		for (File f: vocabListDir.listFiles()){
			if (f.isFile()){	//check that f is a file (not a directory)
				currentDict = loadVocabFromFile(f);
				if (currentDict == null) return null;
				overallDict.addAll(currentDict);
			}
		}
		
		
		//sort by name
		Collections.sort(overallDict);
		
		System.out.println(".........Loaded " + overallDict.size() + " vocab cards total\n\n");
		
		return overallDict;
	}
	
	
	
	
	
	/*
	 * loads all the vocab from the given file, and returns it as a list
	 */
	public static TangoDictionary loadVocabFromFile(File inputFile){

		final String LINESPLITTER = "\t";
		final int FIELD_FRONT = 0, FIELD_BACK = 1;
		final int NUM_FIELDS = 2;
		
		
		TangoDictionary dict = new TangoDictionary();
		
		
		//return null if file cannot be opened
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new FileInputStream(inputFile), "utf-8");
		} catch (FileNotFoundException e) {
			System.out.printf("\n!!!---Error reading input file (%s).\n\n", inputFile.getAbsolutePath());
			return null;
		}
		
		
		
		String inputLine = "";
		String[] splitLine = null;
		
		while (fileReader.hasNext()){
			
			inputLine = fileReader.nextLine();
			splitLine = inputLine.split(LINESPLITTER);
			
			if (splitLine.length == NUM_FIELDS)
				dict.add(new Tango(splitLine[FIELD_FRONT], splitLine[FIELD_BACK], inputFile.getName()));
		}
		

		System.out.println("...Loaded " + dict.size() + " vocab cards from " + inputFile.getName());
		
		fileReader.close();
		return dict;
	}
	
	
	
	
	
	
	
	
	
	
	
}
