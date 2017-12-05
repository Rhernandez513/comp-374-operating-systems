/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package osdi.collections;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoundBufferTest {

    @Test
    public void CreateBufferWithSemaphoreTest() throws Exception {
        BoundBuffer queue_model  = new BoundBuffer();

        SimpleQueue<Integer> queue = queue_model.createBoundBufferWithSemaphores(4);

        queue.enqueue(1);
        Integer expected_result = 1;

        Integer actual_result = queue.dequeue();

        assertEquals(expected_result, actual_result);

    }
}
