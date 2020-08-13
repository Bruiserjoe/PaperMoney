package com.bruiserjoe.pmoney;

import com.bruiserjoe.pmoney.Events.EventsLis;
import com.bruiserjoe.pmoney.cmd.givemoney;
import com.bruiserjoe.pmoney.cmd.takemoney;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Level;



public class pmoney extends JavaPlugin{
    @Override
    public void onEnable(){
        ArrayList<ItemStack> moneys;
        this.getCommand("givemoney").setExecutor(new givemoney());
        this.getCommand("takemoney").setExecutor(new takemoney());
        Bukkit.getPluginManager().registerEvents(new EventsLis(), this);
        Bukkit.getLogger().log(Level.INFO, "PaperMoney has started");
    }
    @Override
    public void onDisable(){
        Bukkit.getLogger().log(Level.INFO, "PaperMoney has stopped");
    }
}
