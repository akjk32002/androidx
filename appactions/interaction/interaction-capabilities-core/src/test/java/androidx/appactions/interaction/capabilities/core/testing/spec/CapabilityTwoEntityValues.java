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

package androidx.appactions.interaction.capabilities.core.testing.spec;

import androidx.annotation.NonNull;
import androidx.appactions.interaction.capabilities.core.BaseExecutionSession;
import androidx.appactions.interaction.capabilities.core.impl.BuilderOf;
import androidx.appactions.interaction.capabilities.core.impl.converters.TypeConverters;
import androidx.appactions.interaction.capabilities.core.impl.spec.ActionSpec;
import androidx.appactions.interaction.capabilities.core.impl.spec.ActionSpecBuilder;
import androidx.appactions.interaction.capabilities.core.properties.Entity;
import androidx.appactions.interaction.capabilities.core.properties.Property;
import androidx.appactions.interaction.capabilities.core.values.EntityValue;

import com.google.auto.value.AutoValue;

import java.util.Optional;

public final class CapabilityTwoEntityValues {

    private static final String CAPABILITY_NAME = "actions.intent.TEST";
    public static final ActionSpec<Properties, Arguments, Void> ACTION_SPEC =
            ActionSpecBuilder.ofCapabilityNamed(CAPABILITY_NAME)
                    .setDescriptor(Properties.class)
                    .setArguments(Arguments.class, Arguments::newBuilder)
                    .bindOptionalParameter(
                            "slotA",
                            Properties::slotA,
                            Arguments.Builder::setSlotA,
                            TypeConverters.ENTITY_PARAM_VALUE_CONVERTER,
                            TypeConverters.ENTITY_ENTITY_CONVERTER)
                    .bindOptionalParameter(
                            "slotB",
                            Properties::slotB,
                            Arguments.Builder::setSlotB,
                            TypeConverters.ENTITY_PARAM_VALUE_CONVERTER,
                            TypeConverters.ENTITY_ENTITY_CONVERTER)
                    .build();

    private CapabilityTwoEntityValues() {}

    /** Two required strings */
    @AutoValue
    public abstract static class Arguments {
        public static Builder newBuilder() {
            return new AutoValue_CapabilityTwoEntityValues_Arguments.Builder();
        }

        public abstract Optional<EntityValue> slotA();

        public abstract Optional<EntityValue> slotB();

        /** Builder for the testing Arguments. */
        @AutoValue.Builder
        public abstract static class Builder implements BuilderOf<Arguments> {

            public abstract Builder setSlotA(EntityValue value);

            public abstract Builder setSlotB(EntityValue value);

            @Override
            public abstract Arguments build();
        }
    }

    /** Two required strings */
    @AutoValue
    public abstract static class Properties {
        @NonNull
        public static Builder newBuilder() {
            return new AutoValue_CapabilityTwoEntityValues_Properties.Builder();
        }

        public abstract Optional<Property<Entity>> slotA();

        public abstract Optional<Property<Entity>> slotB();

        /** Builder for {@link Property} */
        @AutoValue.Builder
        public abstract static class Builder {

            @NonNull
            public abstract Builder setSlotA(@NonNull Property<Entity> value);

            @NonNull
            public abstract Builder setSlotB(@NonNull Property<Entity> value);

            @NonNull
            public abstract Properties build();
        }
    }

    public interface ExecutionSession extends BaseExecutionSession<Arguments, Void> {}
}
