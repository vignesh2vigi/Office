package com.office.dao;

import java.util.List;

import com.office.model.Msg;

public interface MsgDao {

	public Msg addmsg(Msg msg);
	
	public List<Msg> getmsg(Msg msg);
}
