package com.Riven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.SysoptRecordMapper;
import com.Riven.ssm.po.SysoptRecord;
import com.Riven.ssm.service.SysoptRecordService;

public class SysoptRecordServiceImpl implements SysoptRecordService {

	@Autowired
	SysoptRecordMapper sysoptRecordMapper;
	
	@Override
	public boolean insertSysoptRecord(SysoptRecord sysoptRecord) throws Exception {
		// TODO Auto-generated method stub
		int result = sysoptRecordMapper.insertSelective(sysoptRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteSysoptRecordById(Integer operation_id) throws Exception {
		// TODO Auto-generated method stub
		int result = sysoptRecordMapper.deleteByPrimaryKey(operation_id);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateSysoptRecord(SysoptRecord sysoptRecord) throws Exception {
		// TODO Auto-generated method stub
		int result = sysoptRecordMapper.updateByPrimaryKeySelective(sysoptRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public SysoptRecord findSysoptRecordById(Integer operation_id) throws Exception {
		// TODO Auto-generated method stub
		return sysoptRecordMapper.selectByPrimaryKey(operation_id);
	}

	@Override
	public List<SysoptRecord> findSysoptRecordList() throws Exception {
		// TODO Auto-generated method stub
		return sysoptRecordMapper.selectByExample(null);
	}

}
