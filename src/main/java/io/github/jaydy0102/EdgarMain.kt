package io.github.jaydy0102

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.NamespacedKey
import org.bukkit.inventory.BlastingRecipe
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
        server.scheduler.runTaskTimer(this, EquipmentEffects, 0L,1L)
        registerRecipe()
    }
    private fun registerRecipe() {
        //Impure -> Purified Heart Shard
        val key = NamespacedKey(this,"Purified_Heart_Shard")
        val recipe = BlastingRecipe(key, Recipe.heartShardItemStack, RecipeChoice.ExactChoice(Recipe.impureheartShardItemStack),10.0f,2000)
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
        //Enchanted Diamond Apple
        val key3 = NamespacedKey(this,"Enchanted_Diamond_Apple")
        val recipe3 = ShapedRecipe(key3,Recipe.enchantedDiamondAppleItemStack).apply {
            shape("DDD","DAD","DDD")
            setIngredient('D', Material.DIAMOND_BLOCK)
            setIngredient('A',Material.APPLE) }
        Bukkit.addRecipe(recipe3)
        //Heart Shard Sword
        val key4 = NamespacedKey(this,"Heart_Shard_Sword")
        val recipe4 = ShapedRecipe(key4,Recipe.heartShardSwordItemStack).apply {
            shape("H","H","N")
            setIngredient('H',Recipe.heartShardItemStack)
            setIngredient('N',Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe4)
        //Enderman's Sword
        val key5 = NamespacedKey(this,"Endermans_Sword")
        val recipe5 = ShapedRecipe(key5,Recipe.endermanSwordItemStack).apply {
            shape("  P","CP ","EC ")
            setIngredient('P',Material.ENDER_PEARL)
            setIngredient('C',Material.POPPED_CHORUS_FRUIT)
            setIngredient('E',Material.END_ROD) }
        Bukkit.addRecipe(recipe5)
        //Wither's LongSword
        val key6 = NamespacedKey(this,"Withers_Sword")
        val recipe6 = ShapedRecipe(key6,Recipe.witherLongSwordItemStack).apply {
            shape("  S","NW ","BN ")
            setIngredient('S',Material.STONE_SWORD)
            setIngredient('N',Material.NETHERITE_INGOT)
            setIngredient('W',Material.WITHER_SKELETON_SKULL)
            setIngredient('B',Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipe6)
        //Hell's Pickaxe
        val key7 = NamespacedKey(this,"Hells_Pickaxe")
        val recipe7 = ShapedRecipe(key7,Recipe.hellspickaxeItemStack).apply {
            shape("NNS"," BN","B N")
            setIngredient('S',Material.NETHER_STAR)
            setIngredient('N',Material.NETHERITE_INGOT)
            setIngredient('B',Material.BLAZE_ROD)}
        Bukkit.addRecipe(recipe7)
        //Elder Guardian's Thorn
        val key8 = NamespacedKey(this,"Elder_Guardians_Thorn")
        val recipe8 = ShapedRecipe(key8,Recipe.elderGuardiansThornItemStack).apply {
            shape("  P","GH ","SG ")
            setIngredient('P',Material.PRISMARINE_SHARD)
            setIngredient('G',Material.ENCHANTED_GOLDEN_APPLE)
            setIngredient('H',Material.HEART_OF_THE_SEA)
            setIngredient('S',Material.SEA_PICKLE)}
        Bukkit.addRecipe(recipe8)
        //Shulk Sword
        val key9 = NamespacedKey(this,"Shulk_Sword")
        val recipe9 = ShapedRecipe(key9,Recipe.shulkSwordItemStack).apply {
            shape("  F","SD ","ES ")
            setIngredient('S',Material.SHULKER_SHELL)
            setIngredient('D',Material.DRAGON_HEAD)
            setIngredient('F',Material.ELYTRA)
            setIngredient('E',Material.END_ROD) }
        Bukkit.addRecipe(recipe9)
        //Rose Sword
        val key10 = NamespacedKey(this,"Rose_Sword")
        val recipe10 = ShapedRecipe(key10,Recipe.roseSwordItemStack).apply {
            shape("  W","WW ","RW ")
            setIngredient('W',Material.WITHER_ROSE)
            setIngredient('R',Material.ROSE_BUSH) }
        Bukkit.addRecipe(recipe10)
        //Ice Sword
        val key11 = NamespacedKey(this,"Ice_Sword")
        val recipe11 = ShapedRecipe(key11,Recipe.iceSwordItemStack).apply {
            shape("  I","II ","DI ")
            setIngredient('I',Material.BLUE_ICE)
            setIngredient('D',Material.DIAMOND_SWORD) }
        Bukkit.addRecipe(recipe11)
        //Piglin Chestplate
        val key12 = NamespacedKey(this,"Piglins_Chestplate")
        val recipe12 = ShapedRecipe(key12,Recipe.piglinsArmorItemStack).apply {
            shape("L L","NPN","BNB")
            setIngredient('L',Material.LAVA_BUCKET)
            setIngredient('N',Material.NETHERITE_INGOT)
            setIngredient('P',Material.MUSIC_DISC_PIGSTEP)
            setIngredient('B',Material.NETHER_BRICK) }
        Bukkit.addRecipe(recipe12)
        //Flying Chicken Pants
        val key13 = NamespacedKey(this,"Flying_Chicken_Pants")
        val recipe13 = ShapedRecipe(key13,Recipe.flyingChickenPantsItemStack).apply {
            shape("LPL","I I","B B")
            setIngredient('L',Material.FEATHER)
            setIngredient('I',Material.IRON_INGOT)
            setIngredient('P',Material.ELYTRA)
            setIngredient('B',Material.SHULKER_SHELL) }
        Bukkit.addRecipe(recipe13)
        //Anvil Pants
        val key14 = NamespacedKey(this,"Anvil_Pants")
        val recipe14 = ShapedRecipe(key14,Recipe.anvilPantsItemStack).apply {
            shape("BLB","N N","N N")
            setIngredient('N',Material.ANVIL)
            setIngredient('L',Material.IRON_BLOCK)
            setIngredient('B',Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe14)
        //The Oceans Boots
        val key15 = NamespacedKey(this,"Ocean_Boots")
        val recipe15 = ShapedRecipe(key15,Recipe.oceansBootsItemStack).apply {
            shape(" T ","NPN","D D")
            setIngredient('T',Material.TRIDENT)
            setIngredient('N',Material.CONDUIT)
            setIngredient('P',Material.HEART_OF_THE_SEA)
            setIngredient('D',Material.NETHERITE_INGOT) }
        Bukkit.addRecipe(recipe15)
        //Wardens Ice Boots
        val key16 = NamespacedKey(this,"Wardens_Boots")
        val recipe16 = ShapedRecipe(key16,Recipe.wardensBootsItemStack).apply {
            shape("N N","N N","H H")
            setIngredient('N',Material.NETHERITE_INGOT)
            setIngredient('H',Recipe.wardenHeartItemStack)}
        Bukkit.addRecipe(recipe16)
        //Wardens Chestplate
        val key17 = NamespacedKey(this,"Wardens_Chestplate")
        val recipe17 = ShapedRecipe(key17,Recipe.wardensArmorItemStack).apply {
            shape("D D","SHS","ECE")
            setIngredient('D',Material.SCULK_SHRIEKER)
            setIngredient('S',Material.SCULK_SENSOR)
            setIngredient('H',Recipe.wardenHeartItemStack)
            setIngredient('C',Material.SCULK_CATALYST)
            setIngredient('E',Material.ECHO_SHARD) }
        Bukkit.addRecipe(recipe17)
        //Warp Crystal - Updated Item
        val key18 = NamespacedKey(this,"Warp_Crystal")
        val recipe18 = ShapedRecipe(key18,Recipe.warpCrystalItemStack).apply {
            shape(" G ","GEG"," G ")
            setIngredient('E',Material.ENDER_PEARL)
            setIngredient('G',Material.GHAST_TEAR)}
        Bukkit.addRecipe(recipe18)
        //Homing Crystal - Updated Item
        val key19 = NamespacedKey(this,"Homing_Crystal")
        val recipe19 = ShapedRecipe(key19,Recipe.homingCrystalItemStack).apply {
            shape("FGF","GEG","FGF")
            setIngredient('G',Material.ENDER_PEARL)
            setIngredient('F',Material.DIAMOND)
            setIngredient('E',Material.GHAST_TEAR)}
    Bukkit.addRecipe(recipe19)
    }
}