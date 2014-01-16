package cn.itjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itjava.dao.GCateDao;
import cn.itjava.domain.GCate;
import cn.itjava.domain.News;
import cn.itjava.util.JdbcTool;
import cn.itjava.util.PageModel;

public class GCateDaoImpl implements GCateDao {

	@Override
	public boolean addGCate(GCate gcate) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("insert into gcates(id, name) values(gcates_seq.nextval, ?)");
			ps.setString(1, gcate.getName());
			int ret = ps.executeUpdate();
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

	/**
	 * 功能：删除商品类别 参数：类别的标识id 返回值：-1 表明类别下存在商品 1 删除成功 0 删除失败
	 */
	@Override
	public int deleteGCate(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int x = 0;
		if (hasGoods(id)) {
			return -1;
		}
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from gcates where id=?");
			ps.setInt(1, id);
			int ret = ps.executeUpdate();
			if (ret > 0) {
				x = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return x;
	}

	/**
	 * 功能：批量删除商品类别 参数：所有类别的标识数组 返回值：-1 表明类别下存在商品 1 删除成功 0 删除失败
	 */
	@Override
	public int deleteGCate(int[] ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		int x = 0; // 累计判断每个商品类别下是否全部清空，否则不许删除商品类别
		for (int i = 0; i < ids.length; i++) {
			if (hasGoods(ids[i])) {
				x++;
			}
		}
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from gcates where id=?");
			if (x > 0) {
				return -1;
			}
			// 程序进行到这里，说明x还是0
			for (int i = 0; i < ids.length; i++) {
				ps.setInt(1, ids[i]);
				int ret = ps.executeUpdate();
				if (ret > 0) {
					count++;
				}
			}
			if (count == ids.length) {
				x = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return x;
	}

	// 这里是查看商品下的东西
	public boolean hasGoods(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int count = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("select count(*) from goods, gcates where goods.gcateid=gcates.id and gcates.id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public boolean updateGCate(GCate gcate, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("update gcates set name=? where id=?");
			ps.setString(1, gcate.getName());
			ps.setInt(2, id);
			int ret = ps.executeUpdate();
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
	public GCate queryGCate(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		GCate gcate = null;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from gcates where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				gcate = new GCate();

				gcate.setId(rs.getInt(1));
				gcate.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return gcate;
	}

	@Override
	public PageModel pageQueryGCate(String str, int pageNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GCate> list = new ArrayList<GCate>();
		PageModel pageModel = new PageModel();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from ( select rownum num,a.* from gcates a where name like ? and rownum<="
					+ pageNo
					* pageModel.getPageSize()
					+ ") where num>"
					+ (pageNo - 1) * pageModel.getPageSize();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				GCate gcate = new GCate();

				gcate.setId(rs.getInt(2));
				gcate.setName(rs.getString(3));

				list.add(gcate);
			}
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setTotalRecords(getGCatesCount(str));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return pageModel;
	}

	// 返回新闻条数
	public int getGCatesCount(String str) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			String sql = "select count(*) from gcates where name like ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");
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
	public List<GCate> queryList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GCate> list = new ArrayList<GCate>();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from gcates";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				GCate gcate = new GCate();

				gcate.setId(rs.getInt(1));
				gcate.setName(rs.getString(2));

				list.add(gcate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return list;
	}
}
