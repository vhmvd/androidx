/*
 * Copyright 2024 The Android Open Source Project
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

package androidx.compose.foundation.text.input.internal

import androidx.compose.ui.text.intl.PlatformLocale
import androidx.compose.ui.text.style.TextDirection
import java.text.DecimalFormatSymbols

internal actual fun resolveTextDirectionForKeyboardTypePhone(
    locale: PlatformLocale
): TextDirection {
    val symbols = DecimalFormatSymbols.getInstance(locale)
    val zero = symbols.zeroDigit
    val digitDirection = Character.getDirectionality(zero)
    return if (
        digitDirection == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
            digitDirection == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
    ) {
        TextDirection.Rtl
    } else {
        TextDirection.Ltr
    }
}
