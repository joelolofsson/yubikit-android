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

package com.yubico.yubikit.utils;

import androidx.annotation.Nullable;

/**
 * Helper class allows to customize logs within the SDK
 * SDK has only 2 levels of logging: debug information and error
 * If a Logger implementation is not provided the SDK won't produce any logs
 */
public abstract class Logger {
    /**
     * Logs message (debug level)
     *
     * @param message the message can to be logged
     */
    protected void logDebug(String message) {
    }

    ;

    /**
     * Logs message (error level)
     *
     * @param message   the message can to be logged
     * @param throwable the exception that can to be logged or counted
     */
    protected void logError(String message, Throwable throwable) {
    }

    ;

    private static Logger instance = null;

    /**
     * Set the Logger implementation to use. Override the logDebug and logError methods to produce
     * logs. Call with null to disable logging.
     *
     * @param logger
     */
    public static void setLogger(@Nullable Logger logger) {
        instance = logger;
    }

    public static void d(String message) {
        if (instance != null) {
            instance.logDebug(message);
        }
    }

    public static void e(String message, Throwable throwable) {
        if (instance != null) {
            instance.logError(message, throwable);
        }
    }
}
