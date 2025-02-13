/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.appactions.interaction.capabilities.core.impl.task.exceptions;

import androidx.annotation.NonNull;

/**
 * During the onExecuteListener handling, all required params should be present in the Map sent to
 * the listener. If they are not for some reason, this is an internal error.
 */
public final class MissingRequiredArgException extends Exception {

    public MissingRequiredArgException(@NonNull String message) {
        super(message);
    }
}
