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

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(includeFieldNames = true)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class DefaultMatch implements Match {
    private final byte[] id;
    private final List<UserPresence> presence;
    private final UserPresence self;

    static Match fromProto(final @NonNull com.heroiclabs.nakama.Api.TMatch match) {
        return DefaultMatch.fromProto(match.getMatch());
    }

    static Match fromProto(final @NonNull com.heroiclabs.nakama.Api.Match match) {
        List<UserPresence> userPresences = new ArrayList<UserPresence>();
        for (com.heroiclabs.nakama.Api.UserPresence u : match.getPresencesList()) {
            userPresences.add(DefaultUserPresence.fromProto(u));
        }

        return new DefaultMatch(match.getMatchId().toByteArray(), userPresences, DefaultUserPresence.fromProto(match.getSelf()));
    }

}
