package io.github.jaydy0102

object ConfigManager {
    private val config = EdgarMain.instance.config

    val banDuration: Int
        get() = config.getInt("ban-duration")
    val defaultLives: Double
        get() = config.getDouble("default-lives")
}