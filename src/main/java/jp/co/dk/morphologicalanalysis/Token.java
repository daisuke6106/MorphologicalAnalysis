package jp.co.dk.morphologicalanalysis;

public class Token {

	/** トークンオブジェクト */
	protected org.atilika.kuromoji.Token token;
	
	Token(org.atilika.kuromoji.Token token){
		this.token = token;
	}
	
	public int getPosition()  {
		return this.token.getPosition();
	}
	
	public boolean isNoun() {
		return "名詞".equals(token.getAllFeaturesArray()[0]);
	}
	
	@Override
	public String toString() {
		return this.token.getSurfaceForm();
	}
}
