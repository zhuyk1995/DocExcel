package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ʱע��
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��8�� ����3:41:30
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Company {

	public int id() default -1;
	
	public String name() default "";
	
	public String address() default "";
}
