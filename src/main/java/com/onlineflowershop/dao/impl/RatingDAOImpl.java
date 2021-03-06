package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineflowershop.dao.RatingDAO;
import com.onlineflowershop.util.ConnectionUtil;

public class RatingDAOImpl implements RatingDAO {

	public void updateRating(int rating, int flowerId) throws SQLException {
		String updateQuery = "update inventory set rating=? where flower_id=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, rating);
			pstmt.setInt(2, flowerId);
			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	public int findRating(String flowerName) throws SQLException {
		String findRating = "select rating from inventory where flower_name='" + flowerName + "'";
		Connection con = null;
		PreparedStatement stmt = null;
		int rating = 0;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(findRating);

			rs = stmt.executeQuery();
			if (rs.next()) {
				rating = rs.getInt(1);

			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return rating;

	}

}
