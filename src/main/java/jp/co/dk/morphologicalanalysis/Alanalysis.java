package jp.co.dk.morphologicalanalysis;

import java.util.ArrayList;
import java.util.List;

import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;

/**
 * Alanalysisは、指定の日本語文字列を形態素解析し、その結果を管理するクラスです。
 * 
 * @version 0.1
 * @author D.Kanno
 */
public class Alanalysis {
	
	/** org.atilika.kuromozi.Builder */
	protected static Builder builder;
	
	/** org.atilika.kuromozi.Tokenizer */
	protected static Tokenizer searchTokenizer;
	
	/** 解析を行ったトークン一覧 */
	protected List<jp.co.dk.morphologicalanalysis.Token> tokenList = new ArrayList<>();
	
	static {
		builder = Tokenizer.builder();
		// Searchモード
		builder.mode(Mode.SEARCH);
		// Extendsモード
		// builder.mode(Mode.EXTENDED);
		searchTokenizer = builder.build();
	}
	
	/**
	 * <p>コンストラクタ</p>
	 * 指定の文字列を基に形態素解析を行い、トークンに分け、保持します。<br/>
	 * 解析対象となるのは日本語のみとなります。
	 * 
	 * @param target 形態素解析対象文字列
	 */
	public Alanalysis(String target) {
		List<org.atilika.kuromoji.Token> tokenList = searchTokenizer.tokenize(target);
		for (org.atilika.kuromoji.Token token : tokenList) {
			this.tokenList.add(new jp.co.dk.morphologicalanalysis.Token(token));
		}
	}
	
	/**
	 * 本文字列内に保持している全トークンを取得します。
	 * @return トークン一覧
	 */
	public List<jp.co.dk.morphologicalanalysis.Token> getToken() {
		return this.tokenList;
	}
	
	/**
	 * 本文字列内に保持している名詞を一覧で取得する。
	 * @return 名詞一覧
	 */
	public List<jp.co.dk.morphologicalanalysis.Token> getNouns() {
		List<jp.co.dk.morphologicalanalysis.Token> nouns = new ArrayList<>();
		for (jp.co.dk.morphologicalanalysis.Token token : this.tokenList) if (token.isNoun()) nouns.add(token);
		return nouns;
	}
}
