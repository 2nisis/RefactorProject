package incometaxcalculator.data.management;

import java.util.ArrayList;

public class HeadOfHouseholdTaxpayer extends Taxpayer {
  
  private  ArrayList<Double>[] incomeCategory;
  

  public HeadOfHouseholdTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    incomeCategory = new ArrayList[4];
    initializeIncomeCategory();
  }
  
  private void initializeIncomeCategory() {
    
    incomeCategory[0] = new ArrayList<>();
    incomeCategory[0].add(1625.87);
    incomeCategory[0].add(0.0705);
    incomeCategory[0].add((double) 30390);
    incomeCategory[1] = new ArrayList<>();
    incomeCategory[1].add(5828.38);
    incomeCategory[1].add( 0.0705);
    incomeCategory[1].add((double) 90000);
    incomeCategory[2] = new ArrayList<>();
    incomeCategory[2].add(8092.13 );
    incomeCategory[2].add(0.0785);
    incomeCategory[2].add((double) 122110);
    incomeCategory[3] = new ArrayList<>();
    incomeCategory[3].add(14472.61);
    incomeCategory[3].add( 0.0985);
    incomeCategory[3].add((double) 203390);
  }
  public double getValue(int x , int y){
    
    return incomeCategory[x].get(y);
    
  }

}
