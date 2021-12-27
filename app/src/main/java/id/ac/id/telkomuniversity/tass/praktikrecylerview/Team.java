package id.ac.id.telkomuniversity.tass.praktikrecylerview;

public class Team {

    private String name;
    private int win;
    private int lose;
    private int tie;

    // setter
    public void setName(String name){
        this.name = name;
    }
    public void setWin(int win){
        this.win = win;
    }
    public void setLose(int lose){
        this.lose = lose;
    }
    public void setTie(int tie){
        this.tie = tie;
    }

    // getter
    public String getName(){
        return this.name;
    }
    public int getWin(){
        return this.win;
    }
    public int getLose(){
        return this.lose;
    }
    public int getTie(){
        return this.tie;
    }
    public int getPoints(){
        return win * 3 + tie;
    }

    public static Team generateTeam(String name, int win, int tie, int lose) {
        Team team = new Team();
        team.setName(name);
        team.setWin(win);
        team.setTie(tie);
        team.setLose(lose);
        return team;
    }
}
