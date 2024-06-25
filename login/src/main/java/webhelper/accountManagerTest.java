package webhelper;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

//ver gavushvi es da wesit 100% covrage eqneba, rom/tu gaushvebt mec mitxarit rogor....
public class accountManagerTest {
    accountManager db=new accountManager();
    @Test
    public void initTest(){
        assertTrue(db.accountExists("Patrick"));
        assertTrue(db.accountExists("Molly"));
        assertFalse(db.correctCredentials("Patrick","123"));
        assertFalse(db.correctCredentials("Molly","Molly"));
        assertTrue(db.correctCredentials("Patrick","1234"));
        assertTrue(db.correctCredentials("Molly","FloPup"));
    }
    @Test
    public void insertTest(){
        String username="test";
        String pass="test123";
        db.createAcc(username,pass);
        assertTrue(db.accountExists(username));
        assertTrue(db.correctCredentials(username,pass));
        assertFalse(db.correctCredentials(pass,username));
    }
}
