/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.android.build.transform.api;

import com.android.annotations.NonNull;
import com.google.common.annotations.Beta;

import java.io.File;
import java.util.Set;

/**
 * Represent content qualified with one or more {@link ContentType} and one or more {@link Scope}.
 */
@Beta
public interface QualifiedContent {

    /**
     * The type of of the content.
     */
    enum ContentType {
        /**
         * The content is compiled Java code. This can be in a Jar file or in a folder. If
         * in a folder, it is expected to in sub-folders matching package names.
         */
        CLASSES(0x01),
        /**
         * The content is dex files.
         */
        DEX(0x02),
        /**
         * The content if standard Java resources.
         */
        RESOURCES(0x04);

        private final int value;

        ContentType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * The scope of the content.
     *
     * <p/>
     * This indicates what the content represents, so that Transforms can apply to only part(s)
     * of the classes or resources that the build manipulates.
     */
    enum Scope {
        /** Only the project content */
        PROJECT(0x01),
        /** Only the project's local dependencies (local jars) */
        PROJECT_LOCAL_DEPS(0x02),
        /** Only the sub-projects. */
        SUB_PROJECTS(0x04),
        /** Only the sub-projects's local dependencies (local jars). */
        SUB_PROJECTS_LOCAL_DEPS(0x08),
        /** Only the external libraries */
        EXTERNAL_LIBRARIES(0x10),
        /** Code that is being tested by the current variant, including dependencies */
        TESTED_CODE(0x20),
        /** Local or remote dependencies that are provided-only */
        PROVIDED_ONLY(0x40);

        private final int value;

        Scope(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * The name of the content. Can be used to differentiate different content using the same scope.
     *
     * This is not reliably usable at every stage of the pipeline, but can be used for logging for
     * instance.
     *
     * @return the name
     */
    @NonNull
    String getName();

    /**
     * The location of the content.
     *
     * @return the content location.
     */
    @NonNull
    File getFile();

    /**
     * Returns the type of content that the stream represents.
     * <p/>
     * Even though this may return only {@link ContentType#RESOURCES} or
     * {@link ContentType#CLASSES}, the actual content (the folder or the jar) may contain files
     * representing other content types. This is because the transform mechanism avoids duplicating
     * files around to remove unwanted types for performance.
     * <p/>
     * For each input, transforms should always take care to read only the files associated
     * with the types returned by this method.
     *
     * @return a set of one or more types, never null nor empty.
     */
    @NonNull
    Set<ContentType> getContentTypes();

    /**
     * Returns the scope of the stream.
     *
     * @return a set of one or more scopes, never null nor empty.
     */
    @NonNull
    Set<Scope> getScopes();
}