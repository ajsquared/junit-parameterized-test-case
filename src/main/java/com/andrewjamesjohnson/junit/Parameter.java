package com.andrewjamesjohnson.junit;

/**
 * Interface for parameters to parameterized test methods
 */
public interface Parameter {
    /**
     * Describes this parameter instance
     * This is used to name test cases
     *
     * @return A {@code String} describing this parameter
     */
    String description();
}
