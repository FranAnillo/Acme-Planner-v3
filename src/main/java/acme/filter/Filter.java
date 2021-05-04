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
		int words=1;
		if (s.contains(" ")) words= s.split(" ").length;
		 s.toLowerCase().trim();
		int k = 0;
		final List<String> censoredWords= Filter.censoredWords();
			for(int i = 0; censoredWords.size()>i; i++) {
				if(s.contains(censoredWords.get(i))) {
					//return false;
					k++;
				}
			
			
		}
			if (k>0.1*words) return false;
		return true;
	}
}
