package calculations;

import exceptions.InvalidCoverTypeException;
import models.InsuranceTypeModel;
import models.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class CoverTypeCalculations implements CalculationsInterface {

    public double calculate(PersonModel person, double quote) throws InvalidCoverTypeException {
        String coverType = person.getInsuranceType();
        List<InsuranceTypeModel> typeModels = new ArrayList<>();
        typeModels.add(new InsuranceTypeModel("Comprehensive", 40));
        typeModels.add(new InsuranceTypeModel("Third Party & Fire", 10));
        typeModels.add(new InsuranceTypeModel("Third Party", -10));

        for (InsuranceTypeModel type : typeModels) {
            if (type.getInsuranceType().equals(coverType)) {
                quote += type.coverTypeIncrease(quote);
                return quote;
            }
        }
        throw new InvalidCoverTypeException(coverType);
    }
}
