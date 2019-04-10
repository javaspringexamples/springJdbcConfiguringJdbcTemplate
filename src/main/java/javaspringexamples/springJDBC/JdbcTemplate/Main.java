package javaspringexamples.springJDBC.JdbcTemplate;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);

		UserDao userDao = applicationContext.getBean(UserDao.class);
		User user = new User();
		userDao.insert(user);
		userDao.update(user);
		userDao.delete(999);
	}
}
