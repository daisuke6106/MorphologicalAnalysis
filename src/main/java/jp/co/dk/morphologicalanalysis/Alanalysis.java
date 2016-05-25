package jp.co.dk.morphologicalanalysis;

import java.util.ArrayList;
import java.util.List;

import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;

public class Alanalysis {
	
	protected static Builder builder;
	
	protected static Tokenizer searchTokenizer;
	
	protected List<jp.co.dk.morphologicalanalysis.Token> tokenList = new ArrayList<>();
	
	static {
		builder = Tokenizer.builder();
		// Searchモード
		builder.mode(Mode.SEARCH);
		// Extendsモード
		// builder.mode(Mode.EXTENDED);
		searchTokenizer = builder.build();
	}
	
	public Alanalysis(String target) {
		List<org.atilika.kuromoji.Token> tokenList = searchTokenizer.tokenize(target);
		for (org.atilika.kuromoji.Token token : tokenList) {
			this.tokenList.add(new jp.co.dk.morphologicalanalysis.Token(token));
		}
	}
		
	public List<jp.co.dk.morphologicalanalysis.Token> getToken() {
		return this.tokenList;
	}
}
