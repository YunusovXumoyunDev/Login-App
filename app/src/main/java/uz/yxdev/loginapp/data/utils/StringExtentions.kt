package uz.yxdev.loginapp.data.utils

fun String.checkLogin(): Boolean {
    return length in 3..16 &&
            matches(Regex(".*[a-z].*")) &&
            matches(Regex(".*[A-Z].*"))
}
fun String.checkPassword(): Boolean {
    return length in 8..16 &&
            matches(Regex(".*[0-9].*")) &&
            matches(Regex(".*[a-z].*")) &&
            matches(Regex(".*[A-Z].*"))
}