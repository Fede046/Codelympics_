package bmt.codelympics_.model;

public class User {

        DataSingleton data = DataSingleton.getInstance();

        public User(){}

        public String getNome(){
            return data.getArrayUtente()[0];
        }

        public String getPassword(){
            return data.getArrayUtente()[1];
        }

        public String getColore(){
            return data.getArrayUtente()[2];
        }

    



}
