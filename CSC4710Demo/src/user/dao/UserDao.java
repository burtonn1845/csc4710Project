package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class UserDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/sampledb?"
				              + "user=root&password=root");
		    String sql = "select * from tb_user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/sampledb?"
				              + "user=root&password=root");
			
			
			String sql = "insert into tb_user values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/sampledb?"
				              + "user=root&password=root");
			
			
			String sql = "select * from tb_user";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public void initDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?"
	              + "user=root&password=root");
		
	
		
		//String stmt = "insert into tb_user values ('name2','pass','email@mail.com')";
		String paper = "create table if not exists paper(paperid integer not null auto_increment, "
				+ "title varchar(50), "
				+ "abstract varchar(250), "
				+ "pdf varchar(100),"
				+ "primary key (paperid))";
		PreparedStatement paperstmt = connect.prepareStatement(paper);
		paperstmt.executeUpdate();
		
		String author = "create table if not exists author(email varchar(50), "
				+ "name varchar(50), "
				+ "affiliation varchar(100), "
				+ "primary key (email))";
		PreparedStatement authorstmt = connect.prepareStatement(author);
		authorstmt.executeUpdate();
		
		String write = "create table if not exists written(paperid integer,"
				+ "email varchar(50), "
				+ "contribution integer, "
				+ "primary key (paperid, email), "
				+ "foreign key (paperid) references paper(paperid), "
				+ "foreign key (email) references author(email))";
		PreparedStatement writestmt = connect.prepareStatement(write);
		writestmt.executeUpdate();
		
		String pc = "create table if not exists pcmember(email varchar(50), "
				+ "name varchar(50), "
				+ "primary key (email, name))";
		PreparedStatement pcstmt = connect.prepareStatement(pc);
		pcstmt.executeUpdate();
		
		String review = "create table if not exists review(reportid integer not null auto_increment, "
				+ "sdate date, "
				+ "comment varchar(250), "
				+ "recommendation char(1), "
				+ "paperid integer, "
				+ "email varchar(50), "
				+ "primary key (reportid), "
				+ "foreign key (paperid) references paper(paperid), "
				+ "foreign key (email) references author(email))";
		PreparedStatement reviewstmt = connect.prepareStatement(review);
		reviewstmt.executeUpdate();
		
		String reg = "create table if not exists tb_user(username varchar(50), "
				+ "`password` varchar(50) not null, "
				+ "email varchar(50) not null, "
				+ "primary key(email), "
				+ "foreign key (email, username) references pcmember(email, name))";
		PreparedStatement regstmt = connect.prepareStatement(reg);
		regstmt.executeUpdate();
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void populateDB(int id, String namedb, String emaildb, String pwdb, String titledb, String affiliationdb, String datedb, String abstractdb) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?"
		              + "user=root&password=root");
			
			String paper = "insert ignore into paper values(?,?,?,?)";
			PreparedStatement paperstmt = connect.prepareStatement(paper);
			paperstmt.setInt(1,  id);
			paperstmt.setString(2, titledb);
			paperstmt.setString(3, abstractdb);
			paperstmt.setString(4, "pdflinkhere");
			paperstmt.executeUpdate();
			
			String author = "insert ignore into author values(?,?,?)";
			PreparedStatement authorstmt = connect.prepareStatement(author);
			authorstmt.setString(1, emaildb);
			authorstmt.setString(2, namedb);
			authorstmt.setString(3, affiliationdb);
			authorstmt.executeUpdate();
			
			String write = "insert ignore into written values(?,?,?)";
			PreparedStatement writestmt = connect.prepareStatement(write);
			writestmt.setInt(1, id);
			writestmt.setString(2, emaildb);
			writestmt.setInt(3, id);
			writestmt.executeUpdate();
			
			String pc = "insert ignore into pcmember values(?,?)";
			PreparedStatement pcstmt = connect.prepareStatement(pc);
			pcstmt.setString(1, emaildb);
			pcstmt.setString(2, namedb);
			pcstmt.executeUpdate();
			
			String review = "insert ignore into review values(?,?,?,?,?,?)";
			PreparedStatement reviewstmt = connect.prepareStatement(review);
			reviewstmt.setInt(1, id);
			reviewstmt.setDate(2, java.sql.Date.valueOf(datedb));
			reviewstmt.setString(3, abstractdb);
			reviewstmt.setString(4, "Y");
			reviewstmt.setInt(5, id);
			reviewstmt.setString(6, emaildb);
			reviewstmt.executeUpdate();
			
			String reg = "insert ignore into tb_user values(?,?,?)";
			PreparedStatement regstmt = connect.prepareStatement(reg);
			regstmt.setString(1, namedb);
			regstmt.setString(2, pwdb);
			regstmt.setString(3, emaildb);
			regstmt.executeUpdate();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void assign(String papername, String rev1, String rev2, String rev3) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?"
		              + "user=root&password=root");
			
			int pID = 0;
			String r1 = null, r2 = null, r3 = null;
			
		    String findpID = "select paperid from paper where title=?";
		    PreparedStatement findpIDstmt = connect.prepareStatement(findpID); 
		    findpIDstmt.setString(1,papername);
		    ResultSet pidresult = findpIDstmt.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(pidresult.next()){
		    	pID = pidresult.getInt("paperid");	
		    	}
		    		
		    String findrev1 = "select email from pcmember where name=?";
		    PreparedStatement findrev1stmt = connect.prepareStatement(findrev1);
		    findrev1stmt.setString(1, rev1);
		    ResultSet rev1result = findrev1stmt.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(rev1result.next()){
		    	r1 = rev1result.getString("email");
		    	}
		
		    String findrev2 = "select email from pcmember where name=?";
		    PreparedStatement findrev2stmt = connect.prepareStatement(findrev2);
		    findrev2stmt.setString(1, rev2);
		    ResultSet rev2result = findrev2stmt.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(rev2result.next()){
		    	r2 = rev2result.getString("email");
		    	}
		    
		    String findrev3 = "select email from pcmember where name=?";
		    PreparedStatement findrev3stmt = connect.prepareStatement(findrev3);
		    findrev3stmt.setString(1, rev3);
		    ResultSet rev3result = findrev3stmt.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(rev3result.next()){
		    	r3 = rev3result.getString("email");
		    	}
		    
			String review1 = "insert ignore into review (sdate,comment,recommendation,paperid,email) values(?,?,?,?,?)";
			PreparedStatement reviewstmt1 = connect.prepareStatement(review1);
			reviewstmt1.setDate(1, java.sql.Date.valueOf("2018-6-10"));
			reviewstmt1.setString(2, "9/10 paper would recommend.");
			reviewstmt1.setString(3, "Y");
			reviewstmt1.setInt(4, pID);
			reviewstmt1.setString(5, r1);
			reviewstmt1.executeUpdate();
			
			String review2 = "insert ignore into review (sdate,comment,recommendation,paperid,email) values(?,?,?,?,?)";
			PreparedStatement reviewstmt2 = connect.prepareStatement(review2);
			reviewstmt2.setDate(1, java.sql.Date.valueOf("2018-6-10"));
			reviewstmt2.setString(2, "9/10 paper would recommend.");
			reviewstmt2.setString(3, "Y");
			reviewstmt2.setInt(4, pID);
			reviewstmt2.setString(5, r2);
			reviewstmt2.executeUpdate();
			
			String review3 = "insert ignore into review (sdate,comment,recommendation,paperid,email) values(?,?,?,?,?)";
			PreparedStatement reviewstmt3 = connect.prepareStatement(review3);
			reviewstmt3.setDate(1, java.sql.Date.valueOf("2018-6-10"));
			reviewstmt3.setString(2, "9/10 paper would recommend.");
			reviewstmt3.setString(3, "Y");
			reviewstmt3.setInt(4, pID);
			reviewstmt3.setString(5, r3);
			reviewstmt3.executeUpdate();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
			
		
	}
}
