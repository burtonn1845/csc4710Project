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
	public List<Object> findSingleName(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findSingleName(name);
		
	}
	public List<Object> findFirstName(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findFirstName(name);
		
	}
	public List<Object> findTwoName(String name, String sname) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findTwoName(name, sname);
		
	}
	public List<Object> mostrev() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		return userDao.mostrev();
	}
	public List<Object> norev() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		return userDao.norev();
	}
	public List<Object> rejsearch(String name1, String name2) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		return userDao.rejsearch(name1, name2);
	}
	public List<Object> acceptview() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		return userDao.acceptview();
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
	public void updatepcm(String updateName, String newName, String newEmail) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.updatepcm(updateName, newName, newEmail);
	}
	public void deletepcm(String deleteName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.deletepcm(deleteName);
	}
	public void newpcm(String name, String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.newpcm(name, email);
	}
	public void updatepaper(String updateName, String newTitle, String newAbs, String newPdf) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.updatepaper(updateName, newTitle, newAbs, newPdf);
	}
	public void deletepaper(String deleteTitle) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.deletepaper(deleteTitle);
	}
	public void newpaper(String title, String abs, String pdf, String authors, String emails, String affil, String con, String authors2, String emails2, String affil2, String con2) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.newpaper(title, abs, pdf, authors, emails, affil, con, authors2, emails2, affil2, con2);
	}
	public void updaterev(String rid, String date, String comment, String rec) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.updaterev(rid, date, comment, rec);
	}
	public void deleterev(String rid) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.deleterev(rid);
	}
	public void newrev(String date, String comment, String rec, String paperid, String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		userDao.newrev(date, comment, rec, paperid, email);
	}
}
