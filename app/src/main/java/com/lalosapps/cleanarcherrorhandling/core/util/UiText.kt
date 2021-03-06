package com.lalosapps.cleanarcherrorhandling.core.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = emptyArray()
    ) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(
                id = id,
                formatArgs = args
            ) // formatArgs named argument is required for this to work properly. Passing args alone won't work.
        }
    }
}
