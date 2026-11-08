package me.simonevtw.carry;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import me.simonevtw.carry.commands.CarryCommand;
import me.simonevtw.carry.listeners.OnPlayerSneak;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            event.registrar().register(CarryCommand.create());
                });
        this.getServer().getPluginManager().registerEvents(new OnPlayerSneak(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
