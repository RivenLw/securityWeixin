package com.Riven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.JubaoRecordMapper;
import com.Riven.ssm.po.JubaoRecord;
import com.Riven.ssm.service.JubaoRecordServicer;

public class JubaoRecordServiceImpl implements JubaoRecordServicer {

	@Autowired
	JubaoRecordMapper jubaoRecordMapper;
	
	@Override
	public boolean insertJubaoRecord(JubaoRecord jubaoRecord) throws Exception {
		// TODO Auto-generated method stub
		int result = jubaoRecordMapper.insertSelective(jubaoRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<JubaoRecord> findJubaoRecordList() throws Exception {
		// TODO Auto-generated method stub
		return jubaoRecordMapper.selectByExample(null);
	}

	@Override
	public JubaoRecord findJubaoRecoedById(Integer recordid) throws Exception {
		// TODO Auto-generated method stub
		
		return jubaoRecordMapper.selectByPrimaryKey(recordid);
	}

}
