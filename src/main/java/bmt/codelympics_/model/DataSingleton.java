package bmt.codelympics_.model;






public class DataSingleton {

    private static final DataSingleton instance = new DataSingleton();
    private boolean[] arrayRisposte = new boolean[5];
    private int value = 0;
    private int numEsercizio;

    private String[] arrayUtente = new String[12];
    DataSingleton data = DataSingleton.getInstance();


    private DataSingleton() {
    }

    public static DataSingleton getInstance() {
        return instance;
    }

    public int getNumEsercizio() {
        return numEsercizio;
    }

    public void setNumEsercizio(int numEsercizio) {
        this.numEsercizio = numEsercizio;
    }

    public boolean[] getArrayRisposte() {
        return arrayRisposte;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addarrayDirisposte(boolean rispostaMicroEsercizi) {
        arrayRisposte[value] = rispostaMicroEsercizi;
        value++;
    }

    public String[] getArrayUtente() {
        return arrayUtente;
    }

    public void setArrayUtente(String[] arrayUtente) {
        this.arrayUtente = arrayUtente;
    }

    // trova l'esercizio con la difficoltà giusta e lo cambia nel csv (solo se ci
    // sono miglioramenti)

    private int stringaMedaglia = 0;

    public int getStringaMedaglia() {
        return stringaMedaglia;
    }

    public void setStringaMedaglia(int stringaMedaglia) {
        this.stringaMedaglia = stringaMedaglia;
    }
    
}