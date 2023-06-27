package com.vandrushko.ui.utils

import android.text.TextUtils
import android.util.Patterns

private const val PASSWORD_REGEX =
    "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,}\$"

class Matcher {     // TODO why not object?
    fun isValidPassword(password: String?): Boolean =
        password != null && Regex(PASSWORD_REGEX).find(password) != null && !TextUtils.isEmpty( // TODO why not just use password.isEmpty() ?
            password
        )

    fun isValidEmail(email: String?): Boolean =
        email != null && Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && !TextUtils.isEmpty(email)
}