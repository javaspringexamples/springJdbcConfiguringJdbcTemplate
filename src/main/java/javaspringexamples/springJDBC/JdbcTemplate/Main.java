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
		user.setName("Waaaaw");
		user.setUserName("Wiiiiiw");
		user.setLocked(false);
		userDao.insert(user);

		user = userDao.find(user.getId());
		System.out.println(user.getName() + ", " + user.getUserName() + ", " + user.isLocked());

		user.setLocked(true);
		userDao.update(user);

		user = userDao.find(user.getId());
		System.out.println(user.getName() + ", " + user.getUserName() + ", " + user.isLocked());

		userDao.delete(user.getId());
		
		user = userDao.find(user.getId());
		System.out.println(user);
	}
}
