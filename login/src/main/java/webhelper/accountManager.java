package webhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class accountManager {
    private Map<String,String> accountPass;
    private user currUser;
    private userDatabase db;

    public accountManager(){

    }

    private void createAcc(String name, int ID, String pass){
        currUser = new user(name, ID);
        if(accountPass.containsKey(name)){
            return;
        }
        db.addUser(name, pass);
    }
    public user getCurrUser(){
        return currUser;
    }
    public ArrayList<quiz> newsFeedCreated(){
        return currUser.getFeedInfoCreated();
    }
    public ArrayList<quiz> newsFeedTaken(){return currUser.getFeedInfoTaken(); }

    public boolean accountExists(String name){
        return accountPass.containsKey(name);
    }
    public boolean correctCredentials(String name,String Pass){
        return accountPass.containsKey(name) && (accountPass.get(name).equals(Pass));
    }
    public void createAcc(String name,String Pass){
        accountPass.put(name,Pass);
    }
    public user searchAccountByName(String name){
        return db.searchAccontByName(name);
    }


}
