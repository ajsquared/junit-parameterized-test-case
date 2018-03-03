package com.andrewjamesjohnson.junit;

import com.andrewjamesjohnson.junit.tuple.Tuple1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ParameterizedTestCaseRunnerTest {
    public static class ExampleGenerator implements ParameterGenerator<Tuple1<String>> {

        @Override
        public Collection<Tuple1<String>> generate() {
            return Arrays.asList(
                    Tuple1.of("abc"),
                    Tuple1.of("def")
            );
        }
    }

    private static Method method;
    private static ParameterizedTestCaseRunner runner;

    @BeforeClass
    public static void setup() throws NoSuchMethodException, InitializationError {
        method = ParameterizedTestCaseRunnerTest.class.getDeclaredMethod("exampleMethod", Tuple1.class);
        method.setAccessible(true);

        runner = new ParameterizedTestCaseRunner(ParameterizedTestCaseRunnerTest.class);
    }

    /**
     * Example method to invoke reflectively
     *
     * @param input Input tuple parameter
     * @return The contents of the tuple
     */
    private String exampleMethod(Tuple1<String> input) {
        return input._1;
    }

    @ParameterizedTest(generator = ExampleGenerator.class)
    private void exampleParameterizedTest(Tuple1<String> input) {
    }

    @Test
    public void testTestName() {
        FrameworkMethod frameworkMethod = new FrameworkMethod(method);
        Assert.assertEquals("exampleMethod", runner.testName(frameworkMethod));

        ParameterizedFrameworkMethod parameterizedFrameworkMethod = new ParameterizedFrameworkMethod(method, Tuple1.of("abc"));
        Assert.assertEquals("exampleMethod - abc", runner.testName(parameterizedFrameworkMethod));
    }

    @Test
    public void testGetChildren() {
        List<FrameworkMethod> children = runner.getChildren();

        Assert.assertEquals(4, children.size());
        Set<String> expectedNames = new HashSet<>(Arrays.asList("testTestName", "testGetChildren", "exampleParameterizedTest - abc", "exampleParameterizedTest - def"));
        Set<String> actualNames = children.stream().map(m -> runner.testName(m)).collect(Collectors.toSet());
        Assert.assertEquals(expectedNames, actualNames);
    }
}