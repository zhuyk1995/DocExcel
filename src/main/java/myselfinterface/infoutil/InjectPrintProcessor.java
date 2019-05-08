package myselfinterface.infoutil;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import myselfinterface.interfaceutil.InjectPrint;

/**
 * ����ʱע�⹤��
 * @author ����: ZHUYAKANG
 * @createDate ����ʱ�䣺2019��5��8�� ����4:14:46
 */
@SupportedAnnotationTypes("myselfinterface.interfaceutil.InjectPrint")
public class InjectPrintProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

		// ��ȡInjectPrint����ע�⣬Ȼ�����
		for(Element element : roundEnvironment.getElementsAnnotatedWith(InjectPrint.class)) {
			if(element.getKind() == ElementKind.METHOD) {
				// ǿת�ɷ�����Ӧ��element��ͬ��������ע����һ���࣬�������ǿת��TypeElement
				ExecutableElement executableElement = (ExecutableElement) element;
				// ��ӡ������
				System.out.println(executableElement.getSimpleName());
				// ��ӡ����ֵ����
				System.out.println(executableElement.getReturnType().toString());
				// ��ȡ�������в���
				List<? extends VariableElement> params = executableElement.getParameters();
				// ������ӡ������
				for(VariableElement variableElement : params) {
					System.out.println(variableElement.getSimpleName());
				}
				// ��ӡע���ֵ
				System.out.println("AnnotationValue:" + executableElement.getAnnotation(InjectPrint.class).value());
			}
		}
		return false;
	}
}
