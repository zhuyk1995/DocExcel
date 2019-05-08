package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ʱע��
 * @author ����: ZHUYAKANG
 * @createDate ����ʱ�䣺2019��5��8�� ����3:47:21
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeSex {

	// �����Ա�ö����
	enum Sex {
		Man, Woman
	}

	Sex employeeSex() default Sex.Man;
}
