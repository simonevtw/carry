package me.simonevtw.carry.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.List;

public class OnPlayerSneak implements Listener {
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        List<Entity> passengers = p.getPassengers();

        for(Entity passenger : passengers){
            p.removePassenger(passenger);
        }

    }
}
