package org.junit.contrib.random;

import java.util.ArrayList;
import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public abstract class PermutationJUnit4ClassRunner extends ReproducibleRandomOrderJUnit4ClassRunner {

    public PermutationJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods(long seed) {
        List<FrameworkMethod> methods = new ArrayList<FrameworkMethod>();
        for (int i = 0; i < getNumOfPermutations(); i++) {
            methods.addAll(super.computeTestMethods(seed+i));
        }
        return methods;
    }

    // this isn't a great way to do this, but there are initialization issues when storing and setting it
    // during instance initialization
    protected abstract int getNumOfPermutations();

    public static class Twice extends PermutationJUnit4ClassRunner {
        public Twice(Class<?> klass) throws InitializationError {
            super(klass);
        }

        @Override protected int getNumOfPermutations() { return 2; }

    }

    public static class Thrice extends PermutationJUnit4ClassRunner {
        public Thrice(Class<?> klass) throws InitializationError {
            super(klass);
        }
        @Override protected int getNumOfPermutations() { return 3; }
    }

    public static class Ten extends PermutationJUnit4ClassRunner {
        public Ten(Class<?> klass) throws InitializationError {
            super(klass);
        }
        @Override protected int getNumOfPermutations() { return 10; }
    }
}
