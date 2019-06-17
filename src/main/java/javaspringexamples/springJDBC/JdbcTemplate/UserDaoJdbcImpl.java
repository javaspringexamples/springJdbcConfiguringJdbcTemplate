package javaspringexamples.springJDBC.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserDaoJdbcImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(User user) {
		PreparedStatementCreatorFactory psCreatorFactory = new PreparedStatementCreatorFactory(
				"insert into user(name, user_name, locked) values(?,?,?)",
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.BOOLEAN });
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int count = jdbcTemplate.update(psCreatorFactory.newPreparedStatementCreator(
				new Object[] { user.getName(), user.getUserName(), user.isLocked() }), keyHolder);
		if (count != 1)
			throw new ExceptionInsertFailed("Cannot insert user");
		user.setId(keyHolder.getKey().longValue());
	}

	public void update(User user) {
		int count = jdbcTemplate.update("update user  set (name, user_name, locked) = (?,?,?) where id = ?",
				user.getName(), user.getUserName(), user.isLocked(), user.getId());
		if (count != 1)
			throw new ExceptionUpdateFailed("Cannot update user");
	}

	public void delete(long userId) {
		int count = jdbcTemplate.update("delete user where id = ?", userId);
		if (count != 1)
			throw new ExceptionDeleteFailed("Cannot delete user");
	}

	public User find(long userId) {
		try {
			return jdbcTemplate.queryForObject("select id, name, user_name, locked from user where id = ?",
					new RowMapper<User>() {
						public User mapRow(ResultSet rs, int rowNum) throws SQLException {
							User user = new User();
							user.setId(rs.getLong("id"));
							user.setName(rs.getString("name"));
							user.setUserName(rs.getString("user_name"));
							user.setLocked(rs.getBoolean("locked"));
							return user;
						}
					}, userId);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}