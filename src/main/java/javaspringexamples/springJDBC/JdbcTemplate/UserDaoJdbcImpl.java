package javaspringexamples.springJDBC.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

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
		System.out.println("Invoiking public void insert(User user)");
	}

	public void update(User user) {
		System.out.println("Invoiking public void update(User user)");
	}

	public void delete(long userId) {
		System.out.println("Invoiking public void delete(long userId)");
	}
}
