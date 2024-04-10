package com.automation.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * This class implements the TestNG IAnnotationTransformer interface to customize test annotations during runtime.
 * <p>
 * Purpose of AnnotationTransformer:
 * - TestNG provides the IAnnotationTransformer interface to dynamically modify test annotations.
 * - The AnnotationTransformer class is responsible for transforming annotations for test methods.
 * <p>
 * How AnnotationTransformer Works:
 * - This class implements the transform method, which allows modifying test annotations.
 * - In this implementation, the transform method sets a custom retry analyzer (RetryAnalyzer) for test methods.
 * - By setting the retry analyzer, the class enables TestNG to retry failed test methods according to the retry logic defined in RetryAnalyzer.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * This method is called by TestNG to transform test method annotations.
     *
     * @param annotation      The annotation to be transformed.
     * @param testClass       The class where the test method is defined.
     * @param testConstructor The constructor of the test class.
     * @param testMethod      The test method to which the annotation belongs.
     */
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Set the retry analyzer for test methods to RetryAnalyzer.class,
        // which determines whether a failed test should be retried or not.
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

}
