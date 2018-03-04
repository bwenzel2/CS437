import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;
import static org.junit.Assume.*;

public class TDD_Tests {
    
   
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TDD_Tests");
    }
    
    //==============
    // Quote Tests
    //==============

    @Test
    public void quote_setTag() {
        Quote q = new Quote();
        q.setTag("round");
        assertEquals("Expected:", "round", q.getTag());
    }
    
    
    
}
