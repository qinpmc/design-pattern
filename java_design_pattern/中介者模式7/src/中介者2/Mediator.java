package 中介者2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mediator implements IMediator {

    private HashMap<String, ArrayList<IPlayer>> players = new HashMap<>();


    public void addPlayer(IPlayer player) {
        String teamColor = player.getColor();
        ArrayList<IPlayer> playersList = players.get(teamColor);
        if (playersList == null) {
            playersList = new ArrayList<IPlayer>();
        }
        playersList.add(player);
        players.put(teamColor,playersList);
    }


    public boolean removePlayer(IPlayer player) {
        String teamColor = player.getColor();
        ArrayList<IPlayer> playersList = players.get(teamColor);
        if (playersList == null) {
            return true;
        }
        if (playersList.contains(player)) {
            return playersList.remove(player);
        }
        return false;
    }


    public void changeTeam(IPlayer player) {

    }


    public void playerDead(IPlayer player) {
        String color = player.getColor();
        Boolean allDead = true;
        List<IPlayer> list = players.get(color);
        for (int i = 0; i < list.size(); i++) {
            IPlayer gamer = list.get(i);
            String state = gamer.getState();
            if ("alive".equals(state)) {
                allDead = false;
                break;
            }
        }
        if(true == allDead){ //队员全部死亡
            //通知所有本队队员游戏失败
            for (int i = 0; i < list.size(); i++) {
                IPlayer gamer = list.get(i);
                gamer.lose();
            }
            List<IPlayer> enimies = null;
            for (String key : players.keySet()) {
                if(!key.equals(color)){
                    enimies = players.get(key);
                }
            }
            //通知所有对方队员游戏获胜
            for (int i = 0; i < enimies.size(); i++) {
                IPlayer gamer = enimies.get(i);
                gamer.win();
            }
        }
    }

    @Override
    public void receiveMessage(String type, IPlayer player) {
        if ("addPlayer".equals(type)) {
            this.addPlayer(player);

        } else if ("removePlayer".equals(type)) {
            this.removePlayer(player);
        } else if ("playerDead".equals(type)) {
            this.playerDead(player);
        }

    }

    @Override
    public void receiveMessage(String type, IPlayer player, String color) {

    }
}
