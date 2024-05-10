package io.github.jaydy0102

import org.bukkit.attribute.Attribute
import org.bukkit.entity.DragonFireball
import org.bukkit.entity.Entity.Spigot
import org.bukkit.entity.Pig
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemStack

class UseListener : Listener{
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent){
        val item = event.item
        val player = event.player
        val loc = player.location
        val yaw = player.yaw
        val pitch = player.pitch
        val playerData = event.player.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        if (item.isSimilar(ItemStack(Recipe.heartCrystalItemStack))){
            playerData!!.baseValue += 2.0
        }
        if (item.isSimilar(ItemStack(Recipe.dragonFruitItemStack))) return
    }
}