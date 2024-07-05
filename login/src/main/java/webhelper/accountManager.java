package webhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class accountManager {
    private Map<String,String> accountPass;
    private user currUser;

    public accountManager(){
        accountPass=new HashMap<String,String>();
        accountPass.put("Patrick","1234");
        accountPass.put("Molly","FloPup");
    }

    private void createAcc(String name, int ID, String pass){
        currUser = new user(name, ID);
        if(accountPass.containsKey(name)){
            return;
        }
        db.addUser(name, ID, pass);
    }
    public ArrayList<quiz> newsFeed(){
        return currUser.getFeedInfo();
    }

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
