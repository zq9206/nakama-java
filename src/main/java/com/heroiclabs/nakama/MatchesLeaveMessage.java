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

import com.google.protobuf.ByteString;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public interface MatchesLeaveMessage extends CollatedMessage<Boolean> {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    class Builder {

        public static MatchesLeaveMessage.Builder newBuilder() {
            return new DefaultMatchesLeaveMessage.Builder(com.heroiclabs.nakama.Api.TMatchesLeave.newBuilder());
        }

        private final @NonNull
        com.heroiclabs.nakama.Api.TMatchesLeave.Builder leaves;

        public MatchesLeaveMessage.Builder matchId(final @NonNull byte[] matchId) {
            leaves.addMatchIds(ByteString.copyFrom(matchId));
            return this;
        }

        public MatchesLeaveMessage build() {
            final com.heroiclabs.nakama.Api.Envelope.Builder payload =
                    com.heroiclabs.nakama.Api.Envelope.newBuilder()
                            .setMatchesLeave(leaves);
            return new DefaultMatchesLeaveMessage(payload);
        }

    }
}
