/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.builder.dependency;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.builder.model.MavenCoordinates;

import java.io.File;

/**
 * Represents a Jar dependency. This could be the output of a Java project.
 */
public class JarDependency {

    @NonNull
    private final File mJarFile;

    private final boolean mCompiled;
    private boolean mPackaged;
    private final boolean mProguarded;

    @Nullable
    private final MavenCoordinates mResolvedCoordinates;

    public JarDependency(
            @NonNull File jarFile,
            boolean compiled,
            boolean packaged,
            boolean proguarded,
            @Nullable MavenCoordinates resolvedCoordinates) {
        mJarFile = jarFile;
        mCompiled = compiled;
        mPackaged = packaged;
        mProguarded = proguarded;
        mResolvedCoordinates = resolvedCoordinates;
    }


    public JarDependency(
            @NonNull File jarFile,
            boolean compiled,
            boolean packaged,
            @Nullable MavenCoordinates resolvedCoordinates) {
        this(jarFile, compiled, packaged, true, resolvedCoordinates);
    }

    @NonNull
    public File getJarFile() {
        return mJarFile;
    }

    public boolean isCompiled() {
        return mCompiled;
    }

    public boolean isPackaged() {
        return mPackaged;
    }

    public void setPackaged(boolean packaged) {
        mPackaged = packaged;
    }

    public boolean isProguarded() {
        return mProguarded;
    }

    @Nullable
    public MavenCoordinates getResolvedCoordinates() {
        return mResolvedCoordinates;
    }

    @Override
    public String toString() {
        return "JarDependency{" +
                "mJarFile=" + mJarFile +
                ", mCompiled=" + mCompiled +
                ", mPackaged=" + mPackaged +
                ", mProguarded=" + mProguarded +
                ", mResolvedCoordinates=" + mResolvedCoordinates +
                '}';
    }
}
