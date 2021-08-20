public class  TempConverter{

    public TempConverter() {
    }

    private void convertCityTemp (City city)
    {
        double degreesC = city.getTemperature();
        double degreesF = (degreesC * 9/5) + 32;
        city.setTemperature(Math.round(degreesF));
    }

    public void convertTemp(SummerHigh summerHigh)
    {
        convertCityTemp(summerHigh.getBase());
        convertCityTemp(summerHigh.getModerateCuts());
        convertCityTemp(summerHigh.getNoCuts());
    }
}
