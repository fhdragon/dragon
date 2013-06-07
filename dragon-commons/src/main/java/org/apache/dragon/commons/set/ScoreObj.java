package org.apache.dragon.commons.set;

import java.util.Arrays;

/**
 * The score of this obj for priority queue
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-6-6
 * @since 1.0
 */
public class ScoreObj {

	// Local variables
	/**
	 * Expert: The score of this obj.
	 */
	public double[] scores;
	/**
	 * obj
	 */
	public Object obj;

	// constructor
	/**
	 * Constructs a ScoreObj.
	 * 
	 * @param obj
	 * @param scores
	 */
	public ScoreObj(Object obj, double[] scores) {
		this.obj = obj;
		if(scores == null || scores.length < 1){
			scores = new double[]{0};
		}
		this.scores = scores;
	}

	//setter and getter
	/**
	 * @return the scores
	 */
	public double[] getScores() {
		return scores;
	}
	/**
	 * @param scores the scores to set
	 */
	public void setScores(double[] scores) {
		if(scores == null || scores.length < 1){
			scores = new double[]{0};
		}
		this.scores = scores;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 100;
		return "ScoreObj [scores="
				+ (scores != null ? Arrays.toString(Arrays.copyOf(scores, Math.min(scores.length, maxLen))) : null)
				+ ", obj=" + obj + "]";
	}
	
}
