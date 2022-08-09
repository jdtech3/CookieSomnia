package ca.j0e.cookiesomnia;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerItemConsumeListener implements Listener {
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        if (CookieSomnia.getInstance().getEnable()) {
            Player player = event.getPlayer();

            if (event.getItem().getType().equals(Material.COOKIE)) {
                player.setStatistic(Statistic.TIME_SINCE_REST, 0);

                String message = CookieSomnia.getInstance().getMessage();
                if (message != null) {
                    player.sendMessage(message);
                }
            }
        }
    }
}
