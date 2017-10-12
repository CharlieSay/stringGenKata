import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class stringGenTesting {

    @Test
    public void testOne(){
        stringGen sg = new stringGen();
        assertEquals(0, sg.Add("0"));
    }

    @Test
    public void testOneNumber(){
        stringGen sg = new stringGen();
        assertEquals(1,sg.Add("1"));
    }

    @Test
    public void testAskHowMany(){
        stringGen sg = new stringGen();
        assertEquals(0, sg.Add("0"));
        assertEquals(1, sg.Add("1"));
        assertEquals(3, sg.Add("1,2"));
    }

    @Test
    public void testAskHow111Many(){
        stringGen sg = new stringGen();
        assertEquals(3, sg.Add(",1,2"));
    }

    @Test
    public void test10(){
        stringGen sg = new stringGen();
        assertEquals(10, sg.Add("1,2,3,4"));
    }

    @Test
    public void test20(){
        stringGen sg = new stringGen();
        assertEquals(20, sg.Add("1,5,8,6"));
    }

    @Test
    public void test20ee(){
        stringGen sg = new stringGen();
        assertEquals(20, sg.Add("1/n,5,8,6"));
    }

    @Test
    public void testDiffSplit(){
        stringGen sg = new stringGen();
        assertEquals(50, sg.Add("3/n3,8,/n4/n,10,20,2"));
    }

    @Test
    public void testDelimters(){
        stringGen sg = new stringGen();
        assertEquals(3, sg.Add("//;\n1;2"));
    }

    @Test
    public void testOneNegativeNumberReturnRuntimeException(){
        stringGen sg = new stringGen();
        try {
            sg.Add("2,-4,3,1,5,1");
        }
        catch (RuntimeException e) {
            assertEquals("negatives not allowed: [-4]", e.getMessage());
        }
    }

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        stringGen sg = new stringGen();

        try {
            sg.Add("2,-4,3,-5,-11,-5,-4,7,1,5");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed: [-4, -5, -11, -5, -4]", e.getMessage());
        }

    }

    @Test
    public void test1000and2SumToIgnore1000(){
        stringGen sg = new stringGen();
        assertEquals(2, sg.Add("1000,2"));
    }

    @Test
    public void DelimtersTestwithStarsToReturn6(){
        stringGen sg = new stringGen();
        assertEquals(6, sg.Add("//[***]\n1***2***3"));
    }
    @Test
    public void multipleDelimtersTest(){
        stringGen sg = new stringGen();
        assertEquals(6, sg.Add("//[*][%]\\n1*2%3"));
    }
}
