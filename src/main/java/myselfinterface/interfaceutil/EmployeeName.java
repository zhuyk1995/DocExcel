package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ʱע��
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��8�� ����3:45:27
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeName {

	public String employeeName() default "";

	String value();
}
