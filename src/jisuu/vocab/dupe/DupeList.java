package jisuu.vocab.dupe;

import java.util.ArrayList;

public class DupeList extends ArrayList<Dupe>{
	private static final long serialVersionUID = 797551024803265737L;
	
	
	
	
	public String toString(){
		String listString = "";
		for (Dupe d: this) listString += d.toString() + "\n";
			
		return listString;
	}
	
}
