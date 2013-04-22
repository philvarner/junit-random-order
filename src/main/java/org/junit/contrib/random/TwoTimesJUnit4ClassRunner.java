package org.junit.contrib.random;

import java.util.ArrayList;
import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class TwoTimesJUnit4ClassRunner extends ReproducibleRandomOrderJUnit4ClassRunner {

    public TwoTimesJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods(long seed) {
        List<FrameworkMethod> methods = super.computeTestMethods(seed);
        List<FrameworkMethod> twice = new ArrayList<FrameworkMethod>();
        for (FrameworkMethod method : methods) { twice.add(method); twice.add(method); }
        return twice;
    }

}