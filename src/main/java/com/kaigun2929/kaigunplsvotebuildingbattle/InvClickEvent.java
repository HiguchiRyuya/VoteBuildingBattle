package com.kaigun2929.kaigunplsvotebuildingbattle;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Map;

public class InvClickEvent extends VoteDataBase implements Listener  {

    Map<Player,Player> voteDate;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        // クリックしたプレイヤーの配列番号を生成
        int clickIsPlayer = 0;
        for(int i = 0; i<super.cop.playerOnline.size();i++ ) {
            if (p.getName() == super.cop.playerOnline.get(i).getName()) {
                break;
            }
            clickIsPlayer++;
        }
        System.out.println(clickIsPlayer);

        if (e.getCurrentItem() == null) {
            return;
        }
        if (!e.getCurrentItem().hasItemMeta()) {
            return;
        }

        if (e.getInventory().getName().contains("投票")) {
            e.setCancelled(true);
            for(int i = 0;i < super.cop.playerOnline.size();i++) {

                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN
                        + (super.cop.playerOnline.get(i).getPlayer().getName() + ChatColor.RESET + "に投票します。"))) {

                    // ～が～に投票した
                    super.voteTarget.put(clickIsPlayer,super.cop.playerOnline.get(i).getPlayer());

                    System.out.println("投票者" + super.voteTargetKeys[clickIsPlayer]);
                    System.out.println("投票された人" + super.voteTarget.get(clickIsPlayer));

                    // 再度、同名に投票をさせない
                    if(super.cop.playerOnline.get(i).getPlayer() == super.voteTarget.get(clickIsPlayer).getPlayer() && isNotVoteFlag.get(clickIsPlayer) != 1) {
                        int point = (int)(super.numberOfVote.get(i));
                        point = point + 1;
                        System.out.println(point);
                        super.numberOfVote.put(i,(Integer) point);
                        p.sendMessage(ChatColor.DARK_GREEN
                                + (super.cop.playerOnline.get(i).getPlayer().getName() + ChatColor.RESET + "に投票しました。"));

                        isNotVoteFlag.put(clickIsPlayer,1);

                        return;

                    }
                    else{
                        p.sendMessage(ChatColor.RED + "投票先は一人です。同じプレイヤーには投票できません！");
                    }

                    System.out.println("自分のポイント" + super.numberOfVote.get(clickIsPlayer));
                    return;

                }
            }
        }

    }
}