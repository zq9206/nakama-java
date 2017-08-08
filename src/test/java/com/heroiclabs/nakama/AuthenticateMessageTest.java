/*
 * Copyright 2017 The Nakama Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.heroiclabs.nakama;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

public class AuthenticateMessageTest {

    private static Client client;

    @BeforeClass
    public static void init() {
        client = DefaultClient.builder("defaultkey").build();
        Assert.assertNotNull(client);
    }

    @Test
    public void testDevice() throws Exception {
        final AuthenticateMessage auth = AuthenticateMessage.device(UUID.randomUUID().toString());
        final Session session = client.register(auth).join(2000);
        Assert.assertNotNull(session);
    }

}