/*
 * Copyright 2018 Telefonaktiebolaget LM Ericsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ericsson.bss.cassandra.ecchronos.core.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TestLongTokenRange
{
    @Test
    public void testRangesEqual()
    {
        LongTokenRange range1 = new LongTokenRange(1, 2);
        LongTokenRange range2 = new LongTokenRange(1, 2);

        assertThat(range1).isEqualTo(range2);
        assertThat(range1.hashCode()).isEqualTo(range2.hashCode());
        assertThat(range1.compareTo(range2)).isEqualTo(0);
    }

    @Test
    public void testNullRangesEqual()
    {
        LongTokenRange range1 = new LongTokenRange(null, null);
        LongTokenRange range2 = new LongTokenRange(null, null);

        assertThat(range1).isEqualTo(range2);
        assertThat(range1.hashCode()).isEqualTo(range2.hashCode());
    }

    @Test
    public void testRangeAndNullIsNotEqual()
    {
        LongTokenRange range1 = new LongTokenRange(1, 2);

        assertThat(range1).isNotEqualTo(null);
    }

    @Test
    public void testRangesNotEqual()
    {
        LongTokenRange range1 = new LongTokenRange(1, 2);
        LongTokenRange range2 = new LongTokenRange(2, 3);

        assertThat(range1).isNotEqualTo(range2);
        assertThat(range1.compareTo(range2)).isLessThan(0);
        assertThat(range2.compareTo(range1)).isGreaterThan(0);
    }
}
