package catnoob.firstjointp;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Timer;
import java.util.TimerTask;

public class Onplayerjoin implements Listener {
    private static Main plugin;
    public Onplayerjoin(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event){
        if (plugin.getConfig().getBoolean("enable")) {
            Player player = event.getPlayer();
            if (!player.hasPlayedBefore()) {
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        Location destination = new Location(player.getWorld(), plugin.getConfig().getDouble("X"), plugin.getConfig().getDouble("Y"), plugin.getConfig().getDouble("Z"));
                        player.teleport(destination);
                    }
                };
                timer.schedule(task, 1000);
            }
        }
    }
}

