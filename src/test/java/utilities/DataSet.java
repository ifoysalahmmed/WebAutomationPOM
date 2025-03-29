package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData () {
        return new Object[][]{
                {"", "shobuj123", "", "Please fill out this field.", ""},
                {"shobuj@yopmail.com", "", "", "", "Please fill out this field.",},
                {"", "", "", "Please fill out this field.", "Please fill out this field."},
                {"shobuj@yop", "suj122", "Your email or password is incorrect!", "", ""}
        };
    }
}