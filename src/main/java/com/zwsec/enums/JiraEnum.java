package com.zwsec.enums;
/**
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��7�� ����2:42:45
*/
public enum JiraEnum {

	ROW_INDEX("�к�",2);
	
	/** ����Ϣ*/
	private String jiraInfo;
	/** ����*/
	private Integer jiraNum;
	public String getJiraInfo() {
		return jiraInfo;
	}
	public void setJiraInfo(String jiraInfo) {
		this.jiraInfo = jiraInfo;
	}
	public Integer getJiraNum() {
		return jiraNum;
	}
	public void setJiraNum(Integer jiraNum) {
		this.jiraNum = jiraNum;
	}
	private JiraEnum(String jiraInfo, Integer jiraNum) {
		this.jiraInfo = jiraInfo;
		this.jiraNum = jiraNum;
	}
	
	
}
