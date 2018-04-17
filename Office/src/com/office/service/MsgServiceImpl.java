package com.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.office.dao.MsgDao;
import com.office.model.Msg;

public class MsgServiceImpl implements MsgService {

	@Autowired
	MsgDao msgDao;
	
	@Override
	public Msg addmsg(Msg msg) {
		// TODO Auto-generated method stub
		return msgDao.addmsg(msg);
	}

	@Override
	public List<Msg> getmsg(Msg msg) {
		// TODO Auto-generated method stub
		return msgDao.getmsg(msg);
	}

	

}
