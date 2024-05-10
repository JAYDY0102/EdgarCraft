@file:Suppress("DEPRECATION")

package io.github.jaydy0102

import net.kyori.adventure.chat.ChatType
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import java.util.*

abstract class Recipe {
    companion object {
        val impureheartShardItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.DARK_RED}Impure Heart Shard") }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val heartShardItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.RED}Purified Heart Shard") }
            itemMeta = itemMeta.apply { setCustomModelData(2) }
        }
        val heartCrystalItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.RED}Heart Crystal") }
            itemMeta = itemMeta.apply { setCustomModelData(3) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(true) ; nutrition = 10 ; saturation = 10.0f ; eatSeconds = 0.1f })}
        }
        val dragonFruitItemStack = ItemStack(Material.CHORUS_FRUIT).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.DARK_PURPLE}Dragon Fruit") }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val bambooCandyItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.WHITE}.Bamboo Candy") }
            itemMeta = itemMeta.apply { setCustomModelData(4) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(true) ; nutrition = 3 ; saturation = 1.0f ; eatSeconds = 0.1f }) }
            itemMeta = itemMeta.apply { setMaxStackSize(99) }
        }
        val friedEggItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { setDisplayName("Fried Egg") }
            itemMeta = itemMeta.apply { setCustomModelData(5) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(false) ; nutrition = 5 ; saturation = 10.0f ; eatSeconds = 0.1f}) }
            itemMeta = itemMeta.apply { setMaxStackSize(16) }
        }
        val heartShardSwordItemStack = ItemStack(Material.DIAMOND_SWORD).apply {
            itemMeta = itemMeta.apply { setDisplayName("${ChatColor.RED}.Heart Shard Sword") }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(UUID.randomUUID(),"Heart Shard Sword",8.0,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND))}
            itemMeta = itemMeta.apply { setRarity(ItemRarity.EPIC) }
        }
        val dragonSword = ItemStack(Material.DIAMOND_SWORD).apply {
            itemMeta = itemMeta.apply { setDisplayName("Dragon Sword") }
            itemMeta = itemMeta.apply { setCustomModelData(2) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(UUID.randomUUID(),"Dragon Sword",10.0,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND))}
            itemMeta = itemMeta.apply { setRarity(ItemRarity.EPIC) }
            itemMeta = itemMeta.apply { isUnbreakable = true }
        }
    }
}