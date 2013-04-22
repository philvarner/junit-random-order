package org.junit.contrib.random;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class ReproducibleRandomOrderJUnit4ClassRunner extends BlockJUnit4ClassRunner {

    public static final long staticOrderSeed = Long.valueOf(System.getProperty("junit.order.seed", "" + System.currentTimeMillis()));

    static {
        System.out.println("ReproducibleRandomOrderJUnit4ClassRunner using using seed -Djunit.order.seed=" +  staticOrderSeed);
    }

    public ReproducibleRandomOrderJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        return computeTestMethods(staticOrderSeed);
    }

    protected List<FrameworkMethod> computeTestMethods(long seed) {
        List<FrameworkMethod> methods = getTestClass().getAnnotatedMethods(Test.class);
        Collections.sort(methods, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Collections.shuffle(methods, new Random(seed));
        return methods;
    }

}