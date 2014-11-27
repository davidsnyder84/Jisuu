package jisuu.kanji;

import java.util.Collection;
import java.util.HashSet;





public class KanjiChar {
	
//	public static final String nonKanji = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん゠ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ々ヶーーabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[];',.\\/~!@#$%^&*()_+{}|:<\">?\n\0ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０『』「」’”、。・＜＞？！＠＃＄％＾＆＊‘－＝「」￥；’、。・～！＠＃＄％＾＆＊（）＿＋｛｝｜：”＜＞？";
//	public static final String nonKanji = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん゠ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ々ヶーーabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[];',.\\/~!@#$%^&*()_+{}|:<\">?\n\0ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０『』「」’”、。・＜＞？！＠＃＄％＾＆＊‘－＝「」￥；’、。・～！＠＃＄％＾＆＊（）＿＋｛｝｜：”＜＞？，．･ω―“…─○●☆♪゛";
	public static final String nonKanji = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん゠ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ々ヶーーabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[];',.\\/~!@#$%^&*()_+{}|:<\">?\n\0ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ１２３４５６７８９０『』「」’”、。・＜＞？！＠＃＄％＾＆＊‘－＝「」￥；’、。・～！＠＃＄％＾＆＊（）＿＋｛｝｜：”＜＞？，．･ω―“…─○●☆♪゛×‐℃■▲　";
	public static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "";
	//maybe use whitelist instead
	
	
	
	private static final Collection<Character> nonKanjiCollection = new HashSet<Character>();
	
	static{for (Character c: nonKanji.toCharArray()) nonKanjiCollection.add(c);}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Collection<Character> setOfNonKanji(){
		return nonKanjiCollection;
	}
	
	
	
	
	public static boolean isKanji(char c){
		return (nonKanji.indexOf(c) == -1);
	}
	
	
	
	
}
