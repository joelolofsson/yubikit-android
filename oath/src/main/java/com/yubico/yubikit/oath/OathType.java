/*
 * Copyright (C) 2019 Yubico.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yubico.yubikit.oath;

/**
 * OTP types that supported for YubiKey OATH
 */
public enum OathType {

    HOTP((byte) 0x10),
    TOTP((byte) 0x20);

    public final byte value;

    OathType(byte value) {
        this.value = value;
    }

    public static OathType fromValue(byte value) {
        for (OathType type : OathType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not a valid OathType: " + value);
    }

    public static OathType fromString(String value) {
        if ("hotp".equalsIgnoreCase(value)) {
            return HOTP;
        } else if ("totp".equalsIgnoreCase(value)) {
            return TOTP;
        }
        throw new IllegalArgumentException("Not a valid OathType: " + value);
    }
}
