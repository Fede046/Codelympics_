package bmt.codelympics_.model;

import java.util.Arrays;

public class DataSingleton {

    private static final DataSingleton instance= new DataSingleton();

    private int numEsercizio;
    private int numMacroEsercizio;

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


    public int puntTotMicroEsercizi(boolean[] risposteMicroEsercizi){
        int tot=0;
        for(boolean e:risposteMicroEsercizi) if(e) tot++;
        return tot;
    }

    public boolean risposta(int numMacroEsercizio,int numEsercizio,int[] risp){

        switch (numMacroEsercizio){
            //sollevamento pesi risposta multipla
            case 11:
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
