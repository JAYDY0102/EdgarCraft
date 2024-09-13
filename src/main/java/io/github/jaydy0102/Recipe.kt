package io.github.jaydy0102

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.EquipmentSlotGroup
import org.bukkit.inventory.ItemRarity
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

abstract class Recipe {
    companion object {
        val impureheartShardItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Impure Heart Shard", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val heartShardItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Purified Heart Shard", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(2) }
        }
        val heartCrystalItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Heart Crystal", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(3) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(true); nutrition = 10; saturation = 10.0f; eatSeconds = 0.1f })}
        }
        val dragonFruitItemStack = ItemStack(Material.CHORUS_FRUIT).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Dragon Fruit", TextColor.color(170,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val bambooCandyItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Bamboo Candy", TextColor.color(255,255,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(4) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(false); nutrition = 3; saturation = 1.0f; eatSeconds = 0.5f })}
            itemMeta = itemMeta.apply { setMaxStackSize(99) }
        }
        val enchantedDiamondAppleItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Enchanted Diamond Apple")) }
            itemMeta = itemMeta.apply { setCustomModelData(5) }
            itemMeta = itemMeta.apply { setFood(food.apply { addEffect(PotionEffect(PotionEffectType.ABSORPTION, 3600, 4), 1.0f); addEffect(PotionEffect(PotionEffectType.REGENERATION, 600, 2), 1.0f); addEffect(PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 0), 1.0f); addEffect(PotionEffect(PotionEffectType.RESISTANCE, 6000, 2), 1.0f); setCanAlwaysEat(true) ; nutrition = 15; saturation = 10.0f; eatSeconds = 1.61f })}
            itemMeta = itemMeta.apply { setMaxStackSize(16) }
            itemMeta = itemMeta.apply { setEnchantmentGlintOverride(true) }
            itemMeta = itemMeta.apply { setRarity(ItemRarity.EPIC) }
        }
        val wardenHeartItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Warden's Heart", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(6) }
        }
        val warpCrystalItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Warp Crystal", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(true); nutrition = 0; saturation = 0.0f; eatSeconds = 0.1f })}
            itemMeta = itemMeta.apply { setCustomModelData(7) }
        }
        val homingCrystalItemStack = ItemStack(Material.CLOCK).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Homing Crystal", TextColor.color(170,0,0))) }
            itemMeta = itemMeta.apply { setFood(food.apply { setCanAlwaysEat(true); nutrition = 0; saturation = 0.0f; eatSeconds = 0.1f })}
            itemMeta = itemMeta.apply { setCustomModelData(8) }
        }
        val heartShardSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Heart Shard Sword", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Heart Shard Sword","Heart Shard Sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val dragonSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Dragon Sword", TextColor.color(0,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(2) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Dragon Sword","Dragon Sword"), 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
            itemMeta = itemMeta.apply { isUnbreakable = true }
        }
        val endermanSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Enderman's Sword", TextColor.color(170,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(3) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Enderman Sword","Enderman Sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val witherLongSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Wither's Longsword", TextColor.color(0,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(4) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.PLAYER_ENTITY_INTERACTION_RANGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.PLAYER_ENTITY_INTERACTION_RANGE, AttributeModifier(NamespacedKey("Wither Sword","Wither Sword"), 1.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND)) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Wither Sword","Wither Sword"), 6.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val hellspickaxeItemStack = ItemStack(Material.NETHERITE_PICKAXE).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Hell's Pickaxe", TextColor.color(170,0,0))) }
            itemMeta = itemMeta.apply { setCustomModelData(1) }
        }
        val elderGuardiansThornItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Elder Guardian's Thorn", TextColor.color(0,170,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(5) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Elder Guardian Thorn","Elder Guardian Thorn"), 11.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val shulkSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Shulk Sword", TextColor.color(255,85,255))) }
            itemMeta = itemMeta.apply { setCustomModelData(6) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Sculk Sword","Sculk Sword"), 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val roseSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Rose Sword", TextColor.color(255,85,85))) }
            itemMeta = itemMeta.apply { setCustomModelData(7) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Rose Sword","Rose Sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val iceSwordItemStack = ItemStack(Material.NETHERITE_SWORD).apply {
            itemMeta = itemMeta.apply { itemName(Component.text("Ice Sword", TextColor.color(0,0,170))) }
            itemMeta = itemMeta.apply { setCustomModelData(8) }
            itemMeta = itemMeta.apply { removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE) }
            itemMeta = itemMeta.apply { addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AttributeModifier(NamespacedKey("Ice Sword","Ice Sword"), 7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND))}
        }
        val endCrownItemStack: ItemStack = ItemStack(Material.LEATHER_HELMET).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemMeta = itemMeta.apply { itemName(Component.text("The Crown of the End", TextColor.color(255,255,85))) }
                setCustomModelData(1)
                removeAttributeModifier(EquipmentSlot.HEAD)
                addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, AttributeModifier(NamespacedKey("End Crown","End Crown"), 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.HEAD))
                addEnchant(Enchantment.THORNS, 5, true)
                addEnchant(Enchantment.PROTECTION, 10, true)
                setColor(Color.fromRGB(255, 0, 0))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(784)
            }
        }
        val wardensArmorItemStack: ItemStack = ItemStack(Material.LEATHER_CHESTPLATE).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemMeta = itemMeta.apply { itemName(Component.text("Warden's Chestplate", TextColor.color(0,0,170))) }
                setCustomModelData(1)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Warden Chestplate","Warden Chestplate"),9.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("Warden Chestplate","Warden Chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("Warden Chestplate","Warden Chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setColor(Color.fromRGB(255, 0, 0))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val piglinsArmorItemStack: ItemStack = ItemStack(Material.LEATHER_CHESTPLATE).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Pligin's Chestplate", TextColor.color(170,0,0)))
                setCustomModelData(2)
                isFireResistant = true
                removeAttributeModifier(EquipmentSlot.CHEST)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Piglin Chestplate","Piglin Chestplate"),7.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("Piglin Chestplate","Piglin Chestplate"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("Piglin Chestplate","Piglin Chestplate"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.CHEST))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val flyingChickenPantsItemStack: ItemStack = ItemStack(Material.LEATHER_LEGGINGS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(255,255,255)))
                setCustomModelData(1)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Flying Chicken Pants","Flying Chicken Pants"),5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GENERIC_GRAVITY,AttributeModifier(NamespacedKey("Flying Chicken Pants","Flying Chicken Pants"),0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setColor(Color.fromRGB(255, 0, 0))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(272)
            }
        }
        val anvilPantsItemStack: ItemStack = ItemStack(Material.LEATHER_LEGGINGS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(170,170,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.LEGS)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Hardened Steel Greaves","Hardened Steel Greaves"),8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, AttributeModifier(NamespacedKey("Hardened Steel Greaves","Hardened Steel Greaves"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, AttributeModifier(NamespacedKey("Hardened Steel Greaves","Hardened Steel Greaves"),0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.LEGS))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(784)
            }
        }
        val wardensBootsItemStack: ItemStack = ItemStack(Material.LEATHER_BOOTS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(80,170,170)))
                setCustomModelData(1)
                removeAttributeModifier(Attribute.GENERIC_ARMOR)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Warden Sabatons","Warden Sabatons"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, AttributeModifier(NamespacedKey("Warden Sabatons","Warden Sabatons"),1.5, AttributeModifier.Operation.MULTIPLY_SCALAR_1, EquipmentSlotGroup.FEET))
                setColor(Color.fromRGB(255, 0, 0))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
        val oceansBootsItemStack: ItemStack = ItemStack(Material.LEATHER_BOOTS).apply {
            itemMeta = (itemMeta as LeatherArmorMeta).apply {
                itemName(Component.text("Flying Chicken's Pants", TextColor.color(80,80,170)))
                setCustomModelData(2)
                removeAttributeModifier(EquipmentSlot.FEET)
                addAttributeModifier(Attribute.GENERIC_ARMOR, AttributeModifier(NamespacedKey("Ocean Pact","Ocean Pact"),4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                addAttributeModifier(Attribute.GENERIC_SAFE_FALL_DISTANCE, AttributeModifier(NamespacedKey("Ocean Pact","Ocean Pact"),512.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.FEET))
                lore(listOf(Component.text("Protects User From Heights", TextColor.color(255,255,255))))
                setColor(Color.fromRGB(0, 0, 255))
            }
            itemMeta = (itemMeta as Damageable).apply {
                setMaxDamage(656)
            }
        }
    }
}