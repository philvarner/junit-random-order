package org.junit.contrib.random;

import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoTimesJUnit4ClassRunnerTest {

    @Test
    public void test_twice() throws Exception {
        TwoTimesJUnit4ClassRunner runner = new TwoTimesJUnit4ClassRunner(ClassToTest.class);
        List<FrameworkMethod> list0 = runner.computeTestMethods(0);
        assertEquals(20, list0.size());
        for (int i = 0; i < list0.size()-1; i = i + 2) {
            assertEquals(list0.get(i).getName(), list0.get(i+1).getName());
        }
    }
}
