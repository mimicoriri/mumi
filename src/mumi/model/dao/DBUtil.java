package mumi.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DB관련 로드, 연결 닫기를 위한 클래스
 **/
public class DBUtil {
	static DataSource ds;
	/**
	 * 로드 : 이 프로젝트 내에서는 한번만 사용함 Static initialized에서 작성 > 생성자 작성 > 메소드 작성
	 **/
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 연결
	 **/
	public static Connection getConnection() throws SQLException { // try catch해야 하지만 호출한 실행쪽에서 try catch 하도록 throws로
																	// 던진다.
		return ds.getConnection(); 
	}

	/**
	 * 닫기 insert, update, delete 인 경우
	 **/
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * select 인 경우 닫기
	 **/
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
