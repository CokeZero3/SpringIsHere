package com.care.membership;

import java.util.List;
import java.util.Map;

public interface IService {
	public String isExistId(Member member, Map<String, Object> sInfo);
	public void reqAuthNum(Map<String, Object> sInfo);

	public String authNumConfirm(Map<String, Object> sInfo, String reqAuthNum/* , SessionStatus session */);
	public List<Zipcode> searchZipcode(String addr);
	public boolean memberProc(Member member, Map<String, Object> sInfo);
	public String FindInfoProc(String email, String id);
	public boolean loginProc(Login login);
}
