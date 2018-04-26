package com.Riven.ssm.tuling;

import java.util.List;

public class RespMsgPo {

	private Intent intent;
	private List<Results> results;
	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	
}
