package chap08.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", 
				// 익명객체 생성으로 처리하는 방법
//			new RowMapper<Member>() {
//				@Override
//				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//					// TODO Auto-generated method stub
//					Member member = new Member(
//							rs.getString("EMAIL"),
//							rs.getString("PASSWORD"),
//							rs.getString("NAME"),
//							rs.getTimestamp("REGDATE").toLocalDateTime());
//					member.setId(rs.getLong("ID"));
//					return member;
//				}
//			}
				// 람다로 처리하는 방법
//			(ResultSet rs, int rowNum) -> {
//				Member member = new Member(
//						rs.getString("EMAIL"),
//						rs.getString("PASSWORD"),
//						rs.getString("NAME"),
//						rs.getTimestamp("REGDATE").toLocalDateTime());
//				member.setId(rs.getLong("ID"));
//				return member;
//			}
				// RowMapper<Member>를 구현하는 객체를 미리 만들어놓고 전달. 자주 사용할 경우 이 방법이 중복제거 측면에서 훨씬 좋다. 
			new MemberRowMapper()
		, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(Member member) {
	}
	
	public void update(Member member) {
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
		return results;
	}
	
//	public int count() {
//		List<Integer> results = jdbcTemplate.query("select count(*) from MEMBER",
//				new RowMapper<Integer>() {
//
//					@Override
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						return rs.getInt(1);
//					}
//			
//		}); 
//		return results.get(0);
//	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}
	
}
