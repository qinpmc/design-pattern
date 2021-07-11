package 中介者2;

public class Player implements IPlayer{
    private String name;
    private String color;
    private String state = "alive";
    private IMediator mediator;

    public Player(IMediator mediator){
        this.mediator = mediator;
    }
    public Player(IMediator mediator,String color,String name){
        this.mediator = mediator;
        this.color = color;
        this.name = name;
    }

    @Override
    public void win() {
        System.out.println(this.getName() +" 赢了");
    }

    @Override
    public void lose() {
        System.out.println(this.getName() +" 输了");
    }

    @Override
    public void die() {
        this.state = "dead";
        this.mediator.receiveMessage("playerDead",this);
    }

    @Override
    public void add() {
        this.mediator.receiveMessage("addPlayer",this);
    }

    @Override
    public void remove() {
        this.mediator.receiveMessage("removePlayer",this);
    }

    @Override
    public void changeTeam(String color) {
        this.mediator.receiveMessage("changeTeam",this,color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
