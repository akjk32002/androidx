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

package androidx.appactions.builtintypes.properties

import androidx.appactions.builtintypes.types.Person

/**
 * Represents the value of the union property: http://schema.org/recipient, currently it only can
 * contain {@link Person}.
 */
class Recipient(person: Person) {
    @get:JvmName("asPerson")
    val asPerson: Person? = person
}