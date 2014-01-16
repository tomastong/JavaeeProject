package cn.itjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itjava.dao.NewsDao;
import cn.itjava.domain.News;
import cn.itjava.util.JdbcTool;
import cn.itjava.util.PageModel;

public class NewsDaoImpl implements NewsDao {

	// 添加新闻
	@Override
	public boolean addNews(News news) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("insert into news(id, title, author, content) values(news_seq.nextval, ?, ?, ?)");
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getAuthor());
			ps.setString(3, news.getContent());
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

	// 删除指定新闻
	@Override
	public boolean deleteNews(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from news where id=?");
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

	// 批量删除新闻，指定id
	@Override
	public boolean deleteNews(int[] ids) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		int count = 0;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("delete from news where id=?");
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

	// 更新新闻
	@Override
	public boolean updateNews(News news, int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = JdbcTool.getConnection();
			ps = conn
					.prepareStatement("update news set title=?, content = ? where id=?");
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getContent());
			ps.setInt(3, id);
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

	// 查询指定新闻
	@Override
	public News queryNews(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		News news = null;
		try {
			conn = JdbcTool.getConnection();
			ps = conn.prepareStatement("select * from news where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				news = new News();

				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setAuthor(rs.getString(3));
				news.setContent(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return news;
	}

	// 返回分页模型
	@Override
	public PageModel pageQueryNews(String name, String str, int pageNo) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		PageModel pageModel = new PageModel();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from (select rownum num, a.* from news a where title like ? and author like ? and rownum <= "
					+ (pageNo * pageModel.getPageSize())
					+ " ) where num> "
					+ (pageNo - 1) * pageModel.getPageSize();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");
			ps.setString(2, "%" + name + "%");
			rs = ps.executeQuery();

			while (rs.next()) {

				News news = new News();

				news.setId(rs.getInt(2));
				news.setTitle(rs.getString(3));
				news.setAuthor(rs.getString(4));
				news.setContent(rs.getString(5));

				list.add(news);
			}
			pageModel.setList(list);
			pageModel.setPageNo(pageNo);
			pageModel.setTotalRecords(getNewsCount(str));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return pageModel;
	}

	// 返回新闻条数
	public int getNewsCount(String str) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = JdbcTool.getConnection();
			String sql = "select count(*) from news where title like ? ";
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

	// 返回所有新闻条数
	public List<News> getNewsList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<News> list = new ArrayList<News>();
		try {
			conn = JdbcTool.getConnection();
			String sql = "select * from news";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				News news = new News();
				
				news.setId(rs.getInt(1));
				news.setTitle(rs.getString(2));
				news.setAuthor(rs.getString(3));
				news.setContent(rs.getString(4));
				
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTool.free(rs, ps, conn);
		}
		return list;
	}
}
