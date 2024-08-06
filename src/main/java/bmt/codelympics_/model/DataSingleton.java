package bmt.codelympics_.model;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;

public class DataSingleton {

    private static final DataSingleton instance= new DataSingleton();
    private boolean[] arrayRisposte = new boolean[5];
    private int value = 0;
    private int numEsercizio;
    private int numMacroEsercizio;
    private String[] arrayUtente=new String[12];

    private DataSingleton (){}

    public static DataSingleton getInstance(){
        return instance;
    }

    public int getnumMacroEsercizio(){
        return numMacroEsercizio;
    }

    public void setNumMacroEsercizio(int numMacroEsercizio) {
        this.numMacroEsercizio = numMacroEsercizio;
    }

    public int getNumEsercizio(){
        return numEsercizio;
    }
    public void setNumEsercizio(int numEsercizio){
        this.numEsercizio=numEsercizio;
    }

    public boolean[] getArrayRisposte() {
        return arrayRisposte;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addarrayDirisposte(boolean rispostaMicroEsercizi){
        arrayRisposte[value]=rispostaMicroEsercizi;
        value++;
    }

    public String[] getArrayUtente() {
        return arrayUtente;
    }

    public void setArrayUtente(String[] arrayUtente) {
        this.arrayUtente = arrayUtente;
    }
    //trova l'esercizio con la difficoltà giusta e lo cambia nel csv (solo se ci sono miglioramenti)

    private int stringaMedaglie=0;
    private int dificolta=0;

    public void scriviPunteggioeMedagliaEserczio()throws Exception{
        char tipoEsercizo = Integer.toString(numMacroEsercizio).charAt(0);
        char difficoltaEsercizio = Integer.toString(numMacroEsercizio).charAt(1);

        stringaMedaglie+=2;
        int stringaPunti=stringaMedaglie+1;

        String medaglie = arrayUtente[stringaMedaglie];
        String  medagliaSpecifica = medaglie.split("\\.")[dificolta];

        System.out.println(medagliaSpecifica);

        String punti =arrayUtente[stringaPunti];
        String puntiSpecifico = punti.split("\\.")[dificolta];

        System.out.println(puntiSpecifico);

        //calcola punteggio
        int temp=0;
        for(boolean e:arrayRisposte) temp+=200;/*aggiungere se si vuole variabile tempo*/

        //calcola le medaglie


        //trova il punto da modificare e modifica

        String filePath = "C:\\playproj\\props.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            BufferedWriter writer =new BufferedWriter(new FileWriter(filePath, true);
            String[] line;
            while ((line = reader.readNext()) != null) {
                if(line[0].equals(arrayUtente[0])){
                    
                    for(String a: line) System.out.print(a+" ");
                }


            }


        } catch (FileNotFoundException e) {
            throw new IOException("File CSV non trovato: " + filePath);
        }





    }



    public boolean risposta(int numMacroEsercizio, int numEsercizio, int[] risp){

        switch (numMacroEsercizio){
            //sollevamento pesi risposta multipla
            case 11:
                stringaMedaglie=1;dificolta=0;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 12:
                stringaMedaglie=1;dificolta=1;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 13:
                stringaMedaglie=1;dificolta=2;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
                //box vero o falso
            case 21:
                stringaMedaglie=2;dificolta=0;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==1) return true;
                        break;
                    case 4:
                        if(risp[0]==2) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 22:
                stringaMedaglie=2;dificolta=1;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==2) return true;
                        break;
                    case 4:
                        if(risp[0]==1) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 23:
                stringaMedaglie=2;dificolta=2;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==2) return true;
                        break;
                    case 4:
                        if(risp[0]==1) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
                //scherma trova l'errore
            case 31:
                stringaMedaglie=3;dificolta=0;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 32:
                stringaMedaglie=3;dificolta=1;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
            case 33:
                stringaMedaglie=3;dificolta=2;
                switch (numEsercizio){
                    case 1:
                        if(risp[0]==1) return true;
                        break;
                    case 2:
                        if(risp[0]==2) return true;
                        break;
                    case 3:
                        if(risp[0]==3) return true;
                        break;
                    case 4:
                        if(risp[0]==4) return true;
                        break;
                    case 5:
                        if(risp[0]==1) return true;
                        break;
                }
                break;
                //Tiro con l'arco riordinamento
            case 41:
                stringaMedaglie=4;dificolta=0;
                switch (numEsercizio){
                    case 1:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 2:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 3:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 4:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 5:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                }
                break;
            case 42:
                stringaMedaglie=4;dificolta=1;
                switch (numEsercizio){
                    case 1:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 2:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 3:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 4:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 5:
                        if(Arrays.equals(risp, new int[]{1,2,3,4,5,6})) return true;
                        break;
                }
                break;
            case 43:
                stringaMedaglie=4;dificolta=2;
                switch (numEsercizio){
                    case 1:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 2:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 3:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 4:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                    case 5:
                        if(Arrays.equals(risp, new int[]{1, 2, 3,4,5,6})) return true;
                        break;
                }
                break;

        }
        return false;
    }

}
