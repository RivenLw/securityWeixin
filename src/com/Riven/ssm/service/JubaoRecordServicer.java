package com.Riven.ssm.service;

import java.util.List;

import com.Riven.ssm.po.JubaoRecord;

public interface JubaoRecordServicer {

	//新增举报记录
	public boolean insertJubaoRecord(JubaoRecord jubaoRecord) throws Exception;
	//查询所有举报记录
	public List<JubaoRecord> findJubaoRecordList() throws Exception;
	//根据记录id查询记录
	public JubaoRecord findJubaoRecoedById(Integer recordid) throws Exception;
	
}
