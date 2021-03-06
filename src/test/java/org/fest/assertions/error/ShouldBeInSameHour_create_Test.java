/*
 * Created on Sep 26, 2010
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
package org.fest.assertions.error;

import static junit.framework.Assert.assertEquals;

import static org.fest.assertions.error.ShouldBeInSameHour.shouldBeInSameHour;
import static org.fest.util.Dates.ISO_DATE_TIME_FORMAT;

import java.text.ParseException;

import org.junit.Test;

import org.fest.assertions.description.*;

/**
 * Tests for <code>{@link ShouldBeInSameHour#create(Description)}</code>.
 *
 * @author Joel Costigliola
 */
public class ShouldBeInSameHour_create_Test {

  @Test
  public void should_create_error_message() throws ParseException{
    ErrorMessageFactory factory = shouldBeInSameHour(ISO_DATE_TIME_FORMAT.parse("2011-01-01T05:00:00"),
        ISO_DATE_TIME_FORMAT.parse("2011-01-01T06:00:00"));

    String message = factory.create(new TextDescription("Test"));
    assertEquals("[Test] expected <2011-01-01T05:00:00> to be on same year, month, day and hour as <2011-01-01T06:00:00>", message);
  }

}
