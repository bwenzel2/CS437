import static org.junit.Assert.*;
import org.junit.Test;
public class CalTests {
	
	//================
	//  PREDICATE 1
	//================
		
	//Predicate 1, row 1
	// T
	@Test
	public void testPredicate1()
	{
		int day1 = 5;
		int day2 = 30;
		int month1 = 1;
		int month2 = 1;
		int result = Cal.cal(month1, day1, month2, day2, 1999);
		
		assertTrue(day2-day1 == result);   
	 }
	
	//Predicate 1, row 2
	// F
	@Test
	public void testPredicate1_2()
	{
		int day1 = 1;
		int day2 = 5;
		int month1 = 1;
		int month2 = 3;
		int result = Cal.cal(month1, day1, month2, day2, 1999);
		
		assertFalse(day2-day1 == result);   
	}
	
	
	//================
	//  PREDICATE 2
	//================
	
	//Predicate 2, row 2, TFT
	//a = T
	//b = F
	//c = T
	@Test
	public void testPredicate2_a1()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 2001;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 3, TTF
	//a = T
	//b = T
	//c = F
	// THIS IS INFEASIBLE, any multiple of 100 is necessary a multiple of 4, so you cannot have a = T and b = T at the same time
	
	//Predicate 2, row 4, TFF
	//a = T
	//b = F
	//c = F
	// THIS IS INFEASIBLE, you can't have b = F and c = F, because you would need a number that is a multiple of 400 but not of 100, which is impossible
	
	//Predicate 2, row 6, FTF
	//a = F
	//b = T
	//c = F
	@Test
	public void testPredicate2_a4()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1900;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 7, FFT
	//a = F
	//b = F
	//c = T
	@Test
	public void testPredicate2_a5()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1903;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 8, FFF
	//a = F
	//b = F
	//c = F
	//INFEASIBLE, because there is no combination that is evenly divisible by 100 but not by 4, because 4 is a factor of 100
	
	//Predicate 2, row 5, FTT
	//a = F
	//b = T
	//c = T
	@Test
	public void testPredicate2_b1()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1500;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 7, FTT
	//a = F
	//b = F
	//c = T
	@Test
	public void testPredicate2_b2()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1903;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 5, FTT
	//a = F
	//b = T
	//c = T
	@Test
	public void testPredicate2_c1()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1500;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//Predicate 2, row 6, FTF
	//a = F
	//b = T
	//c = F
	@Test
	public void testPredicate2_c2()
	{
		int day1 = 1;
		int day2 = 1;
		int month1 = 2;
		int month2 = 3;
		int year = 1900;
		int result = Cal.cal(month1, day1, month2, day2, year);
		assertTrue(28 == result);   
	}
	
	//================
	//  PREDICATE 3
	//================
		
	//Predicate 3, row 1, T
	//a = T	
	@Test
	public void testPredicate3_1()
	{
		int day1 = 1;
		int day2 = 1;
		//two months apart
		int month1 = 2;
		int month2 = 4;
		int result = Cal.cal(month1, day1, month2, day2, 1998);
		
		assertTrue(59 == result);   
	 }
	
	//Predicate 3, row 2, F
	//a = F
	@Test
	public void testPredicate3_2()
	{
		int day1 = 1;
		int day2 = 1;
		//one month apart
		int month1 = 2;
		int month2 = 3;
		int result = Cal.cal(month1, day1, month2, day2, 1998);
		
		assertFalse(29 == result);   
	}
}
