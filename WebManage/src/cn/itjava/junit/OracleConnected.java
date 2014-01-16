package cn.itjava.junit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itjava.util.JdbcTool;

public class OracleConnected {
	@Test
	public void testConnection(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from emp");
			rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString(1)+":"+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
	}

}
