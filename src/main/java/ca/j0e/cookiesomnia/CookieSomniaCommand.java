package ca.j0e.cookiesomnia;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public class CookieSomniaCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String message = ChatColor.translateAlternateColorCodes('&', "&7[CookieSomnia] &a");

        if (args.length == 0) {
            message += "v";
            message += CookieSomnia.getInstance().getDescription().getVersion();
        }
        else {
            if (args[0].equals("on")) {
                CookieSomnia.getInstance().setEnable(true);
                message += "Enabled!";
            }
            else if (args[0].equals("off")) {
                CookieSomnia.getInstance().setEnable(false);
                message += "Disabled!";
            }
            else {
                message += ChatColor.translateAlternateColorCodes('&', "&cInvalid subcommand!");
            }
        }

        sender.sendMessage(message);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("on", "off");
        }
        return List.of();
    }
}
