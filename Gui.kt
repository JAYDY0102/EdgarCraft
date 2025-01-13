package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class Gui{
    companion object {
        val inv: Inventory = Bukkit.createInventory(null, 27)
        val inv1: Inventory = Bukkit.createInventory(null,9,"Accept Teleport - Warp")
        val inv2: Inventory = Bukkit.createInventory(null,9,"Accept Teleport - Homing")
        init {
            initializeItems()
        }
        private fun initializeItems() {
            inv.setItem(4, createGuiItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE,0,true,"Custom","Custom"))
            inv.setItem(11, createGuiItem(Material.CLOCK,10,false,"${ChatColor.RESET}Small","${ChatColor.LIGHT_PURPLE}0.66 Multiplier On Speed, Size, Gravity","${ChatColor.RESET}Benefits in fitting in small areas","${ChatColor.RESET}Drawbacks in decreased general stats"))
            inv.setItem(13, createGuiItem(Material.CLOCK,11,false,"${ChatColor.RESET}Normal","${ChatColor.RESET}No Multiplier On Speed, Jump, Size, Gravity","${ChatColor.RESET}No Particular Benefits","${ChatColor.RESET}No Particular Drawbacks"))
            inv.setItem(15, createGuiItem(Material.CLOCK,12,false,"${ChatColor.RESET}Large","${ChatColor.LIGHT_PURPLE}1.50 Multiplier On Speed, Jump, Size, Gravity","${ChatColor.RESET}Benefits in increased general stats","${ChatColor.RESET}Drawbacks in difficulty of mobility"))
            inv1.setItem(3, createGuiItem(Material.GREEN_STAINED_GLASS_PANE,0,false,"${ChatColor.GREEN}Accept Teleport"))
            inv1.setItem(5, createGuiItem(Material.RED_STAINED_GLASS_PANE,1,false,"${ChatColor.GREEN}Decline Teleport"))
            inv2.setItem(3, createGuiItem(Material.GREEN_STAINED_GLASS_PANE,0,false,"${ChatColor.GREEN}Accept Teleport"))
            inv2.setItem(5, createGuiItem(Material.RED_STAINED_GLASS_PANE,1,false,"${ChatColor.GREEN}Decline Teleport"))
        }
        private fun createGuiItem(material: Material, data: Int, boolean: Boolean, name: String, vararg lore: String): ItemStack {
            val item = ItemStack(material, 1)
            val meta: ItemMeta? = item.itemMeta
            meta?.setCustomModelData(data)
            meta?.isHideTooltip = boolean
            meta?.setDisplayName(name)
            meta?.lore = lore.toList()
            item.itemMeta = meta
            return item
        }
    }
}