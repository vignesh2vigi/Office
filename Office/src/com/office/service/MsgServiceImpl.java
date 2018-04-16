package com.office.service;

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

}
