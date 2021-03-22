package com.care.membership;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import com.jin.mail.SHA;

@Service
public class ServiceImpl implements IService {
	private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	
	@Autowired
	private IDao iDao;
	final String NOEXISTID = "사용 가능한 아이디 입니다.";
	final String EXISTID = "중복된 아이디 입니다.";
	
	final String AUTHCONFIRMOK = "인증 성공.";
	final String REAUTHCONFIRMOK = "이미 "+AUTHCONFIRMOK;
	final String AUTHCONFIRMFAILD = "인증 실패.";
	final String NOAUTHNUMBER = "인증 번호 없음.";
	
	@Override
	public String isExistId(Member member, Map<String, Object> sInfo) {
		String id = (String)sInfo.get("checkedID");
		
		if(id!=null && id.contentEquals(member.getId())) {
			logger.warn("session");
			return NOEXISTID;
		}
		
		if(iDao.isExistId(member.getId())==0) {
			sInfo.put("checkedID", member.getId());
			logger.warn("db");
			return NOEXISTID;
		}
		return EXISTID;
	}
	@Override
	public void reqAuthNum(Map<String, Object> sInfo) {
		String authNum = String.format("%04d", (int)(Math.random()*10000));
		sInfo.put("authNum", authNum);
		/* return authNum; */
	}
	@Override
	public String authNumConfirm(Map<String, Object> sInfo, String reqAuthNum/* , SessionStatus session */) {
		String authNum = (String)sInfo.get("authNum");
		Boolean authOK = (Boolean)sInfo.get("authOK");
		
		if(authOK!=null && authOK==true)return REAUTHCONFIRMOK;
		if(authNum==null) return NOAUTHNUMBER;
		
		if(reqAuthNum.contentEquals(authNum)) {
			sInfo.remove("authNum");
			sInfo.put("authOK", true);
			return AUTHCONFIRMOK;
		}
		return AUTHCONFIRMFAILD;
	}
	@Override
	public List<Zipcode> searchZipcode(String addr) {
		return iDao.searchZipcode(addr);
	}
	@Override
	public boolean memberProc(Member member, Map<String, Object> sInfo) {
		String sId = (String)sInfo.get("checkedID");
		logger.warn("sId : "+sId);
		logger.warn("member.getZipcode() : "+member.getZipcode());
		
		if(member.getId().contentEquals(sId) && (Boolean)sInfo.get("authOK")) {
			iDao.insertMember(member);
			if(!"".contentEquals(member.getZipcode()))
				iDao.insertMemberPostCode2(member);
			
			sInfo.remove("authOK");
			return true;
		}
		return false;
	}
	@Override
	public String FindInfoProc(String email, String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("email", email);
		
		String retId = iDao.FindInfoProc(map);
		String pass = "P@ssW0rd";
		SHA sha = new SHA();
		sha.encryptSHA512(pass);
		/*
		 * ID가 존재하는 경우 이메일로 패스워드 전송
		 * 별도로 member table에 패스워드 업데이트
		 */
		if(retId==null)	return "ID가 존재하지 않습니다.";
		return "이메일에 정보를 전송하였습니다.";
	}
	@Override
	public boolean loginProc(Login login) {
		if(iDao.loginProc(login)==0)
			return false;
		return true;
	}
}












