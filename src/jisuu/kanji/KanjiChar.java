package jisuu.kanji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import jisuu.vocab.Tango;

public class KanjiChar {
	
//	public static final String nonKanji = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん゠ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ々ヶーーabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[];',.\\/~!@#$%^&*()_+{}|:<\">?\n\0ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
	public static final String nonKanji = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん゠ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ々ヶーーabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[];',.\\/~!@#$%^&*()_+{}|:<\">?\n\0ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０『』「」’”、。・＜＞？！＠＃＄％＾＆＊‘－＝「」￥；’、。・～！＠＃＄％＾＆＊（）＿＋｛｝｜：”＜＞？";
	public static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "\n";
	//maybe use whitelist instead
	
	
	
	private static final Collection<Character> nonKanjiCollection = new HashSet<Character>();
	
	
	static{for (Character c: nonKanji.toCharArray()) nonKanjiCollection.add(c);}
	
	
	public static Collection<Character> setOfNonKanji(){
		return nonKanjiCollection;
	}
	
	
	
	
	
	
	
	
	

	//get a collection containing the unique kanji
	public static Collection<Character> getUniqueKanji(List<String> strings){
		Collection<Character> uniqueK = new HashSet<Character>();
		
		char[] charArray = null;
		
		//add unique characters
		for (String s: strings){
			charArray = s.toCharArray();
			for (Character c: charArray)
				uniqueK.add(c);
		}
		
		//remove non-kanji characters
		uniqueK.removeAll(KanjiChar.setOfNonKanji());
		
		return uniqueK;
	}
	public static Collection<Character> getUniqueKanji(String string){return getUniqueKanji(Arrays.asList(string));}
	
	
	
	
	//get a string containing the unique kanji
	public static String getUniqueKanjiString(List<String> strings, String splitter){
		String kString = "";
		
//		Collection<Character> uniqueK = getUniqueKanji(strings);
		List<Character> uniqueKs = new ArrayList<Character>(getUniqueKanji(strings));
		Collections.sort(uniqueKs);
		
		for (Character c: uniqueKs)
			kString += c + splitter;
		
		return kString;
	}
	public static String getUniqueKanjiString(List<String> strings){return getUniqueKanjiString(strings, DEFAULT_UNIQUE_KANJI_SPLITTER);}
	
	
	
	
	
	
	
	
	
	
}
