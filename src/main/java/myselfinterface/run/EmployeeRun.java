package myselfinterface.run;

import java.util.Map;

import myselfinterface.entity.EmployeeInfo;
import myselfinterface.infoutil.EmployeeInfoUtil;

/**
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��8�� ����4:02:11
*/
public class EmployeeRun {

	public static void main(String[] args) {
		Map fruitInfo = EmployeeInfoUtil.getEmployeeInfo(EmployeeInfo.class);
		System.out.println(fruitInfo);
	}
}
