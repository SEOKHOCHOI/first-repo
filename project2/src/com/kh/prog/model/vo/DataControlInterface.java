package com.kh.prog.model.vo;

import java.util.List;

public interface DataControlInterface {
	public List<User> select();
	public List<User> select(String search);
	public Object selectOne(int id);
	public int insert(User user);
	public int update(User user);
	public int delete(User user);
	public int delete(int id);
}
