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
   

    @Test
    public void same_day() {
        
        //Create test
        int numDays = Cal.cal(1,1,1,1,1999);
        
        assertTrue(numDays==0);
   }
    
    
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
    
    
    
    //Exception Tests. They won't actually throw an exception so we'll just test the intended behavior
    @Test
    public void bad_month1() {
        
        //Create test
        int numDays = Cal.cal(13,1,12,20,1999);
        System.out.println("badmonth1 is :" + numDays);
        
        assertTrue(numDays==2);
   }
    
    @Test
    public void bad_day1() {
        
        //Create test
        int numDays = Cal.cal(1,32,12,20,1999);
        System.out.println("badday1 is :" + numDays);
        
        assertTrue(numDays==2);
   }
    
        
    @Test
    public void bad_month2() {
        
        //Create test
        int numDays = Cal.cal(1,1,13,20,1999);
        System.out.println("badmonth2 is :" + numDays);
        
        assertTrue(numDays==2);
   }
    
        //Exception Tests
    @Test
    public void bad_day2() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,32,1999);
        System.out.println("badday2 is :" + numDays);
        
        assertTrue(numDays==2);
   }
    
            //Exception Tests
    @Test
    public void bad_year() {
        
        //Create test
        int numDays = Cal.cal(1,1,12,20,-1999);
        System.out.println("badyear is :" + numDays);
        
        assertTrue(numDays==2);
   }
    
}