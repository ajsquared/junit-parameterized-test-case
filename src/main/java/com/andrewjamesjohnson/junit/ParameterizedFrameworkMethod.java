package com.andrewjamesjohnson.junit;

import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Subclass of {@link FrameworkMethod} to support parameterizing test methods
 */
public class ParameterizedFrameworkMethod extends FrameworkMethod {
    private final Parameter parameter;

    ParameterizedFrameworkMethod(Method method, Parameter parameter) {
        super(method);
        this.parameter = parameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

    /**
     * Invokes this method reflectively, rethrowing exceptions wrapped in an {@link InvocationTargetException}
     * If no parameters are provided as an argument, the {@link Parameter} instance stored in this object will be used instead
     *
     * @param target The object on which to invoke this method
     * @param params The parameters to pass to the method
     * @return The result of invoking this method
     * @throws Throwable Any exception wrapped in an {@code InvocationTargetException}
     */
    @Override
    public Object invokeExplosively(Object target, Object... params) throws Throwable {
        if (parameter == null || params.length > 0) {
            return super.invokeExplosively(target, params);
        } else {
            return super.invokeExplosively(target, parameter);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParameterizedFrameworkMethod that = (ParameterizedFrameworkMethod) o;
        return Objects.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parameter);
    }
}
