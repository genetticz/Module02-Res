package accounts;

import java.io.IOException;
import java.sql.SQLException;

public class App {

    /**
     * @author Jahidul Islam
     * Use methods from the SalaryCalculator class to calculate salary of an employee
     *
     * */

    public static void main(String[] args) throws IOException, SQLException {
        // Implement here

        SalaryCalulator s1 = new SalaryCalulator();
        s1.yearCalculator("employees","hourlyrate","first_name","last_name","Renaldo","Lundstrom");

    }
}
