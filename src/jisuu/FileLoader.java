package jisuu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import jisuu.vocab.Tango;
import jisuu.vocab.TangoList;

public class FileLoader {
	
	
	public static final String VOCABLIST_DIR = "vocabLists";
	
	
	
	
	public static TangoList loadAllVocabFiles(){
		
		
		TangoList tangoList = null;
		TangoList overallList = new TangoList();
		
		
		File vocabListDir = new File(VOCABLIST_DIR);
		
		
		//load each file into the list
		for (File f: vocabListDir.listFiles()){
			tangoList = loadVocabFromFile(f);
			if (tangoList == null) return null;
			overallList.addAll(tangoList);
		}
		
		
		//sort by name
		Collections.sort(overallList);
		
		System.out.println(".........Loaded " + overallList.size() + " vocab cards total\n\n");
		
		return overallList;
	}
	
	
	
	
	
	
	//loads all vocab from a given file and returns it as a TangoList
	public static TangoList loadVocabFromFile(File inputFile){

		final String LINESPLITTER = "\t";
		final int FIELD_FRONT = 0, FIELD_BACK = 1;
		final int NUM_FIELDS = 2;
		
		
		TangoList tangoList = new TangoList();
		
		
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
				tangoList.add(new Tango(splitLine[FIELD_FRONT], splitLine[FIELD_BACK], inputFile.getName()));
		}
		

		System.out.println("...Loaded " + tangoList.size() + " vocab cards from " + inputFile.getName());
		
		fileReader.close();
		return tangoList;
	}
	public static List<Tango> loadVocabFromFile(String inputFileString){return loadVocabFromFile(inputFileString);}
	
	
	
	
	
	
	
	
	
	
	
}
