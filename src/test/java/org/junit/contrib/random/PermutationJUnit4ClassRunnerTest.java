package org.junit.contrib.random;

import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class PermutationJUnit4ClassRunnerTest {

    @Test
    public void test_two_permutations() throws Exception {
        PermutationJUnit4ClassRunner.Twice runner = new PermutationJUnit4ClassRunner.Twice(ClassToTest.class);
        List<FrameworkMethod> list0 = runner.computeTestMethods(0);
        assertEquals(20, list0.size());
        Collections.sort(list0, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = 0; i < list0.size()-1; i = i + 2) {
            assertEquals(list0.get(i).getName(), list0.get(i+1).getName());
        }
    }

    @Test
    public void test_three_permutations() throws Exception {
        PermutationJUnit4ClassRunner.Thrice runner = new PermutationJUnit4ClassRunner.Thrice(ClassToTest.class);
        List<FrameworkMethod> list0 = runner.computeTestMethods(0);
        assertEquals(30, list0.size());
        Collections.sort(list0, new Comparator<FrameworkMethod>() {
            @Override
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = 0; i < list0.size()-2; i = i + 3) {
            assertEquals(list0.get(i).getName(), list0.get(i+1).getName());
            assertEquals(list0.get(i).getName(), list0.get(i+2).getName());

        }
    }
}
