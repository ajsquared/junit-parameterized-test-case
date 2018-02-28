package com.andrewjamesjohnson.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(ParameterizedTestCaseRunner.class)
public class ParameterizedTestCaseExampleTest {
    public static class ExampleParameter implements Parameter {
        String a;
        String b;

        ExampleParameter(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String description() {
            return String.join(",", a, b);
        }
    }

    public static class ExampleParameterGenerator implements ParameterGenerator<ExampleParameter> {

        @Override
        public Collection<ExampleParameter> generate() {
            return Arrays.asList(
                    new ExampleParameter("a", "b"),
                    new ExampleParameter("c", "d")
            );
        }
    }

    @Test
    public void basicTest() {
        assertTrue(true);
    }

    @ParameterizedTest(generator = ExampleParameterGenerator.class)
    public void parameterizedTest(ExampleParameter param) {
        assertTrue(param.description().startsWith(param.a));
    }
}