package cn.itjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.itjava.dao.LogDao;
import cn.itjava.domain.Log;
import cn.itjava.util.JdbcTool;
import cn.itjava.util.PageModel;

public class LogDaoImpl implements LogDao {

	@Override
	public void insertRecord(Log log) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("insert into log(id, name, opera, time) values(log_seq.nextval, ?, ?, ?)");
			ps.setString(1, log.getName());
			ps.setString(2, log.getOpera());
			ps.setTimestamp(3, log.getTime());
			int ret = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
	}

	@Override
	public PageModel pageLog(String name, int pageNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Log> list = new ArrayList<Log>();
		PageModel pageModel = new PageModel();
		pageModel.setPageSize(8);
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from ( select rownum num, a.* from (select * from log where name like ? order by id desc) a where rownum<= "+pageNo * pageModel.getPageSize()+") where num>" + (pageNo-1) * pageModel.getPageSize());
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();

			while (rs.next()) {

				Log log = new Log();

				log.setName(rs.getString(3));
				log.setOpera(rs.getString(4));
				log.setTime(rs.getTimestamp(5));

				list.add(log);
			}
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setTotalRecords(getLogsCount(name));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return pageModel;
	}

	// 返回日志条数
	public int getLogsCount(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			// 我靠，搞了半天，居然是前面空格的问题，我去，看来字符串连接时，得好好注意下
			conn = JdbcTool.getConnection();
			String sql = "select count(*) from log where name like ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			if (rs.next()) {
				ret = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return ret;
	}

	@Override
	public List<Log> searchByDate(String name, Date d1, Date d2) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Log> list = new ArrayList<Log>();
		
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from log where name like ? and time between ? and ? order by id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			ps.setDate(2, new java.sql.Date(d1.getTime()));
			ps.setDate(3, new java.sql.Date(d2.getTime()));
			rs = ps.executeQuery();
			while (rs.next()) {
				Log log = new Log();
				
				log.setName(rs.getString(2));
				log.setOpera(rs.getString(3));
				log.setTime(rs.getTimestamp(4));

				list.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return list;
	}
}
