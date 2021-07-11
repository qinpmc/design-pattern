package 中介者2;

public class Test {
    public static void main(String[] args) {
        IMediator mediator = new Mediator();

        IPlayer player1 = new Player(mediator,"red","player1");
        IPlayer player2 = new Player(mediator,"red","player2");
        IPlayer player3 = new Player(mediator,"red","player3");
        IPlayer player4 = new Player(mediator,"red","player4");

        IPlayer player5 = new Player(mediator,"blue","player5");
        IPlayer player6 = new Player(mediator,"blue","player6");
        IPlayer player7 = new Player(mediator,"blue","player7");
        IPlayer player8 = new Player(mediator,"blue","player8");

        player1.add();
        player2.add();
        player3.add();
        player4.add();
        player5.add();
        player6.add();
        player7.add();
        player8.add();
//////////////////////////////////////////

        player1.die();
        player2.die();
        player3.die();
        player4.die();


    }
}
