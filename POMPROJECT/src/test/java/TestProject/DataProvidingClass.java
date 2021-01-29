package TestProject;

import org.testng.annotations.DataProvider;

public class DataProvidingClass {

    @DataProvider(name = "Yunus_Provider")
    public Object [][] signInData() {
        Object [][] yns = new Object [2][2];
        yns [0][0] = "standard_user"; yns [0][1] = "secret_sauce";
        yns [1][0] = "problem_user"; yns [1][1] = "secret_sauce";
        return yns;
    }


}
