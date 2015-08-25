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
 *
 * THIS FILE WAS GENERATED BY codergen. EDIT WITH CARE.
 */
package com.android.tools.rpclib.schema;

import com.android.tools.rpclib.binary.*;
import com.intellij.ui.SimpleColoredComponent;
import com.intellij.ui.SimpleTextAttributes;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class Primitive extends Type {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Primitive primitive = (Primitive)o;

        if (!mName.equals(primitive.mName)) return false;
        if (mMethod != primitive.mMethod) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mMethod.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return mName +"(" + mMethod + ")";
    }

    @Override
    public void encodeValue(@NotNull Encoder e, Object value) throws IOException {
        switch (mMethod.value) {
            case Method.ID: e.id((BinaryID)value); break;
            case Method.Bool: e.bool((Boolean)value); break;
            case Method.Int8: e.int8((Byte)value); break;
            case Method.Uint8: e.uint8((Short)value); break;
            case Method.Int16: e.int16((Short)value); break;
            case Method.Uint16: e.uint16((Integer)value); break;
            case Method.Int32: e.int32((Integer)value); break;
            case Method.Uint32: e.uint32((Long)value); break;
            case Method.Int64: e.int64((Long)value); break;
            case Method.Uint64: e.uint64((Long)value); break;
            case Method.Float32: e.float32((Float)value); break;
            case Method.Float64: e.float64((Double)value); break;
            case Method.String: e.string((String)value); break;
            default: throw new IOException("Invalid primitive method in encode");
        }
    }

    @Override
    public Object decodeValue(@NotNull Decoder d) throws IOException {
        switch (mMethod.value) {
            case Method.ID: return d.id();
            case Method.Bool: return d.bool();
            case Method.Int8: return d.int8();
            case Method.Uint8: return d.uint8();
            case Method.Int16: return d.int16();
            case Method.Uint16: return d.uint16();
            case Method.Int32: return d.int32();
            case Method.Uint32: return d.uint32();
            case Method.Int64: return d.int64();
            case Method.Uint64: return d.uint64();
            case Method.Float32: return d.float32();
            case Method.Float64: return d.float64();
            case Method.String: return d.string();
            default: throw new IOException("Invalid primitive method in decode");
        }
    }

    @Override
    public void render(@NotNull Object value, @NotNull SimpleColoredComponent component) {
        ConstantSet constants = ConstantSet.lookup(this);
        if (constants != null) {
            for (Constant constant : constants.getEntries()) {
                if (value.equals(constant.getValue())) {
                    component.append(constant.getName(), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                    return;
                }
            }
        }
        switch (mMethod.value) {
            case Method.ID:
                component.append(value.toString(), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Bool:
                component.append(String.format("%b", (Boolean)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Int8:
                component.append(String.format("%d", (Byte)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Uint8:
                component.append(String.format("%d", ((Byte)value).intValue() & 0xff), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Int16:
                component.append(String.format("%d", (Short)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Uint16:
                component.append(String.format("%d", ((Short)value).intValue() & 0xffff), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Int32:
                component.append(String.format("%d", (Integer)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Uint32:
                component.append(String.format("%d", ((Integer)value).longValue()&0xffffffffL), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Int64:
                component.append(String.format("%d", (Long)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Uint64:
                component.append(String.format("0x%s", Long.toHexString((Long)value)), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Float32:
                component.append(String.format("%f", (Float)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.Float64:
                component.append(String.format("%f", (Double)value), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            case Method.String:
                component.append((String)value, SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                return;
            default:
                component.append(value.toString(), SimpleTextAttributes.SYNTHETIC_ATTRIBUTES);
                break;
        }
    }

    //<<<Start:Java.ClassBody:1>>>
    String mName;
    Method mMethod;

    // Constructs a default-initialized {@link Primitive}.
    public Primitive() {}


    public String getName() {
        return mName;
    }

    public Primitive setName(String v) {
        mName = v;
        return this;
    }

    public Method getMethod() {
        return mMethod;
    }

    public Primitive setMethod(Method v) {
        mMethod = v;
        return this;
    }

    @Override @NotNull
    public BinaryClass klass() { return Klass.INSTANCE; }

    private static final byte[] IDBytes = {69, 77, -98, 125, -26, 79, 80, 116, -107, 19, 96, -67, -22, 0, 113, -109, -98, 62, -62, 78, };
    public static final BinaryID ID = new BinaryID(IDBytes);

    static {
        Namespace.register(ID, Klass.INSTANCE);
    }
    public static void register() {}
    //<<<End:Java.ClassBody:1>>>
    public enum Klass implements BinaryClass {
        //<<<Start:Java.KlassBody:2>>>
        INSTANCE;

        @Override @NotNull
        public BinaryID id() { return ID; }

        @Override @NotNull
        public BinaryObject create() { return new Primitive(); }

        @Override
        public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
            Primitive o = (Primitive)obj;
            e.string(o.mName);
            o.mMethod.encode(e);
        }

        @Override
        public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
            Primitive o = (Primitive)obj;
            o.mName = d.string();
            o.mMethod = Method.decode(d);
        }
        //<<<End:Java.KlassBody:2>>>
    }
}
