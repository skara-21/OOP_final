package webhelper;

import java.util.HashMap;
import java.util.Map;

public class accountManager {
    private Map<String,String> accountPass;
    public accountManager(){
        accountPass=new HashMap<String,String>();
        accountPass.put("Patrick","1234");
        accountPass.put("Molly","FloPup");
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
}
