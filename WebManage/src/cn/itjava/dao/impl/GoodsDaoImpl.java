package cn.itjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itjava.dao.GoodsDao;
import cn.itjava.domain.GCate;
import cn.itjava.domain.Goods;
import cn.itjava.util.JdbcTool;
import cn.itjava.util.PageModel;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public boolean addGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("insert into goods(gid, gname, gcateid, gdesc) values(goods_seq.nextval, ?, ?, ?)");
			ps.setString(1, goods.getName());
			ps.setInt(2, goods.getGcate().getId());
			ps.setString(3, goods.getDesc());
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
	public boolean deleteGoods(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from Goods where gid=?");
			ps.setInt(1, id);
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
	public boolean deleteGoods(int[] ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int count = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from Goods where gid=?");
			for (int i = 0; i < ids.length; i++) {
				ps.setInt(1, ids[i]);
				int ret = ps.executeUpdate();
				if (ret > 0) {
					count++;
				}
			}
			if (count == ids.length) {
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
	public boolean updateGoods(Goods goods, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("update goods set gname=?, gcateid=?, gdesc=? where gid=?");
			ps.setString(1, goods.getName());
			ps.setInt(2, goods.getGcate().getId());
			ps.setString(3, goods.getDesc());
			ps.setInt(4, id);
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
	public Goods queryGoods(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		Goods goods = null;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from goods, gcates where goods.gcateid = gcates.id and gid=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				goods = new Goods();

				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));

				GCate gcate = new GCate();
				gcate.setId(rs.getInt(3));

				goods.setDesc(rs.getString(4));
				gcate.setName(rs.getString(6));
				
				goods.setGcate(gcate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return goods;
	}

	@Override
	public PageModel pageQueryGoods(String str, int pageNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		PageModel pageModel = new PageModel();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from (select rownum num, goods.gid, goods.gname,goods.gcateid,goods.gdesc, gcates.name from goods, gcates where goods.gcateid = gcates.id and goods.gname like ? and rownum<="
					+ pageNo
					* pageModel.getPageSize()
					+ ") where num> "
					+ ((pageNo - 1) * pageModel.getPageSize());
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				Goods goods = new Goods();

				goods.setId(rs.getInt(2));
				goods.setName(rs.getString(3));

				GCate gcate = new GCate();
				gcate.setId(rs.getInt(4));

				goods.setDesc(rs.getString(5));
				gcate.setName(rs.getString(6));
				goods.setGcate(gcate);

				list.add(goods);
			}
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setTotalRecords(getGoodsCount(str));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return pageModel;
	}

	// 返回商品条数
	public int getGoodsCount(String str) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			// 我靠，搞了半天，居然是前面空格的问题，我去，看来字符串连接时，得好好注意下
			conn = JdbcTool.getConnection();
			String sql = "select goods.gid, goods.gname,goods.gcateid,goods.gdesc, gcates.name "
					+ " from goods, gcates"
					+ " where goods.gcateid = gcates.id and goods.gname like ?";
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
	public List<Goods> getGoodsList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Goods> list = new ArrayList<Goods>();
		PageModel pageModel = new PageModel();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select goods.gid, goods.gname,goods.gcateid,goods.gdesc, gcates.name from goods, gcates where goods.gcateid = gcates.id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				Goods goods = new Goods();

				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));

				GCate gcate = new GCate();
				gcate.setId(rs.getInt(3));

				goods.setDesc(rs.getString(4));
				gcate.setName(rs.getString(5));
				goods.setGcate(gcate);
				

				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return list;
	}
}
