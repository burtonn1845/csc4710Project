package user.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		userDao.add(form);
	}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new UserException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new UserException(" The password is not right");
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
	
	public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		userDao.initDao();
		for(int i = 1; i<11;i++) {
			String namedb = "john";
			String emaildb = "@dbexample.com";
			String pwdb = "pass1234";
			String titledb = "Paper";
			String affiliationdb = "Wayne State University";
			String datedb = "2018-6-10";
			String abstractdb = "Is pretty nice paper about photokinetic cat launchers.";
			
			namedb += Integer.toString(i);
			emaildb = namedb + emaildb;
			titledb += Integer.toString(i);
			
			
		userDao.populateDB(i,namedb,emaildb,pwdb,titledb,affiliationdb,datedb,abstractdb);
		}
	}
	
	public void assign(String papername, String rev1, String rev2, String rev3) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.assign(papername, rev1, rev2, rev3);
	}
}
