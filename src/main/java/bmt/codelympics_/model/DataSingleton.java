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

    private int stringaMedaglia=0;
   

    public void scriviPunteggioeMedagliaEserczio()throws Exception{
        //char tipoEsercizo = Integer.toString(numMacroEsercizio).charAt(0);
        //char difficoltaEsercizio = Integer.toString(numMacroEsercizio).charAt(1);

        
        int stringaPunti=stringaMedaglia+3;

        

        System.out.println(arrayUtente[stringaMedaglia]);

        System.out.println(arrayUtente[stringaPunti]);

        //calcola le medaglie
        int tempMed=0;
        for(boolean e:arrayRisposte) tempMed++;
        arrayUtente[stringaMedaglia]=Integer.toString(tempMed);

        //calcola punteggio
        int tempPunt=0;
        for(boolean e:arrayRisposte) tempPunt+=200;/*aggiungere se si vuole variabile tempo*/
        arrayUtente[stringaPunti]=Integer.toString(tempPunt);
        

        //crea un secondo file csv per salvare le modifiche
        String filePath2 = "C:\\playproj\\props2.csv";
        String filePath = "C:\\playproj\\props.csv";

        File file2 = new File(filePath2);
        if (!file2.exists()) {
            try (FileWriter writer = new FileWriter(file2)) {
                try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                    String[] line;
                    while ((line = reader.readNext()) != null) {
                        if(line[0].equals(arrayUtente[0])){
                            writer.append(arrayUtente.toString());
                        }else{
                        writer.append(line.toString());
                        }



                    }


                } catch (FileNotFoundException e) {
                    throw new IOException("File CSV non trovato: " + filePath);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // modifica csv sovrascrivendo

        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                try (CSVReader reader = new CSVReader(new FileReader(filePath2))) {
                    String[] line;
                    while ((line = reader.readNext()) != null) {
                        
                        writer.append(line.toString());
                        
                    }

                } catch (FileNotFoundException e) {
                    throw new IOException("File CSV non trovato: " + filePath);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }



    public boolean risposta(int numMacroEsercizio, int numEsercizio, int[] risp){

        switch (numMacroEsercizio){
            //sollevamento pesi risposta multipla
            case 11:
                stringaMedaglia=4;
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
                stringaMedaglia=5;
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
                stringaMedaglia=6;
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
                stringaMedaglia=10;
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
                stringaMedaglia=11;
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
                stringaMedaglia=12;
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
                stringaMedaglia=16;
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
                stringaMedaglia=17;
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
                stringaMedaglia=18;
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
                stringaMedaglia=22;
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
                stringaMedaglia=23;
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
                stringaMedaglia=24;
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
