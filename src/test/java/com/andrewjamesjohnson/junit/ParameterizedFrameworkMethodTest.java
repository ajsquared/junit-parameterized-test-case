package com.andrewjamesjohnson.junit;

import com.andrewjamesjohnson.junit.tuple.Tuple1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Method;

public class ParameterizedFrameworkMethodTest {
    private static Method method;

    @BeforeClass
    public static void setup() throws NoSuchMethodException {
        method = ParameterizedFrameworkMethodTest.class.getDeclaredMethod("exampleMethod", Tuple1.class);
        method.setAccessible(true);
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

    @Test
    public void testInvokeNoArgs() throws Throwable {
        String expected = "abc";
        ParameterizedFrameworkMethod parameterizedMethod = new ParameterizedFrameworkMethod(method, Tuple1.of(expected));
        String output = (String) parameterizedMethod.invokeExplosively(this);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testInvokeWithArgs() throws Throwable {
        String expected = "def";
        ParameterizedFrameworkMethod parameterizedMethod = new ParameterizedFrameworkMethod(method, Tuple1.of("abc"));
        String output = (String) parameterizedMethod.invokeExplosively(this, Tuple1.of(expected));
        Assert.assertEquals(expected, output);
    }
}