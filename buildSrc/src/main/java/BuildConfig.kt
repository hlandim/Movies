import java.io.FileInputStream
import java.util.Properties

object BuildConfigType {
    const val boolean = "Boolean"
    const val string = "String"
}

object BuildConfigFields {
    const val isLogOn = "IS_LOG_ON"
    const val apiKey = "API_KEY"
    const val apiBaseUrl = "API_BASE_URL"
    const val apiImgBaseUrl = "API_IMG_BASE_URL"
}

object BuildConfigValues {
    const val apiBaseUrlValue = "https://api.themoviedb.org/3/"
    const val apiBaseImgUrlValue = "https://image.tmdb.org/t/p/"
}

object Apps {
    const val applicationId = "com.hlandim.movies"
    const val compileSdk = 32
    const val minSdk = 24
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "0.0.1"

    private val fis = FileInputStream("versions.properties")
    val versions = Properties().apply {
        load(fis)
    }
}

object Module {
    const val central = ":central"
    const val featMoviesList = ":features:movies-list"
    const val commonView = ":common:view"
    const val commonUi = ":common:ui"
    const val commonTestView = ":common:test-view"
    const val commonData = ":common:data"
}

