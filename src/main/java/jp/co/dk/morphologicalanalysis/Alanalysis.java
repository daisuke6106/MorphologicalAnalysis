package jp.co.dk.morphologicalanalysis;

import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;

public class Alanalysis {
	public Alanalysis(String target) {
		Builder builder = Tokenizer.builder();
		Tokenizer normal = builder.build();
		
		// Searchモード
		builder.mode(Mode.SEARCH);
		
		// Extendsモード
		builder.mode(Mode.EXTENDED);
		Tokenizer extended = builder.build();
		
		List<Token> tokensNormal = normal.tokenize(target);
	}
}
