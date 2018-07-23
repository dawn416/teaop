package teaop.aop;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @since 2018年7月19日 下午8:50:29
 * @version 1.0.0
 * @author 黎明
 *
 */
public abstract class InvokeChain {
	private List<AbstractAspect> successors;

	public InvokeChain(List<AbstractAspect> successors) {
		this.successors = successors;
	}

	private int index = 0;

	public Object process(Method method) throws Throwable {
		if (index < successors.size()) {
			return successors.get(index++).process(this, method);
		} else {
			return indeedMethod();
		}

	}

	public abstract Object indeedMethod() throws Throwable;
}
