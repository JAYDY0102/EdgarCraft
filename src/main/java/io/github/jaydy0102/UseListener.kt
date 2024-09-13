package io.github.jaydy0102

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.inventory.ItemStack
import net.wesjd.anvilgui.AnvilGUI

class UseListener : Listener{
    @EventHandler
    fun onPlayerItemConsume(event: PlayerItemConsumeEvent){
        val item = event.item
        val player = event.player
        val playerData = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)
        if (item.isSimilar(ItemStack(Recipe.heartCrystalItemStack))){
            if (playerData!!.baseValue == 60.0) {
                player.sendMessage(Component.text("Max HP Reached", TextColor.color(255,255,0)))
            }
            else playerData.baseValue += 2.0
        }
        if (item.isSimilar(ItemStack(Recipe.warpCrystalItemStack))){
            openAnvilGui(player)
        }
        if (item.isSimilar(ItemStack(Recipe.homingCrystalItemStack))){
            openAnvilGui1(player)
        }
    }
    private fun openAnvilGui(player: Player) {
        AnvilGUI.Builder()
            .onClick { slot, stateSnapshot ->  // Either use sync or async variant, not both
                if (slot !== AnvilGUI.Slot.OUTPUT) {
                    return@onClick emptyList()
                }
                val text = stateSnapshot.text
                val targetPlayer = Bukkit.getPlayer(text)
                val playerName = player.name
                if (targetPlayer != null && targetPlayer.isOnline) {
                    openAcceptGui(targetPlayer)
                    EdgarMain.instance.config.set("current-warp-player",playerName)
                    return@onClick listOf(AnvilGUI.ResponseAction.close())
                } else {
                    return@onClick listOf(AnvilGUI.ResponseAction.replaceInputText("Try again"))
                }
            }
            .text("Enter Player Name")
            .title("Teleport - Warp")
            .plugin(EdgarMain.instance)
            .open(player)
    }
    private fun openAnvilGui1(player: Player) {
        AnvilGUI.Builder()
            .onClick { slot, stateSnapshot ->  // Either use sync or async variant, not both
                if (slot !== AnvilGUI.Slot.OUTPUT) {
                    return@onClick emptyList()
                }
                val text = stateSnapshot.text
                val targetPlayer = Bukkit.getPlayer(text)
                val playerName = player.name
                if (targetPlayer != null && targetPlayer.isOnline) {
                    openAcceptGui1(targetPlayer)
                    EdgarMain.instance.config.set("current-homing-player",playerName)
                    return@onClick listOf(AnvilGUI.ResponseAction.close())
                } else {
                    return@onClick listOf(AnvilGUI.ResponseAction.replaceInputText("Try again"))
                }
            }
            .text("Enter Player Name")
            .title("Teleport - Homing")
            .plugin(EdgarMain.instance)
            .open(player)
    }
    private fun openAcceptGui(targetPlayer: Player) {
        targetPlayer.openInventory(Gui.inv1)
    }
    private fun openAcceptGui1(targetPlayer: Player) {
        targetPlayer.openInventory(Gui.inv2)
    }
}