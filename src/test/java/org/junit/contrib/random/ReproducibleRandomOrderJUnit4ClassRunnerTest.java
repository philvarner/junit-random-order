package org.junit.contrib.random;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

import java.util.List;

public class ReproducibleRandomOrderJUnit4ClassRunnerTest {

    @Test
    public void test_all_of_them() throws Exception {
        ReproducibleRandomOrderJUnit4ClassRunner runner = new ReproducibleRandomOrderJUnit4ClassRunner(ClassToTest.class);
        assertArrayEquals(runner.computeTestMethods(0).toArray(), runner.computeTestMethods(0).toArray());
        assertArrayEquals(runner.computeTestMethods(1).toArray(), runner.computeTestMethods(1).toArray());
        List<FrameworkMethod> list0 = runner.computeTestMethods(0);
        assertEquals(10, list0.size());
        List<FrameworkMethod> list1 = runner.computeTestMethods(1);
        assertEquals(10, list1.size());
        boolean diff = false;
        for (int i = 0; i < list0.size() && !diff; i++) {
            diff = list0.get(i).equals(list1.get(i));
        }
        assertTrue(diff);
    }

}
