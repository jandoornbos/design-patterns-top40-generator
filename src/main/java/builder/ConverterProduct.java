package builder;

public class ConverterProduct {

    private StringBuilder output;

    public ConverterProduct()
    {
        output = new StringBuilder();
    }

    public void appendString(String string) {
        output.append(string);
    }

    public String getOutput() {
        return this.output.toString();
    }

}
