package projectD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class ProjectDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String LOGIN_CHK = "select count(*) as cnt from prj_mem where name = ? and ssn = ?";
	private String MEM_JOIN = "insert into prj_mem values(0, ?, ?, ?)";
	private String COMMUNITY_LIST = "select * from community";
	private String COMMUNITY_INSERT = "insert into community(writer, title, content, regtime, hits) values(?, ?, ?, now(), 0)";
	private String COMMUNITY_ONE = "select * from community where num = ?";
	private String COMMUNITY_DELETE = "delete from community where num = ?";
	private String COMMUNITY_FIND = "select * from community where num = ?";
	private String COMMUNITY_UPDATE = "update community set writer = ?, title = ?, content = ?, regtime = now() where num = ?";
	
	//로그인 체크
	public boolean checkLogin(String name, String ssn) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(LOGIN_CHK);
			stmt.setString(1, name);
			stmt.setString(2, ssn);
			rs = stmt.executeQuery();
			rs.next();
			if(rs.getInt("cnt") == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return false;
	}
	
	//회원가입
	public boolean memberJoin(String name, String ssn, String phone) {
		conn = JDBCUtil.getConnection();
		boolean isSuccess = false;
		try {
			stmt = conn.prepareStatement(MEM_JOIN);
			stmt.setString(1, name);
			stmt.setString(2, ssn);
			stmt.setString(3, phone);
			int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            isSuccess = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }
	    return isSuccess;
	}
	
	//게시글 목록 확인
	public List<ProjectDTO> getCommunityList() {
		List<ProjectDTO> list = new ArrayList<>();
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ProjectDTO dto = new ProjectDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	//게시글 등록
	public void insertCommunity(ProjectDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_INSERT);
			stmt.setString(1, dto.getWriter());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public ProjectDTO getOne(int num) {
		ProjectDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_ONE);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			if(rs.next()) {
				dto = new ProjectDTO(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"), rs.getString("content"), 
						rs.getString("regtime"), rs.getInt("hits"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}
	
	public void deleteCommunity(int num) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_DELETE);
			stmt.setInt(1, num);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void findCommunity(int num) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_FIND);
			stmt.setInt(1, num);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void updateCommunity(ProjectDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(COMMUNITY_UPDATE);
			stmt.setString(1, dto.getWriter());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.setInt(4, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
