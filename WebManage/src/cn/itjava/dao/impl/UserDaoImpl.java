package cn.itjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itjava.dao.UserDao;
import cn.itjava.domain.User;
import cn.itjava.util.JdbcTool;
import cn.itjava.util.PageModel;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean queryInfo(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean flag = user.isFlag();
		boolean flag_rs = false;
		String sql = "";
		try {
			conn = JdbcTool.getConnection();
			if (flag) {
				sql = "select count(*) from admins where name=? and password=?";
			} else {
				sql = "select count(*) from users where name=? and password=?";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					flag_rs = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}

		return flag_rs;
	}

	@Override
	// 这里直接在service层进行判断，如果是管理员，直接跳过该函数的调用
	public boolean updatePassword(User user, String newpwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean flag_rs = false;
		int ret = 0; // 这里是定义修改对数据表影响的行数
		String sql = "";

		try {
			conn = JdbcTool.getConnection();
			sql = "update users set password=? where password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, user.getPassword());
			ret = ps.executeUpdate();
			if (ret > 0) {
				flag_rs = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return flag_rs;
	}

	@Override
	public boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("insert into users(id, name, password) values(users_seq.nextval, ?, ?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ret = ps.executeUpdate();
			if (ret > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public boolean delUser(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from users where id=?");
			ps.setInt(1, id);
			ret = ps.executeUpdate();
			if (ret > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public boolean updUser(User user, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("update users set name=?, password=? where id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, id);
			ret = ps.executeUpdate();
			if (ret > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public User queUser(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();

				user.setId(rs.getInt(1));
				user.setFlag(false);
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return user;
	}

	@Override
	public PageModel pageQueryUsers(int pageNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		PageModel pageModel = new PageModel();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from (select rownum num, a.* from users a where rownum<= "
					+ pageNo * pageModel.getPageSize() + ") where num>"
					+ (pageNo-1) * pageModel.getPageSize();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				User user = new User();

				user.setId(rs.getInt(2));
				user.setName(rs.getString(3));
				user.setPassword(rs.getString(4));

				list.add(user);
			}
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setTotalRecords(getUsersCount());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return pageModel;
	}

	// 返回新闻条数
	public int getUsersCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			String sql = "select count(*) from users";
			ps = conn.prepareStatement(sql);
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
}
