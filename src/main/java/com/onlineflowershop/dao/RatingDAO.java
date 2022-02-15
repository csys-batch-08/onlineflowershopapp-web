package com.onlineflowershop.dao;

import java.sql.SQLException;

public interface RatingDAO {

	public void updateRating(int rating, int flowerId) throws SQLException;

	public int findRating(String flowerName) throws SQLException;

}
