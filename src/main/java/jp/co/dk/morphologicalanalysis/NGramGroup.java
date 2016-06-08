package jp.co.dk.morphologicalanalysis;

import java.util.ArrayList;
import java.util.List;

public class NGramGroup {
	
	/** トークン一覧 */
	protected List<jp.co.dk.morphologicalanalysis.Token> tokenList = new ArrayList<>();
	
	NGramGroup(List<jp.co.dk.morphologicalanalysis.Token> tokenList) {
		this.tokenList = tokenList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tokenList == null) ? 0 : tokenList.hashCode());
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
		NGramGroup other = (NGramGroup) obj;
		if (tokenList == null) {
			if (other.tokenList != null)
				return false;
		} else if (!tokenList.equals(other.tokenList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tokenList.toString();
	}
}
