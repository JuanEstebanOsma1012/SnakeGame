package model;

public class User {

	private int score;
	private int maxScore;
	private String name;
	
	public User(String name){
		
		this.name = name;
		
	}
	
	public void setearMaxScore(){
		if (score > maxScore) {
			maxScore = score;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
