package myselfinterface.infoutil;
/**
 * ����ʱע��
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��8�� ����3:51:12
*/

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import myselfinterface.interfaceutil.Company;
import myselfinterface.interfaceutil.EmployeeName;
import myselfinterface.interfaceutil.EmployeeSex;

public class EmployeeInfoUtil {

	public static Map getEmployeeInfo(Class<?> clazz) {
		HashMap<String, String> info = new HashMap<String, String>();
		Field[] fields = clazz.getDeclaredFields();// ��ȡ���Ա����
		for (Field field : fields) {
			if (field.isAnnotationPresent(EmployeeName.class)) {// �ж��ǲ���EmployeeName����ע��
				EmployeeName employeeName = field.getAnnotation(EmployeeName.class);
				info.put("employeeName", employeeName.value());// ��ȡע���ֵ
			}
			if (field.isAnnotationPresent(EmployeeSex.class)) {
				EmployeeSex employeeSex = field.getAnnotation(EmployeeSex.class);
				info.put("employeeSex", employeeSex.employeeSex().toString());
			}
			if (field.isAnnotationPresent(Company.class)) {
				Company company = field.getAnnotation(Company.class);
				info.put("company", company.id() + ":" + company.name() + ":" + company.address());
			}
		}
		return info;
	}
}
