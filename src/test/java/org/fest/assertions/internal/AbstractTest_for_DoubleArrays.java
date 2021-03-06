/*
 * Created on Oct 19, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.test.DoubleArrayFactory.array;
import static org.fest.assertions.test.ExpectedException.none;

import static org.mockito.Mockito.spy;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Rule;

import org.fest.assertions.test.ExpectedException;
import org.fest.assertions.util.AbsValueComparator;
import org.fest.util.ComparatorBasedComparisonStrategy;
import org.fest.util.StandardComparisonStrategy;

/**
 * Base class for testing <code>{@link DoubleArrays}</code>, set up an instance with {@link StandardComparisonStrategy}
 * and another with {@link ComparatorBasedComparisonStrategy}.
 * 
 * @author Joel Costigliola
 */
public class AbstractTest_for_DoubleArrays {

  @Rule
  public ExpectedException thrown = none();

  /**
   * is initialized with {@link #initActualArray()} with default value = {6.0, 8.0, 10.0}
   */
  protected double[] actual;
  protected Failures failures;
  protected DoubleArrays arrays;

  protected ComparatorBasedComparisonStrategy absValueComparisonStrategy;
  protected DoubleArrays arraysWithCustomComparisonStrategy;

  private AbsValueComparator<Double> absValueComparator = new AbsValueComparator<Double>();

  @Before
  public void setUp() {
    failures = spy(new Failures());
    arrays = new DoubleArrays();
    arrays.failures = failures;
    absValueComparisonStrategy = new ComparatorBasedComparisonStrategy(comparatorForCustomComparisonStrategy());
    arraysWithCustomComparisonStrategy = new DoubleArrays(absValueComparisonStrategy);
    arraysWithCustomComparisonStrategy.failures = failures;
    initActualArray();
  }

  protected void initActualArray() {
    actual = array(6.0, 8.0, 10.0);
  }

  protected Comparator<?> comparatorForCustomComparisonStrategy() {
    return absValueComparator;
  }

}