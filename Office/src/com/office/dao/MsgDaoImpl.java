package com.office.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.office.model.Blog;
import com.office.model.Msg;

public class MsgDaoImpl implements MsgDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public Msg addmsg(Msg msg) {
		// TODO Auto-generated method stub
		Msg dealerRegLoginOutObj = new Msg();
		try {
			
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO message (user_from,user_to,msg,user_to_name) VALUES (?,?,?,?)";
System.out.println(""+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { 
							msg.getFrom(),
							msg.getSno(),
							msg.getMsg(),
							msg.getName()
							});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				
			} else {
				dealerRegLoginOutObj.setStatus(false);
				
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			
		}

		return dealerRegLoginOutObj;
	}

	@Override
	public List<Msg> getmsg(Msg msg) {
		// TODO Auto-generated method stub
		
		Msg custVehiDetailsOutObj = new Msg();
        List<Msg> custDetailsList = new ArrayList<Msg>();
		String pendingQuery = "SELECT * FROM message WHERE user_to_name='"+msg.getFrom()+"' ORDER BY date DESC";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(Msg.class));
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			
		}
		return custDetailsList;
	}
	

	
	

}
