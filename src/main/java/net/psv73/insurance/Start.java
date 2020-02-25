package net.psv73.insurance;

import net.psv73.insurance.dao.InsuranceDAO;
import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.model.Person;
import net.psv73.insurance.model.Plan;
import net.psv73.insurance.model.Type;

import java.time.LocalDate;

public class Start {

    public static void main(String[] args) {

        Insurance insurance = new Insurance("Boris", Type.YEAR, LocalDate.now(), LocalDate.now().plusMonths(2), Plan.EXTENDED, Person.THREE, (float) 589.30);

        for( int i = 0; i <= 100; i++ ) {
            InsuranceDAO.addInsurance(insurance);
        }

        System.out.println("Insurance: " + insurance);
    }
}
