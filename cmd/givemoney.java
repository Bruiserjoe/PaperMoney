package com.bruiserjoe.pmoney.cmd;

import com.bruiserjoe.pmoney.pmoney;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class givemoney implements CommandExecutor{

    public static void givePaper(Player p, String amount){
        int amounti = Integer.parseInt(amount);
        ItemStack money = new ItemStack(Material.PAPER, amounti);
        ItemMeta meta = money.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN  + "Money");
        ArrayList<String> lore =  new ArrayList<String>();
        lore.add(ChatColor.BLUE + "Worth 1 Money");
        meta.setLore(lore);
        money.setItemMeta(meta);
        p.getInventory().addItem(money);

    }

    @Override
    public boolean onCommand(CommandSender cSender, Command command, String s, String[] strings) {

        if(cSender instanceof Player){
            Player player = (Player) cSender;
            cSender.sendMessage("Here have some money");
            givePaper(player, strings[0]);
            return true;


        }
        return false;
    }
}
