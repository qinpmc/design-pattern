package 中介者2;

public interface IPlayer {

    void win();
    void lose();
    void die();
    void add();
    void remove();
    void changeTeam(String color);
    String  getColor();
    String getState();
}
