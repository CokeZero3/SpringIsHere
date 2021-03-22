package com.care.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements IService{
	@Autowired
	private IDao iDao;
	
	@Override
	public List<Board> selectBoard() {
		return iDao.selectBoard();
	}

}
