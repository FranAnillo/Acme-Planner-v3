package acme.filter;

import java.util.ArrayList;
import java.util.List;

public class Filter {

	public static List<String> censoredWords(){
	final List<String> res = new ArrayList<>();
	res.add("sex");
	res.add("sexo");
	res.add("hard core");
	res.add("pornografía");
	res.add("duro");
	res.add("viagra");
	res.add("cialis");
	res.add("tadalafil");
	res.add("nigeria");
	res.add("you’ve won");
	res.add("has ganado");
	res.add("million dollar");
	res.add("million euros");
	res.add("millon de dolares");
	res.add("millon de euros");
	return res;
	}
	public static boolean filterString(final String s) {
		final String[] words=s.toLowerCase().split(" ");
		int number = 1;
		boolean res=true;
		if(words.length>1) {
			number = words.length;
		}
		int numberBannedWords= 0;
		final List<String> censoredWords= Filter.censoredWords();
		for(int i = 0; censoredWords.size()>i; i++) {
		if(s.trim().contains(censoredWords.get(i).trim())) {
			numberBannedWords++;
		}	
		}
		if(numberBannedWords/number>0.1) {
			res= false;
		}
		return res;
	}
}
