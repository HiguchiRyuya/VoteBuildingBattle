package com.kaigun2929.kaigunplsvotebuildingbattle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CheckOnlinePlayers {
    // playerのデータ保管
    public Map<Integer,Player> playerOnline = new HashMap<Integer, Player>();


    int numberOnlinePlayers = Bukkit.getOnlinePlayers().size();

    CheckOnlinePlayers(){

        Integer i = 0;

        // player Dataを入れます
        for(Player player:Bukkit.getOnlinePlayers()){
            playerOnline.put(i,player);
            i++;
            System.out.println("player:" + player);
            System.out.println("人数: " + numberOnlinePlayers);
        }
    }
}
