package com.kaigun2929.kaigunplsvotebuildingbattle;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.Map;

public class VoteGUI extends VoteDataBase{

    public VoteGUI(){
    }

    public void OpenGUI() {

        System.out.println("OpenInv前");

        for (int i = 0; i < super.cop.playerOnline.size(); i++) {
            Inventory inv;
            inv = Bukkit.createInventory(null, 18, "投票");



            SetInvOfPlayerHead( i, inv);
            //inv.setItem();
            super.cop.playerOnline.get(i).openInventory(inv);
            System.out.println(super.cop.playerOnline.get(i).getName() + "のOpenInv");
            //System.out.println(super.numberOfVoteKeys[i]+"のポイントは"+ super.numberOfVote.get(i));
        }

    }

    public void SetInvOfPlayerHead( int nowOpenInvPlayer, Inventory inv) {
        ItemStack playerHead = new ItemStack(Material.SKULL_ITEM,1,(short) SkullType.PLAYER.ordinal());
        SkullMeta skullMetaDate = (SkullMeta) playerHead.getItemMeta();
        int slotCount = 0;

        // プレイヤーヘッドを個人に合った形で生成
        for (int j = 0; j < super.cop.playerOnline.size(); j++) {
            Player nowCreatePlayerHead = super.cop.playerOnline.get(j).getPlayer();

            // 自分の頭はセットしない処理
            if (super.cop.playerOnline.get(nowOpenInvPlayer).getName() != nowCreatePlayerHead.getName()) {
                skullMetaDate.setOwningPlayer(nowCreatePlayerHead);
                skullMetaDate.setDisplayName(ChatColor.DARK_GREEN + nowCreatePlayerHead.getName() + ChatColor.RESET + "に投票します。");
                playerHead.setItemMeta(skullMetaDate);

                // スロットにセット
                inv.setItem(slotCount, playerHead);
            }
            slotCount++;

        }
    }

    /*
    public Map<Integer,Integer> GetPlayerRanking(){
        return null;
    }
    */
}

