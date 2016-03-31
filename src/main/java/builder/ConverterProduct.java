package builder;

public class ConverterProduct {

    private StringBuilder output;

    /**
     * Constructor.
     */
    public ConverterProduct()
    {
        output = new StringBuilder();
    }

    /**
     * Append a piece of string to our product.
     *
     * @param string The string to append.
     */
    public void appendString(String string) {
        output.append(string);
    }

    /**
     * Get the actual output.
     *
     * @return The output.
     */
    public String getOutput() {
        return this.output.toString();
    }

}
