package bmt.codelympics_.model;

public class SalvaDimensioni {
    private static final SalvaDimensioni instance = new SalvaDimensioni();

    public static SalvaDimensioni getInstance() {
        return instance;
    }

    private Double[] array = new Double[2]; // Valori predefiniti

    public void setArray(Double[] array) {
        this.array = array;
    }

    public Double[] getArray() {
        return array;
    }
}
