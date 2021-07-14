import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestDivision {
    Calculator calculator = new Calculator();
    @DataProvider (name = "data_provider")
    public Object[][] dpMethod(){
        return new Object[][] {{10.0, 2.0, 5.0}, {-10.0, 2.0, -5.0},
                {5.0, 2.0, 2.5}, {3.0, 5.0, 0.6}};
    }

    @Test (dataProvider = "data_provider")
    public void testDivision (double val1, double val2, double result) {
        Assert.assertEquals(calculator.div(val1, val2), result);
    }
}