package de.topjan.healplugin;

import de.topjan.healplugin.command.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class HealPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        getCommand("heal").setExecutor(new HealCommand());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
