@file:Suppress("DEPRECATION")

package io.github.jaydy0102

import org.bukkit.*
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import kotlin.math.max
import kotlin.math.sqrt
import kotlin.random.Random.Default.nextInt


class MineListener : Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    fun onBlockBreak(event: BlockBreakEvent) {

        val block = event.block
        val player = event.player

        if (block.type == Material.ANCIENT_DEBRIS
            && player.gameMode.let { it == GameMode.SURVIVAL || it == GameMode.ADVENTURE }
            && block.getDrops(player.inventory.itemInMainHand, player).isNotEmpty()){
            event.isDropItems = false
            val loc = block.location.add(0.5, 0.8, 0.5)
            val count = 1

            for (i in 0 until count) {
                val item = if (nextInt(1) == 0) {
                    ItemStack(Material.CLOCK).apply {
                        itemMeta = itemMeta.apply { setDisplayName("${ChatColor.DARK_RED}Impure Heart Shard") }
                        itemMeta = itemMeta.apply { setCustomModelData(1) }
                    }
                } else { ItemStack(Material.ANCIENT_DEBRIS) }
                loc.world.dropItem(loc, item).apply { pickupDelay -= i * 2
                }
            }
        }
        if (block.type == Material.CHORUS_FLOWER
            && player.gameMode.let { it == GameMode.SURVIVAL || it == GameMode.ADVENTURE }
            && player.inventory.itemInMainHand.isSimilar(ItemStack(Material.NETHERITE_HOE))){
            event.isDropItems = false
            val loc1 = block.location.add(0.5, 0.8, 0.5)
            val count1 = max(1, sqrt(nextInt(1).toDouble()).toInt())

            for (i in 0 until count1) {
                val item1 = if (nextInt(19) == 0) {
                    ItemStack(Material.CHORUS_FRUIT).apply {
                        itemMeta = itemMeta.apply { setDisplayName("${ChatColor.DARK_PURPLE}Dragon Fruit") }
                        itemMeta = itemMeta.apply { setCustomModelData(1) }
                    }
                } else { ItemStack(Material.CHORUS_PLANT) }
                loc1.world.dropItem(loc1, item1).apply { pickupDelay -= i * 2
                }
            }
        }
    }
}