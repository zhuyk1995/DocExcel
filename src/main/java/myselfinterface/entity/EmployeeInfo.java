package myselfinterface.entity;

import myselfinterface.interfaceutil.Company;
import myselfinterface.interfaceutil.EmployeeName;
import myselfinterface.interfaceutil.EmployeeSex;
import myselfinterface.interfaceutil.EmployeeSex.Sex;

/**
 * ����ʱע��
 * @author ����: ZHUYAKANG
 * @createDate ����ʱ�䣺2019��5��8�� ����3:59:05
 */
public class EmployeeInfo {

	@EmployeeName("leiq")
	private String employeeName;
	@EmployeeSex(employeeSex = Sex.Man)
	private String employeeSex;
	@Company(id = 1, name = "�ϱ�����", address = "����·����")
	private String company;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	
}
