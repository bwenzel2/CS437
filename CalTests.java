import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

public class CalTests {
    
    
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("CalTests");
    }
    
    
    /*
     public static int cal (int month1, int day1, int month2,
     int day2, int year)
     */
    
    
    //The actual tests for assignment 11.
    @Test
    public void same_month() {
        
        //Create test
        int numDays = Cal.cal(1,5,1,30,1999);
        
        assertTrue(numDays==25);
    }
    
    
    @Test
    public void different_month() {
        
        //Create test
        int numDays = Cal.cal(1,1,3,5,1999);
        
        assertTrue(numDays==63);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //NOT the actual tests.
    @Test
    public void different_month_leap() {
        
        //Create test
        int numDays = Cal.cal(1,1,3,5,2000);
        
        assertTrue(numDays==64);
    }
    
    @Test
    public void different_month_widespread() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,20,1999);
        
        assertTrue(numDays==353);
    }
    
    @Test
    public void different_month_widespread_leap() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,20,2000);
        
        assertTrue(numDays==354);
    }
    
    
    //Exception Tests. Only the first one will throw an exception. The rest will execute.
    
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void bad_month1() {
        
        //Create test
        int numDays = Cal.cal(13,1,12,20,1999);
        
        assertTrue(numDays==2);
    }
    
    @Test
    public void bad_day1() {
        
        //Create test
        int numDays = Cal.cal(1,32,12,20,1999);
        
        assertTrue(numDays==322);
    }
    
    
    @Test
    public void bad_month2() {
        
        //Create test
        int numDays = Cal.cal(1,1,13,20,1999);
        
        assertTrue(numDays==384);
    }
    
    //Exception Tests
    @Test
    public void bad_day2() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,32,1999);
        
        assertTrue(numDays==365);
    }
    
    //Exception Tests
    @Test
    public void bad_year() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,20,-1999);
        
        assertTrue(numDays==353);
    }
    
}
