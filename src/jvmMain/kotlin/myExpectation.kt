import com.russhwolf.settings.PropertiesSettings
import com.russhwolf.settings.Settings
import java.io.File

actual fun myExpectation(settings: Settings): Settings {
    return settings
}
