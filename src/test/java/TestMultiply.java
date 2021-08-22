import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestMultiply {
    Calculator calculator = new Calculator();
    @DataProvider (name = "data_provider")
    public Object[][] dpMethod(){
        return new Object[][] {{10.0, 2.0, 20.0}, {-10.0, 2.0, -20.0},
                {-5.0, -2.0, 10.0}, {0.5, 0.5, 0.25}};
    }

    @Test (dataProvider = "data_provider")
    public void testMultiplication (double val1, double val2, double result) {
        Assert.assertEquals(calculator.mult(val1, val2), result);
    }
}
//Ха-ха, он ошибается в делении дробных чисел
