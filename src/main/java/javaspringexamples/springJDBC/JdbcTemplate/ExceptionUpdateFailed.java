package javaspringexamples.springJDBC.JdbcTemplate;

import org.springframework.dao.DataAccessException;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class ExceptionUpdateFailed extends DataAccessException {
	public ExceptionUpdateFailed(String msg) {
		super(msg);
	}
}
