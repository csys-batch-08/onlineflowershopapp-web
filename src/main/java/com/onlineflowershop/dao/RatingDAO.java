package com.onlineflowershop.dao;

public interface RatingDAO {
	
	public  void updateRating(int rating,int flowerId);
	public  int findRating(String flowerName);

}
