package com.andrewjamesjohnson.junit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JUnit test runner that supports parameterized test cases
 */
public class ParameterizedTestCaseRunner extends BlockJUnit4ClassRunner {
    public ParameterizedTestCaseRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected List<FrameworkMethod> getChildren() {
        List<FrameworkMethod> children = new ArrayList<>(super.getChildren());
        List<FrameworkMethod> parameterizedTestMethods = getTestClass().getAnnotatedMethods(ParameterizedTest.class);
        children.addAll(parameterizedTestMethods.stream().flatMap(method -> {
            ParameterGenerator<? extends Parameter> generator;
            try {
                generator = method.getAnnotation(ParameterizedTest.class).generator().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return generator.generate().stream().map(p -> new ParameterizedFrameworkMethod(method.getMethod(), p));
        }).collect(Collectors.toList()));
        return children;
    }

    @Override
    protected String testName(FrameworkMethod method) {
        if (method instanceof ParameterizedFrameworkMethod) {
            ParameterizedFrameworkMethod parameterizedMethod = (ParameterizedFrameworkMethod) method;
            return String.join(" - ", super.testName(method), parameterizedMethod.getParameter().description());
        } else {
            return super.testName(method);
        }
    }
}
