# junit-parameterized-test-case

`junit-parameterized-test-case` is a library for JUnit 4 that provides greater flexibility in writing parameterized tests.

Unlike the standard `org.junit.runners.Parameterized` test runner, which parameterizes the whole test class, `junit-parameterized-test-case` adds a `@ParameterizedTest` annotatation to support parameterizing specific test methods. This allows for different parameters to be used for different test cases within a single test class.

## Usage

Here is a complete example of a test using `junit-parameterized-test-case`:

```java
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
```

This test class will thus have three test cases: `basicTest`, `parameterizedTest - a,b`, and `parameterizedTest - c,d`.

The key pieces are as follows:

1. Annotate the class with `@RunWith(ParameterizedTestCaseRunner.class)`
2. Annotate test method to parameterize with `@ParameterizedTest`. This annotation takes a `generator` parameter, which is a class implementing the `ParameterGenerator` interface. This annotation also supports the `expected` and `timeout` arguments like the standard `@Test`.
3. All standard JUnit functionality (`@Before`/`@After`, `@BeforeClass`/`@AfterClass`, `@Rule`, etc.) are supported, as are regular test methods annotated with `@Test`. The behavior of these features is the same as in standard JUnit.

### Parameter Generation
Generators for parameters must implement the `ParameterGenerator` interface. This interface has one method, `generate`, which produces a `Collection` of objects that implement the `Parameter` interface.

A `Parameter` can be an arbitrary object, but it must implement the `description` method which is used to name the test cases. For convenience `Tuple1` through `Tuple26` classes are provided to use as tuple parameters.
