package com.bruiserjoe.pmoney.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;

public class takemoney implements CommandExecutor{

    public static void removeMoney(Player p, int am){
        int totali = 0;
        int aleft = 0;
        //Fix named paper causing error
        if(p.getInventory().contains(Material.PAPER, am)) {
            p.sendMessage("Taking some money");
            HashMap<Integer, ItemStack> papers = (HashMap<Integer, ItemStack>) p.getInventory().all(Material.PAPER);
            for (Map.Entry<Integer, ItemStack> ent : papers.entrySet()) {
                ItemStack j = ent.getValue();
                if(j.hasItemMeta()) {
                    List<String> lore = j.getItemMeta().getLore();
                    String first = lore.get(0);
                    //if (first.equalsIgnoreCase(ChatColor.BLUE + "Worth 1 Money")) {
                    totali += j.getAmount();


                }

            }
            ItemStack money = new ItemStack(Material.PAPER, totali);
            ItemMeta meta = money.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN  + "Money");
            ArrayList<String> l =  new ArrayList<String>();
            l.add(ChatColor.BLUE + "Worth 1 Money");
            meta.setLore(l);
            money.setItemMeta(meta);
            aleft = totali - am;
            String ileft = Integer.toString(aleft);
            if (aleft >= 0) {
                p.getInventory().removeItem(money);
                givemoney.givePaper(p, ileft);
            } else {
                p.sendMessage("You don't have enough");

            }


        }else {
            p.sendMessage("You don't have enough");

        }
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
                int amount = Integer.parseInt(strings[0]);
                Player p = (Player) commandSender;
               removeMoney(p, amount);


                }
                return false;


        }


        //return false;
    }

