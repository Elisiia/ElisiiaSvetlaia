import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestSubtraction {
    Calculator calculator = new Calculator();
    @DataProvider (name = "data_provider")
    public Object[][] dpMethod(){
        return new Object[][] {{3.0, 5.0, -2.0}, {10.0, 6.0, 4.0},
                {5.5, 6.5, -1.0}, {-100, -100, 0}};
    }

    @Test (dataProvider = "data_provider")
    public void testSubtraction (double val1, double val2, double result) {
        Assert.assertEquals(calculator.sub(val1, val2), result);
    }
}