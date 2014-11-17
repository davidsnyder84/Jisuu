package jisuu.vocab;

import jisuu.vocab.dupe.DupeList;

public class DupeFinder {
	

	private final TangoList mTangoList;
	
	
	public DupeFinder(TangoList list){
		if (list != null) mTangoList = list;
		else mTangoList = new TangoList();
	}
	
	
	
	
	public void printConflicts(){
		
		DupeList conflicts = mTangoList.findAllConflicts();
		
		if (conflicts.isEmpty())
			System.out.println("No conflicts found!");
		else
			System.out.println(conflicts.toString());
		
		
		
	}
	
	
	
	
}
