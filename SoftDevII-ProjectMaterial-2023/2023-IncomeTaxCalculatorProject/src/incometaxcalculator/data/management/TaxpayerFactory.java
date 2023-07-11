package incometaxcalculator.data.management;

import incometaxcalculator.exceptions.WrongTaxpayerStatusException;
//https://www.oreilly.com/library/view/head-first-design/0596007124/ch04.html
public class TaxpayerFactory {
  
  public Taxpayer generateTaxpayer(String fullname, int taxRegistrationNumber, String status, float income) throws WrongTaxpayerStatusException {
    if (status.equals("Married Filing Jointly")) {
     
          return new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income);
    } else if (status.equals("Married Filing Separately")) {
      
        return new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income);
    } else if (status.equals("Single")) {
      
        return new SingleTaxpayer(fullname, taxRegistrationNumber, income);
    } else if (status.equals("Head of Household")) {
      
        return new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income);
    } else {
      throw new WrongTaxpayerStatusException();
    }
  }

}
