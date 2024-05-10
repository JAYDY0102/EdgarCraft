package io.github.jaydy0102

import org.bukkit.attribute.Attribute
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class ConnectionListener : Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        if (e.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue<1.0)
            e.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue=ConfigManager.defaultLives
    }
}