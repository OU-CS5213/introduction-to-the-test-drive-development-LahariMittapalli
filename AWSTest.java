import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AWSTest {

	private static final int FILLER_VALUE = Integer.MIN_VALUE;
	private int[] original={1, 2, 3};
	AWS originalAWS;
	
	@BeforeEach
	void setUp() throws Exception {
		 originalAWS = new AWS(this.original);
	}

	@Test
	void testGetValues() {
                int[] x= {1,2,3};
		AWS aws=new AWS(x);
		int[] result=aws.getValues();
		assertEquals(result[0], x[0]);
                //fail("Not yet implemented");
	}

	@Test
	void testSetValues() {
                int x[] = {1,2,3};
		int y[]= {4,5,6};
		AWS aws=new AWS(x);
		aws.setValues(y);
		int[] result=aws.getValues();
		assertEquals(result[0], y[0]);
		assertEquals(result[2], y[2]);
		assertEquals(result.length, y.length);
                //fail("Not yet implemented");
	}

	@Test
	void testToString(){
                int[] x={1,2,3};
                AWS aws=new AWS(x);
		String expected = "AWS [values=[1,2,3]]";
		String result= aws.toString();
		assertEquals(result,expected);
                //fail("Not yet implemented");
	}

	@Test
	void testAWS() {
		int[] expected = {1, 2, 3};
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		x[1] = 100;
		
		int[] actual = aws.getValues();
		assertEquals(actual[0], expected[0]);
		assertEquals(actual[1], expected[1]);
	}
	
	@Test
	void testRemove() {
		int[] x = {1, 2, 3};
		AWS aws = new AWS(x);
		
		int value = aws.remove(-1);
		int expected = FILLER_VALUE;
		assertEquals(expected, value);
		
		 value = aws.remove(x.length + 10);
		expected = FILLER_VALUE;
		assertEquals(expected, value);
		
		value = aws.remove(0);
		assertEquals(x[0], value);
		
		int[] r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
		value = aws.remove(2);
		assertEquals(r[2], value);
		
		r = aws.getValues();
		value = r[r.length - 1];
		assertEquals(expected, value);
		
	}
	
	@Test
	void testFillAndExpand() {
		int position = 1;
		int numberOfTimes = 2;
		int[] org = originalAWS.getValues();
		int expectedValue = org[position];
		int first = org[0];
 		
		int expected = originalAWS.getValues().length + numberOfTimes;
		originalAWS.fillAndExpand(position, numberOfTimes);
		int[] result = originalAWS.getValues();
		assertEquals(expected, result.length);
		
		int a = result[1];
		int b = result[2];
		int c = result[3];
		assertEquals(expectedValue, a);
		assertEquals(expectedValue, b);
		assertEquals(expectedValue, c);
		assertEquals(first, result[0]);
		 
		
	
	}
	@Test
	void testFillAndExpandWithNegative() {
		int position = 1;
		int numberOfTimes = -2;
		
		int[] org = originalAWS.getValues();
		int expectedValue = org[position];
 		int first = org[0];
		int expected = originalAWS.getValues().length + Math.abs(numberOfTimes);
		originalAWS.fillAndExpand(position, numberOfTimes);
		int[] result = originalAWS.getValues();
		assertEquals(expected, result.length);
		
		int a = result[1];
		int b = result[2];
		int c = result[3];
		assertEquals(expectedValue, a);
		assertEquals(expectedValue, b);
		assertEquals(expectedValue, c);
		 
		assertEquals(first, result[0]);

	
	}
	@Test
        void testMultiplication() {
		int[] x= {3,15};
		AWS aws=new AWS(x);
		int expected=3*4;
		
		aws.multiplication();
		int[] result= aws.getValues();
		assertEquals(expected, result[0]);
	}
        @Test
	void testremoveBiggerThan() {
		int threshold =2;
		int[] org = originalAWS.getValues();
		int expCount = 1;
		int expected = FILLER_VALUE;
		
		int resCount= originalAWS.removeBiggerThan(threshold);
		
		int[] resValues= originalAWS.getValues();
		
		assertEquals(expCount, resCount);
		assertEquals(expected, resValues[2]);
		
		
  
	}
        @Test
	void teststepMultiplier() {
		int[] x= {3,17,50};
		AWS aws = new AWS(x);
		int exp1 = 3*2;
		int exp2 = 17*4;
		int exp3 = 50*100;
		
		aws.stepMultiplier();
		int[] result = aws.getValues();
		assertEquals(exp1, result[0]);
		assertEquals(exp2, result[1]);
		assertEquals(exp3, result[2]);
	}



}
