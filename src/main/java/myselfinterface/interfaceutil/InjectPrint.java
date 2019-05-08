package myselfinterface.interfaceutil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����ʱע��
* @author ����: ZHUYAKANG
* @createDate ����ʱ�䣺2019��5��8�� ����4:12:21
*/
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface InjectPrint {

	String value();
}
