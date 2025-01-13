package io.github.jaydy0102

object ConfigManager {
    private val config = EdgarMain.instance.config

    val banDurationLong: Long
        get() = config.getLong("ban-duration")
    val banDurationString: String
        get() = config.getString("ban-duration") as String
    val defaultLives: Double
        get() = config.getDouble("default-lives")
    val currentWarpPlayer: String
        get() = config.getString("current-warp-player") as String
    val currentHomingPlayer: String
        get() = config.getString("current-homing-player") as String
    val endbanned: Boolean
        get() = config.getBoolean("end-banned")
}