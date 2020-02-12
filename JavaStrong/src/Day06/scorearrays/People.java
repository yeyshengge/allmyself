package Day06.scorearrays;

public class People {
    private String name;
    private int chinesescore;
    private int mathscore;

    public People() {
    }

    public People(String name, int chinesescore, int mathscore) {
        this.name = name;
        this.chinesescore = chinesescore;
        this.mathscore = mathscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinesescore() {
        return chinesescore;
    }

    public void setChinesescore(int chinesescore) {
        this.chinesescore = chinesescore;
    }

    public int getMathscore() {
        return mathscore;
    }

    public void setMathscore(int mathscore) {
        this.mathscore = mathscore;
    }
}
