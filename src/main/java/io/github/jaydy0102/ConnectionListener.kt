package io.github.jaydy0102

import com.destroystokyo.paper.event.server.PaperServerListPingEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent 
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.util.NumberConversions
import java.util.*
import kotlin.random.Random.Default.nextInt

class ConnectionListener : Listener {
    @EventHandler
    fun onServerListPing(event: PaperServerListPingEvent) {
        val t = Calendar.getInstance(TimeZone.getTimeZone("GMT+9"))
        event.numPlayers = t.get(Calendar.YEAR) * 10000 + (t.get(Calendar.MONTH) + 1) * 100 + t.get(Calendar.DAY_OF_MONTH)
        event.maxPlayers = t.get(Calendar.HOUR) * 10000 + t.get(Calendar.MINUTE) * 100 + t.get(Calendar.SECOND)
        event.motd(Component.text("LifeSteal Survival", TextColor.color((nextInt(0xFFFFFF))),TextDecoration.BOLD))
        event.listedPlayers.clear()
        if (event.client.protocolVersion == -1) {
            event.isCancelled
        }
    }
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        if (player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue==0.0)
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.baseValue=ConfigManager.defaultLives
        if (!player.hasPlayedBefore()) {
            player.teleport(getSpawnLocation(player.name))
            player.openInventory(Gui.inv) }
    }
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val clickedItem = event.currentItem
        val meta = clickedItem?.itemMeta
        val player = event.whoClicked as Player
        val target = Bukkit.getPlayer(ConfigManager.currentWarpPlayer) as Player
        val target1 = Bukkit.getPlayer(ConfigManager.currentHomingPlayer) as Player
        val scale = player.getAttribute(Attribute.GENERIC_SCALE)
        val speed = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
        val jump = player.getAttribute(Attribute.GENERIC_JUMP_STRENGTH)
        val stepheight = player.getAttribute(Attribute.GENERIC_STEP_HEIGHT)
        val gravity = player.getAttribute(Attribute.GENERIC_GRAVITY)
        if (event.inventory == Gui.inv) {
            if (clickedItem != null) {
                if (clickedItem.itemMeta.hasCustomModelData()) {
                    if (meta!!.customModelData == 10) {
                        speed!!.baseValue *= 0.66
                        scale!!.baseValue *= 0.66
                        gravity!!.baseValue *= 0.66
                        player.closeInventory()
                    }
                    if (meta.customModelData == 12) {
                        speed!!.baseValue *= 1.5
                        scale!!.baseValue *= 1.5
                        jump!!.baseValue *= 1.5
                        stepheight!!.baseValue *= 1.5
                        gravity!!.baseValue *= 1.5
                        player.closeInventory()
                    } else player.closeInventory()
                }
            }
        }
        if (event.inventory == Gui.inv1) {
            if (clickedItem != null) {
                if(clickedItem.itemMeta.hasCustomModelData()) {
                    if (meta!!.customModelData == 0) {
                        teleportwarp(player, target)
                        EdgarMain.instance.config.set("current-warp-player", "")
                        player.closeInventory()
                    } else {
                        player.closeInventory()
                        target.sendMessage("Teleport Declined")
                    }
                }
            }
        }
        if (event.inventory == Gui.inv2) {
            if (clickedItem != null) {
                if(clickedItem.itemMeta.hasCustomModelData()) {
                    if (meta!!.customModelData == 0) {
                        teleporthoming(player, target1)
                        EdgarMain.instance.config.set("current-homing-player", "")
                        player.closeInventory()
                    } else {
                        player.closeInventory()
                        target.sendMessage("Teleport Declined")
                    }
                }
            }
        }
    }
    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        if (event.isBedSpawn || event.isAnchorSpawn) return

        event.respawnLocation = getSpawnLocation(event.player.name)
    }
    @EventHandler
    fun onPlayerChangedWorld(event: PlayerChangedWorldEvent){
        val player = event.player
        val world = player.world
        val open = ConfigManager.endbanned
        if (world.environment == World.Environment.THE_END) {
            if (open) {
                player.teleport(getSpawnLocation(player.name))
                player.sendMessage("${Component.text("END IS UNAVAILABLE", TextColor.color(255,255,0), TextDecoration.BOLD)}")
            }
        }
    }
    private fun getSpawnLocation(name: String): Location {
        val seed = name.hashCode()
        val random = Random(seed.toLong() xor 0x19940423)
        val world = Bukkit.getWorlds().first()
        val size = 2048

        val x = random.nextDouble() * size - size / 2.0
        val z = random.nextDouble() * size - size / 2.0
        val block = world.getHighestBlockAt(NumberConversions.floor(x), NumberConversions.floor(z))

        return block.location.add(0.5, 1.0, 0.5)
    }
    private fun teleportwarp (player: Player, target: Player) {
        target.teleport(player.location)
        target.sendMessage("Teleported to ${target.name}")
    }
    private fun teleporthoming (player: Player, target: Player) {
        player.teleport(target.location)
        target.sendMessage("Teleported ${target.name}")
    }
}