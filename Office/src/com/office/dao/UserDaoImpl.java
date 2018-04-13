package com.office.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.office.model.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		User dealerRegLoginOutObj = new User();
		try {
			
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO register (name,password,mobile,email) VALUES (?,?,?,?)";

			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { 
							user.getName(),
							user.getPassword(),
							user.getMobile(),
							user.getEmail()
							
							
						
							});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj.setMessage("Register Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj.setMessage(" Register UnSuccessful...!");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			
		}

		return dealerRegLoginOutObj;
	}

	@Override
	public User login(User user) {

		User bank = new User();
		List<User> bankModelObjArray = new ArrayList<User>(); 
		
		String query = "SELECT name,password FROM register WHERE name='"+user.getName()+"' AND password='"+user.getPassword()+"' "; 
		System.out.println("query"+query);
		System.out.println(""+query);
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(User.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
		
			
			bank.setName(bankModelObjArray.get(0).getName());
			bank.setPassword(bankModelObjArray.get(0).getPassword());
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				}
		return bank;
	}

	@Override
	public boolean valid(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("adminId======================"+name);
				User bank = new User();
				List<User> bankModelObjArray = new ArrayList<User>(); 
				String query = "SELECT name FROM register WHERE name='"+name+"'"; 
				System.out.println("admin id check==============="+query);
			                                        
				bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(User.class)); 
				if (bankModelObjArray.size() > 0) {
					bank.setStatus(true);
				bank.setName(bankModelObjArray.get(0).getName());
				return true;
				
					} else { 
						/*System.out.println("pass");*/
						bank.setStatus(false);
						return false;
						}		
	}

	@Override
	public boolean validpass(String password) {
		// TODO Auto-generated method stub
		System.out.println("adminId======================"+password);
		User bank = new User();
		List<User> bankModelObjArray = new ArrayList<User>(); 
		String query = "SELECT password FROM register WHERE password='"+password+"'"; 
		System.out.println("admin id check==============="+query);
	                                        
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(User.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
		bank.setPassword(bankModelObjArray.get(0).getPassword());
		return true;
		
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				return false;
				}	
	}

	@Override
	public User uploadProfilePic(User profilePicture) {
		// TODO Auto-generated method stub
		User dealerRegLoginOutObj = new User();
		try {
	
			int insertDealerReg_int = 0;
			System.out.println("pic=====>"+profilePicture.getImage());
			System.out.println("pic=====>"+profilePicture.getName());
			String insertDealerReg_query ="UPDATE register SET image=? WHERE name=?";
System.out.println("reject Update query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] {profilePicture.getImage(), profilePicture.getName()});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("update...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("not...!");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}
		return dealerRegLoginOutObj;
	}

	@Override
	public User getProfilePic(String name) {
		// TODO Auto-generated method stub
		User bank = new User();
		List<User> bankModelObjArray = new ArrayList<User>(); 
		
		String query = "SELECT image from register WHERE name='"+name+"'"; 
		System.out.println("query"+query);
		System.out.println(""+query);
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(User.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
			bank.setImage(bankModelObjArray.get(0).getImage());
			
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				}
		return bank;
	}

	
}
