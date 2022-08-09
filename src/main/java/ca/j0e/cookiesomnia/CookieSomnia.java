package ca.j0e.cookiesomnia;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CookieSomnia extends JavaPlugin {
    private static CookieSomnia instance = null;
    private FileConfiguration config = getConfig();
    private boolean debug;
    private String message;
    private boolean enable;

    @Override
    public void onEnable() {
        config.addDefault("debug", false);
        config.addDefault("enable", true);
        config.addDefault("message", "Mmm... you feel alert, and the fear for the phantoms at the edge of your vision disappears.");
        config.options().copyDefaults(true);
        this.saveConfig();

        debug = config.getBoolean("debug");
        message = config.getString("message");
        enable = config.getBoolean("enable");

        this.getCommand("cookiesomnia").setExecutor(new CookieSomniaCommand());
        getServer().getPluginManager().registerEvents(new PlayerItemConsumeListener(), this);

        getLogger().info("CookieSomnia v" + this.getDescription().getVersion() + " loaded.");
        instance = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("CookieSomnia v" + this.getDescription().getVersion() + " unloaded.");
    }

    public static CookieSomnia getInstance() {
        return instance;
    }
    public boolean getDebug() {
        return debug;
    }
    public String getMessage() {
        return message;
    }
    public boolean getEnable() {
        return enable;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
