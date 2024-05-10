package io.github.jaydy0102

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent
import org.bukkit.Particle
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

@Suppress("DEPRECATION")
class AttackListener : Listener {
    @EventHandler
    fun onAttackPlayer(event: PrePlayerAttackEntityEvent) {
        val entity = event.attacked
        val player = event.player
        val loc = entity.location.add(0.0,1.5,0.0)
        val item = event.player.itemInHand

        if (item.isSimilar(Recipe.heartShardSwordItemStack))
            player.giveExp(5,true)
            player.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION,1,0,true,true,false))
        if (item.isSimilar(Recipe.dragonSword))
            loc.world.spawnParticle(Particle.END_ROD,loc,10)
    }
}