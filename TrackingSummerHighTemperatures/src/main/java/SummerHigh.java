public class SummerHigh {
    public City base;
    public City noCuts;
    public City moderateCuts;

    public SummerHigh(City base, City noCuts, City moderateCuts) {
        this.base = base;
        this.noCuts = noCuts;
        this.moderateCuts = moderateCuts;
    }

    public City getBase() {
        return base;
    }

    public void setBase(City base) {
        this.base = base;
    }

    public City getNoCuts() {
        return noCuts;
    }

    public void setNoCuts(City noCuts) {
        this.noCuts = noCuts;
    }

    public City getModerateCuts() {
        return moderateCuts;
    }

    public void setModerateCuts(City moderateCuts) {
        this.moderateCuts = moderateCuts;
    }

    public String format(boolean fahrenheit) {
        String tempLetter;
        if (fahrenheit) tempLetter = "F";
        else tempLetter = "C";
        StringBuilder cityTemp = new StringBuilder();
        cityTemp.append("In 2100, " + base.name + ", " + base.country + " " + base.temperature + " " + tempLetter + " will be like\n");
        cityTemp.append("   " + noCuts.name + ", " + noCuts.country + " " + noCuts.temperature + " " + tempLetter + " with no emission cuts\n");
        cityTemp.append("   " + moderateCuts.name + ", " + moderateCuts.country + " " + moderateCuts.temperature + " " + tempLetter + " with moderate emission cuts\n");
        return cityTemp.toString();
    }
}