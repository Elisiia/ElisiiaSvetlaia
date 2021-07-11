import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAdd {
    Calculator calculator = new Calculator();
    @DataProvider (name = "data_provider")
    public Object[][] dpMethod(){
        return new Object[][] {{3.0, 5.0, 8.0}, {4.0, 6.0, 10.0},
                {5.5, 5.5, 11.0}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
    }

    @Test (dataProvider = "data_provider")
    public void testSum (double val1, double val2, double result) {
        Assert.assertEquals(calculator.sum(val1, val2), result);
    }

}
