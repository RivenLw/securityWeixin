package com.Riven.ssm.service;

import java.util.List;

import com.Riven.ssm.po.SysoptRecord;

public interface SysoptRecordService {

	//新增系统操作记录
	public boolean insertSysoptRecord(SysoptRecord sysoptRecord) throws Exception;
	//删除系统操作记录
	public boolean deleteSysoptRecordById(Integer operation_id) throws Exception;
	//修改系统操作记录
	public boolean updateSysoptRecord(SysoptRecord sysoptRecord) throws Exception;
	//根据记录id查找操作记录
	public SysoptRecord findSysoptRecordById(Integer operation_id) throws Exception;
	//查询所有操作记录
	public List<SysoptRecord> findSysoptRecordList() throws Exception;
	
}
