package bmt.codelympics_.model;

// Classe SalvaDimensioni che utilizza il pattern Singleton per salvare le dimensioni di una finestra
public class SalvaDimensioni {
    // Istanza statica di SalvaDimensioni, unica per tutta l'applicazione
    private static final SalvaDimensioni instance = new SalvaDimensioni();

    // Metodo statico per ottenere l'unica istanza di SalvaDimensioni
    public static SalvaDimensioni getInstance() {
        return instance;
    }

    // Array di Double per memorizzare le dimensioni (larghezza e altezza)
    private Double[] array = new Double[2]; // Valori predefiniti con un array di 2 elementi

    // Metodo per impostare le dimensioni salvate
    public void setArray(Double[] array) {
        this.array = array;
    }

    // Metodo per ottenere le dimensioni salvate
    public Double[] getArray() {
        return array;
    }
}
