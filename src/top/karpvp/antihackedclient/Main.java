package top.karpvp.antihackedclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements PluginMessageListener {

//    public String msg = "§6§lK§e§lar §8> §7§l请使用含有§f§lForge&7的客户端进入本服务器。\n§e或购买Rank以使用不含Forge端进入本服务器";
    public void onEnable() {
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "MC|Brand", this);
//        saveDefaultConfig();
//        YamlConfiguration yc = new YamlConfiguration();
//        try {
//            yc.load(getDataFolder() + "\\config.yml");
//            this.msg = yc.getString("message").replace("\\n", "\n").replace("&", "§");
//        } catch (IOException | InvalidConfigurationException e) {
//            System.err.print("读取配置文件失败");
//        }
        getServer().getConsoleSender().sendMessage("§c反作弊客户端已启用");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§c反作弊客户端已停用");
    }

    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (channel.equalsIgnoreCase("MC|Brand")) {
            Object localObject;
            try {
                localObject = new String(message, "UTF-8");
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
//                Object localObject;
                throw new Error(localUnsupportedEncodingException);
            }
            if ((!((String) localObject).contains("fml")) && (!((String) localObject).contains("forge"))
                    && (!((String) localObject).equalsIgnoreCase("fml,forge"))
                    && (!((String) localObject).contains("LiteLoader"))
                    && (!((String) localObject).equalsIgnoreCase("LiteLoader"))) {
                if (!player.hasPermission("kar.client")) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
//                            player.kickPlayer("§8§kI §f §6§lK§e§lar §a§lNet§2§lWork §8§kI\n§7§l请使用含有§f§lForge§7的客户端进入本服务器。\n§e或购买§8[W]以上Rank§e才可以使用不含Forge端进入本服务器");
                            player.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&6&lK&e&lar &2&lNet&a&lWork &f- &3&lKar&b&lOt &9Check \n"
                                    + "&7您目前的端不含 &7&lForge &7所以无法加入本服务器 \n"
                                    + "&8-------------------------------------------------------- \n"
                                    + "&7如果想加入本服务器，有以下方法： \n"
                                    + "&7① &8安装Forge &7(百度/Bing搜索) \n"
                                    + "&7② &8购买Zombie及以上会员 &7(使用黑客仍然封禁) \n"
                                    + "&7&m(这只是为了防止大部分的错误) \n"
                                    + "&7如果您使用了forge仍无法进入服务器,请使用正版启动器 \n"
                                    + "&8-------------------------------------------------------- \n"
                                    + "&7You need &8&lForge &7or &8Buy Zombie or higher Rank &7to join this server!"));
                            cancel();
                        }
                    }.runTaskTimer((Plugin) this, 20L, 20L);
//                    player.kickPlayer("§6§lK§e§lar §8> \n§7§l请使用含有§f§lForge&7的客户端进入本服务器。\n§e或购买Rank以使用不含Forge端进入本服务器");
                }
            }
        }
    }

}
