package com.andrewjamesjohnson.junit;

import com.andrewjamesjohnson.junit.tuple.Tuple2;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(ParameterizedTestCaseRunner.class)
public class ParameterizedTestCaseExampleTest {
    public static class ExampleParameterGenerator implements ParameterGenerator<Tuple2<String, String>> {

        @Override
        public Collection<Tuple2<String, String>> generate() {
            return Arrays.asList(
                    Tuple2.of("a", "b"),
                    Tuple2.of("c", "d")
            );
        }
    }

    @Test
    public void basicTest() {
        assertTrue(true);
    }

    @ParameterizedTest(generator = ExampleParameterGenerator.class)
    public void parameterizedTest(Tuple2<String, String> param) {
        assertTrue(param.description().startsWith(param._1));
    }
}