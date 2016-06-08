package jp.co.dk.morphologicalanalysis;

public class Token {
	
	/** 文字列 */
	protected String tokenStr;
	
	/** トークンオブジェクト */
	protected org.atilika.kuromoji.Token token;
	
	Token(org.atilika.kuromoji.Token token){
		this.token = token;
		this.tokenStr = this.toString();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tokenStr == null) ? 0 : tokenStr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (tokenStr == null) {
			if (other.tokenStr != null)
				return false;
		} else if (!tokenStr.equals(other.tokenStr))
			return false;
		return true;
	}
}
