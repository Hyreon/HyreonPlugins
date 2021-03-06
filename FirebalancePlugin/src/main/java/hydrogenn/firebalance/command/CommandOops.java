package hydrogenn.firebalance.command;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import hydrogenn.firebalance.Firebalance;
import hydrogenn.firebalance.utils.Messenger;

public class CommandOops implements CommandExecutor {
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
        	Player player = (Player) sender;
        	try {
        	Bukkit.getBanList(Type.NAME).pardon(Firebalance.killList.get(player.getName()));
        	Firebalance.killList.remove(player.getName());
        	Messenger.send(player, "Your recent kills are unbanned. +1 for being cautious :>");
        	} catch (IllegalArgumentException e) {
				Messenger.send(player, "No recent kills found. Maybe the user is already unbanned?");
        	}
        }
        return true;
    }
}