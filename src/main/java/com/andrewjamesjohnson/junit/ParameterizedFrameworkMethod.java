package com.andrewjamesjohnson.junit;

import org.junit.runners.model.FrameworkMethod;

import java.lang.reflect.Method;
import java.util.Objects;

public class ParameterizedFrameworkMethod extends FrameworkMethod {
    private final Parameter parameter;

    ParameterizedFrameworkMethod(Method method, Parameter parameter) {
        super(method);
        this.parameter = parameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

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
