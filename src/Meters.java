
public class Meters { //Class to allow creation
    private String meterName;
    private int maxworth;
    private int currentworth;

    public Meters(String meterName, int maxworth, int currentworth) { //Allows creation of new health bars in other classes
        this.meterName = meterName;
        this.maxworth = maxworth;
        this.currentworth = currentworth;
    }

    public String getmeterName() { //allows for printing of the current set name of the meter
        return meterName;
    }

    public int getMaxworth() { //allows for printing of the current set max worth of the meter
        return maxworth;
    }

    public int getCurrentworth() { //allows for printing of the current worth
        return currentworth;
    }

    public void worthUp(int increase) {
        currentworth = Math.min(currentworth + increase, maxworth); // sets new current worth ,adds increase to currentworth and compares it to max, currentworth becomes the smaller number(this makes it so it cant get over max).
    }

    public void worthDown(int decrease) {
        currentworth = Math.max(currentworth - decrease, 0); // sets new current worth, takes away decrease and compares it to 0, it sets it to the highest. this makes it so your health cant go lower than 0.
    }
}
