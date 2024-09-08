package bmt.codelympics_.model;

// Classe Time che utilizza il pattern Singleton per gestire il tempo
public class Time {
    // Istanza statica di Time, unica per tutta l'applicazione
    private static final Time instance = new Time();

    // Variabili private per mantenere il tempo in ore, minuti e secondi
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    // Costruttore privato per evitare l'instanziazione diretta
    public Time() {
        // Costruttore vuoto per Singleton
    }

    // Metodo statico per ottenere l'unica istanza di Time
    public static Time getInstance() {
        return instance;
    }

    // Metodo per impostare l'ora corrente a partire da una stringa in formato "HH:mm:ss"
    public void setTime(String stringa){
        // Divide la stringa in ore, minuti e secondi usando ":" come delimitatore
        String[] time = stringa.split(":");
        this.hour = Integer.parseInt(time[0]);  // Converte la parte ore in intero
        this.minute = Integer.parseInt(time[1]); // Converte la parte minuti in intero
        this.second = Integer.parseInt(time[2]); // Converte la parte secondi in intero
    }

    // Metodo per ottenere l'ora corrente come stringa in formato "HH:mm:ss"
    public String getCurrentTime() {
        return hour + ":" + minute + ":" + second;
    }

    // Metodo per incrementare il tempo di un secondo e gestire il rollover di minuti e ore
    public void oneSecondPassed() {
        second++; // Incrementa i secondi
        if (second == 60) { // Se i secondi arrivano a 60, incrementa i minuti
            minute++;
            second = 0;
            if (minute == 60) { // Se i minuti arrivano a 60, incrementa le ore
                hour++;
                minute = 0;
                if (hour == 24) { // Se le ore arrivano a 24, resettale a 0 (nuovo giorno)
                    hour = 0;
                }
            }
        }
    }
}
