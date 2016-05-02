package collections;

public class Rating {
	
	private int stars;
	private String user_id;
	private String description; 
	
	public Rating (int stars, String user_id, String description){
		this.stars = stars;
		this.user_id = user_id;
		this.description = description;
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
