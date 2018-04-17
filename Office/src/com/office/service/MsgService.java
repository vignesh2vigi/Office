package com.office.service;

import java.util.List;

import com.office.model.Msg;

public interface MsgService {

	public Msg addmsg(Msg msg);
	public List<Msg> getmsg(Msg msg);
}
