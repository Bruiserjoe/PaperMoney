package com.bruiserjoe.pmoney.Events;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventsLis implements Listener{

    @EventHandler
    public void onSignChange(SignChangeEvent e){
        if(e.getPlayer().hasPermission("paper.makeshop")){

        }
    }


    public void signClick(PlayerInteractEvent event){
        Block clickb = event.getClickedBlock();
        BlockState state = clickb.getState();
        Player p = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (state instanceof Sign) {
                Sign sign = (Sign) state;
                String line1 = sign.getLine(0);
                String line2 = sign.getLine(1);
                String line3 = sign.getLine(2);
                int l3 = Integer.parseInt(line3);
                if (line1.equalsIgnoreCase("[Buy]")) {

                }
                if (line1.equalsIgnoreCase("[Sell]")) {


                }
                if (line1.equalsIgnoreCase(("[Check]"))) {


                }
            }
        }


    }

}
