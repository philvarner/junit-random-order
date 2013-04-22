=====================================
Welcome to JUnit Contrib Random Order
=====================================

Usage

Unintended run order dependencies are a significant cause of test flapping.  The intention of this package is to aid
in uncovering these dependencies.

These runners can be used by annotating your test class with

@RunWith(ReproducibleRandomOrderJUnit4ClassRunner.class)

JUnit does not have a way to globally-override the default runner BlockJUnit4ClassRunner -- you must annotate
every class with the non-default runner you wish to use.  One solution to this is to create a new
class BlockJUnit4ClassRunner that's in your classpath before the "real" one, but you also must make change the class
hierarchy so that none of your runners extend BlockJUnit4ClassRunner as the runners in this package do.

The Runners

ReproducibleRandomOrderJUnit4ClassRunner
Randomizes the run order of each test method within a class, but allows for repeating an order once you have an order
that fails because of order dependencies.  The seed for randomization is either the numeric value of the Java
system property junit.order.seed or System.currentTimeMillis().  The seed value is printed during initialization so
that you can later re-run with the same seed.

PermutationJUnit4ClassRunnerTest.Twice,Thrice, and Ten
Same reproducible random order as ReproducibleRandomOrderJUnit4ClassRunner, but with multiple random orders
for all the test methods within a single run.  This is good for discovering test methods that aren't idempotent within
a test run.

TwoTimesJUnit4ClassRunnerTest
Same reproducible random order as ReproducibleRandomOrderJUnit4ClassRunner, but also run each method twice sequentially.
This is good for discovering test methods that aren't idempotent within a test run.
