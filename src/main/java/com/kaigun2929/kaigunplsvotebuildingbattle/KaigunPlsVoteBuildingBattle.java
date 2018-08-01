package com.kaigun2929.kaigunplsvotebuildingbattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class KaigunPlsVoteBuildingBattle extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic


        System.out.print("VoteBuildingPluginが有効になりました。");


        getServer().getPluginManager().registerEvents(new InvClickEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.print("VoteBuildingPluginが無効になりました。");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (label.equalsIgnoreCase("votebb")) {

            System.out.print("コマンドが実行されました。");
            VoteGUI voteGUI = new VoteGUI();

            voteGUI.OpenGUI();
            System.out.print("コマンドが終了しました。");

        }
        return true;
    }
}
