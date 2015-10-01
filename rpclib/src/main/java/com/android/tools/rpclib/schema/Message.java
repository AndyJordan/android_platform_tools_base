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

package com.android.tools.rpclib.schema;

import com.android.tools.rpclib.binary.*;
import com.intellij.util.containers.HashMap;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class Message implements BinaryObject {
    public Entity[] entities;
    public ConstantSet[] constants;

    @Override
    @NotNull
    public BinaryClass klass() {
        return Klass.INSTANCE;
    }

    private static final byte[] IDBytes = {40, -113, 108, -120, 49, -47, 4, 82, -73, 90, 37, -125,
            1, 78, -102, 124, 83, 3, 50, -98,};

    public static final BinaryID ID = new BinaryID(IDBytes);

    static {
        Namespace.register(ID, Klass.INSTANCE);
    }

    public static void register() {
    }

    public enum Klass implements BinaryClass {
        INSTANCE;

        @Override
        @NotNull
        public BinaryID id() {
            return ID;
        }

        @Override
        @NotNull
        public BinaryObject create() {
            return new Message();
        }

        @Override
        public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
            Message o = (Message) obj;
            e.uint32(o.entities.length);
            for (Entity entity : o.entities) {
                e.entity(entity);
            }
            e.uint32(o.constants.length);
            for (ConstantSet set :  o.constants) {
                set.encode(e);
            }
        }

        @Override
        public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
            Message o = (Message) obj;
            o.entities = new Entity[d.uint32()];
            for (int i = 0; i < o.entities.length; i++) {
                o.entities[i] = d.entity();
            }
            o.constants = new ConstantSet[d.uint32()];
            for (int i = 0; i < o.constants.length; i++) {
                o.constants[i] = new ConstantSet(d);
            }
        }
    }
}