package 中介者2;

public interface IMediator {
//    void addPlayer(IPlayer player);
//    boolean removePlayer(IPlayer player);
//    void changeTeam(IPlayer player);
//    void playerDead(IPlayer player);
    void receiveMessage(String type,IPlayer player);
    void receiveMessage(String type,IPlayer player,String color);
}
