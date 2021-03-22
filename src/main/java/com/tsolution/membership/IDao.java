package com.care.membership;

import java.util.List;
import java.util.Map;

public interface IDao {
	public int isExistId(String id);
	public List<Zipcode> searchZipcode(String addr);
	public void insertMember(Member memeber);
	public void insertMemberPostCode(Member memeber);
	public void insertMemberPostCode2(Member memeber);
	public String FindInfoProc(Map<String, String> map);
	public int loginProc(Login login);
}
