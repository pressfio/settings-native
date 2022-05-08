package io.pressf.settings_native

import android.content.Context
import androidx.startup.Initializer

class SettingsInitializer: Initializer<Settings> {

    override fun create(context: Context): Settings {
        Settings.setContext(context)
        return Settings()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

}