package com.felulo.easyhelpop;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Main extends JavaPlugin implements Listener
{
    public String translateColors(final String msg) {
        return msg.replace("&", "§");
    }
    
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getLogger().info("easyHelpOP 1.0.1 has been enabled.");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("helpop")) {
            if (sender.hasPermission("easyhelpop.use") || sender.hasPermission("easyhelpop.admin") || sender.isOp()) {
                if (args.length >= 1) {
                    final String str = String.join(" ", (CharSequence[])args);
                    sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Zg\u0142oszenie zosta\u0142o wys\u0142ane."));
                    sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &2Administracja si\u0119 z tob\u0105 skontaktuje jak tylko b\u0119dzie to mo\u017cliwe."));
                    Bukkit.broadcast(this.translateColors("&a[&7easyHelpOP&a] &6" + sender.getName().toString() + " &e>>&2 " + str), "easyhelpop.admin");
                }
                else {
                    sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cMusisz poda\u0107 tre\u015b\u0107 zg\u0142oszenia!"));
                }
            }
            else {
                sender.sendMessage(this.translateColors("&a[&7easyHelpOP&a] &cNie masz uprawnie\u0144 do u\u017cywania tej komendy!"));
            }
        }
        return false;
    }
}
