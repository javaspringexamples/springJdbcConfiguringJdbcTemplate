package javaspringexamples.springJDBC.JdbcTemplate;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
@Data
public class User {
	private long id;
	private String name;
	private double userName;
	private Date accessTime;
	private boolean locked;
}
