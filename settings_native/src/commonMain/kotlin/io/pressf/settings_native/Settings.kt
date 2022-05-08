package io.pressf.settings_native

expect class Settings() {

    constructor(name: String)

    fun setString(key: String, value: String)
    fun getString(key: String): String?

    fun setInt(key: String, value: Int)
    fun getInt(key: String): Int?

    fun setFloat(key: String, value: Float)
    fun getFloat(key: String): Float?

    fun setBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean?

    fun setStringSet(key: String, set: Set<String>)
    fun getStringSet(key: String): Set<String>?

    fun clearValue(key: String)

}