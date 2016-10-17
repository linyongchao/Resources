package celloud.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import celloud.mongo.DateUtils;

public class MysqlUtils {
	private static String username = "root";
	private static String password = "novacloud";
	private static String host = "localhost";
	private static String port = "3306";
	private static String database = "celloud";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + username
			+ "&password=" + password + "&useUnicode=true&characterEncoding=UTF8";

	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("成功加载MySQL驱动程序");
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static List<Map<String, String>> query(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				//				map.put("month", rs.getString("month"));
				//				map.put("num", rs.getString("num"));
				//				map.put("size", rs.getString("size"));
				map.put("file_id", rs.getString("file_id"));
				map.put("file_name", rs.getString("file_name"));
				map.put("size", rs.getString("size"));
				map.put("username", rs.getString("username"));
				map.put("create_date", DateUtils.getString(rs.getTimestamp("create_date")));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		free(conn, stmt, rs);
		return list;
	}

	public static int update(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		free(conn, stmt, null);
		return result;
	}

	private static void free(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
