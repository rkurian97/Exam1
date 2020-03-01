package sample;

public class RandomNumber {
    private int randnum;
    public RandomNumber(int randnum) {
        this.randnum = randnum;
    }

    @Override
    public String toString() {
        return Integer.toString(randnum);
    }
}
