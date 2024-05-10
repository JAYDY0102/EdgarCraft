package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.NamespacedKey
import org.bukkit.inventory.BlastingRecipe
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapedRecipe

class EdgarMain : JavaPlugin() {
    companion object {
        lateinit var instance: EdgarMain
            private set
    }
    override fun onEnable() {
        instance = this
        logger.info("LifeSteal starting...")
        saveDefaultConfig()

        Bukkit.getPluginManager().registerEvents(ConnectionListener(), this)
        Bukkit.getPluginManager().registerEvents(DeathListener(), this)
        Bukkit.getPluginManager().registerEvents(MineListener(), this)
        Bukkit.getPluginManager().registerEvents(UseListener(), this)
        Bukkit.getPluginManager().registerEvents(AttackListener(),this)
        registerRecipe()

    }
    private fun registerRecipe() {
        //Impure -> Purified Heart Shard
        val key = NamespacedKey(this,"Purified_Heart_Shard")
        val recipe = BlastingRecipe(key, Recipe.heartShardItemStack, RecipeChoice.ExactChoice(Recipe.impureheartShardItemStack),5.0f,5)
        Bukkit.addRecipe(recipe)
        //Heart Crystal
        val key1 = NamespacedKey(this,"Heart_Crystal")
        val recipe1 = ShapedRecipe(key1,Recipe.heartCrystalItemStack).apply {
            shape("HEH", "EDE", "HEH")
            setIngredient('H',Recipe.heartShardItemStack)
            setIngredient('E',Material.ECHO_SHARD)
            setIngredient('D',Recipe.dragonFruitItemStack) }
        Bukkit.addRecipe(recipe1)
        //Bamboo Candy
        val key2 = NamespacedKey(this,"Bamboo_Candy")
        val recipe2 = ShapedRecipe(key2,Recipe.bambooCandyItemStack).apply {
            shape("SSS","SBS","SSS")
            setIngredient('S',Material.SUGAR)
            setIngredient('B',Material.BAMBOO) }
        Bukkit.addRecipe(recipe2)
        //Fried Egg
        val key3 = NamespacedKey(this,"Fried_Egg")
        val recipe3 = FurnaceRecipe(key3,Recipe.friedEggItemStack, Material.EGG, 5.0f, 10)
        Bukkit.addRecipe(recipe3)
        //Heart Shard Sword
        val key4 = NamespacedKey(this,"Heart_Shard_Sword")
        val recipe4 = ShapedRecipe(key4,Recipe.heartShardSwordItemStack).apply {
            shape("H","H","N")
            setIngredient('H',Recipe.heartShardItemStack)
            setIngredient('N',Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe4)
        //End
    }
}