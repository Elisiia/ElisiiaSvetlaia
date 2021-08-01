package hw3;
import org.testng.annotations.DataProvider;

public class Test4TextImages {
    @DataProvider(name="urlAndTexts")
        public Object[][] dpMethod(){
            return new Object[][] {
                    {"/html/body/div/div[2]/main/div[2]/div[2]/div[1]/div/span","To include good practices\nand ideas from successful\nEPAM project"},
                    {"/html/body/div/div[2]/main/div[2]/div[2]/div[2]/div/span", "To be flexible and\ncustomizable"},
                    {"/html/body/div/div[2]/main/div[2]/div[2]/div[3]/div/span", "To be multiplatform"},
                    {"/html/body/div/div[2]/main/div[2]/div[2]/div[4]/div/span", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
            };
        }

}
