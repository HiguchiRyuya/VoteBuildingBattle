package com.kaigun2929.kaigunplsvotebuildingbattle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class VoteDataBase {

    CheckOnlinePlayers cop = new CheckOnlinePlayers();
   static Map<Integer,Player> voteTarget = new HashMap<Integer, Player>();
   static  Map<Integer,Integer> numberOfVote = new HashMap<Integer, Integer>();
   static Map<Integer,Integer> isNotVoteFlag = new HashMap<Integer, Integer>();

    Integer voteTargetKeys[] = new Integer[cop.playerOnline.size()];
    Integer numberOfVoteKeys[] = new Integer[cop.playerOnline.size()];

    VoteDataBase(){

        Integer i = 0;
        for(Player p: Bukkit.getOnlinePlayers()){
            voteTarget.put(i,null);
            numberOfVote.put(i,0);
            isNotVoteFlag.put(i,0);
            i++;
        }

        int count = 0;
        for(Integer p:voteTarget.keySet()){
            voteTargetKeys[count] = p;
            count++;
        }
        count = 0;
        for(Integer p:numberOfVote.keySet()){
            numberOfVoteKeys[count] = p;
            count++;
        }
    }

}
