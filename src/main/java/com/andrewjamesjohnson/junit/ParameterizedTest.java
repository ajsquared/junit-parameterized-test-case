package com.andrewjamesjohnson.junit;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used in combination with {@link ParameterizedTestCaseRunner} to run parameterized test methods in JUnit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ParameterizedTest {

    /**
     * Optionally specify <code>expected</code>, a Throwable, to cause a test method to succeed if
     * and only if an exception of the specified class is thrown by the method. If the Throwable's
     * message or one of its properties should be verified, the
     * {@link org.junit.rules.ExpectedException ExpectedException} rule can be used instead.
     *
     * @return The class type of the expected exception
     */
    Class<? extends Throwable> expected() default Test.None.class;

    /**
     * Optionally specify <code>timeout</code> in milliseconds to cause a test method to fail if it
     * takes longer than that number of milliseconds.
     * <p>
     * <b>THREAD SAFETY WARNING:</b> Test methods with a timeout parameter are run in a thread other than the
     * thread which runs the fixture's @Before and @After methods. This may yield different behavior for
     * code that is not thread safe when compared to the same test method without a timeout parameter.
     * <b>Consider using the {@link org.junit.rules.Timeout} rule instead</b>, which ensures a test method is run on the
     * same thread as the fixture's @Before and @After methods.
     * </p>
     *
     * @return The timeout in milliseconds for this test csse
     */
    long timeout() default 0L;

    /**
     * Specify the {@link ParameterGenerator} class used to generate parameters for this test method
     *
     * @return The class type of the parameter generator
     */
    Class<? extends ParameterGenerator> generator();
}
