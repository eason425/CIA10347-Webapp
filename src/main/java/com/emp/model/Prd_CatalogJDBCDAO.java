package com.emp.model;

import java.util.*;
import java.sql.*;

public class Prd_CatalogJDBCDAO implements Prd_CatalogDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/team4?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "eason425";

	private static final String INSERT_STMT = 
		"INSERT INTO prd_catalog (name) VALUES (?)";
	private static final String GET_ALL_STMT = 
		"SELECT id,name FROM prd_catalog order by id";
	private static final String GET_ONE_STMT = 
		"SELECT id,name FROM prd_catalog where id = ?";
	private static final String DELETE = 
		"DELETE FROM prd_catalog where id = ?";
	private static final String UPDATE = 
		"UPDATE prd_catalog set name=? where id = ?";

	@Override
	public void insert(Prd_CatalogVO prd_CatalogVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, prd_CatalogVO.getName());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Prd_CatalogVO prd_CatalogVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, prd_CatalogVO.getName());
			pstmt.setInt(2, prd_CatalogVO.getId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Prd_CatalogVO findByPrimaryKey(Integer id) {

		Prd_CatalogVO prd_CatalogVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				prd_CatalogVO = new Prd_CatalogVO();
				prd_CatalogVO.setId(rs.getInt("id"));
				prd_CatalogVO.setName(rs.getString("name"));		
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return prd_CatalogVO;
	}

	@Override
	public List<Prd_CatalogVO> getAll() {
		List<Prd_CatalogVO> list = new ArrayList<Prd_CatalogVO>();
		Prd_CatalogVO prd_CatalogVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				prd_CatalogVO = new Prd_CatalogVO();
				prd_CatalogVO.setId(rs.getInt("id"));
				prd_CatalogVO.setName(rs.getString("name"));
				
				list.add(prd_CatalogVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		Prd_CatalogJDBCDAO dao = new Prd_CatalogJDBCDAO();

		// 新增
//		Prd_CatalogVO prd_CatalogVO1 = new Prd_CatalogVO();
//		prd_CatalogVO1.setName("吳永志1");
//		dao.insert(prd_CatalogVO1);

		// 修改
		Prd_CatalogVO prd_CatalogVO2 = new Prd_CatalogVO();
		prd_CatalogVO2.setId(11);
		prd_CatalogVO2.setName("吳永志2");
		dao.update(prd_CatalogVO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
		Prd_CatalogVO prd_CatalogVO3 = dao.findByPrimaryKey(2);
		System.out.print(prd_CatalogVO3.getId() + ",");
		System.out.print(prd_CatalogVO3.getName() );
		System.out.println("---------------------");

		// 查詢
		List<Prd_CatalogVO> list = dao.getAll();
		for (Prd_CatalogVO aPrd_Catalog : list) {
			System.out.print(aPrd_Catalog.getId() + ",");
			System.out.print(aPrd_Catalog.getName() );
			System.out.println();
		}
	}
}