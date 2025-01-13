package io.github.jaydy0102

import org.bukkit.*
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import kotlin.random.Random.Default.nextInt

class MineListener : Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    fun onBlockBreak(event: BlockBreakEvent) {

        val block = event.block
        val player = event.player

        if (block.type == Material.ANCIENT_DEBRIS
            && player.gameMode.let { it == GameMode.SURVIVAL }
            && block.getDrops(player.inventory.itemInMainHand, player).isNotEmpty()
        ) {
            event.isDropItems = false
            val loc = block.location.add(0.5, 0.3, 0.5)
            val item = if (nextInt(9) == 0) {
                ItemStack(Recipe.impureheartShardItemStack)
            } else {
                ItemStack(Material.NETHERITE_SCRAP)
            }
            loc.world.dropItem(loc, item).apply { pickupDelay -= 2 }
        }
        if (block.type == Material.CHORUS_FLOWER
            && player.gameMode.let { it == GameMode.SURVIVAL }
            && player.inventory.itemInMainHand.type == Material.NETHERITE_HOE
        ) {
            event.isDropItems = false
            val loc1 = block.location.add(0.5, 0.3, 0.5)
            val item1 = if (nextInt(19) == 0) {
                ItemStack(Recipe.dragonFruitItemStack)
            } else {
                ItemStack(Material.CHORUS_PLANT)
            }
            loc1.world.dropItem(loc1, item1).apply { pickupDelay -= 2 }
        }
    }
}