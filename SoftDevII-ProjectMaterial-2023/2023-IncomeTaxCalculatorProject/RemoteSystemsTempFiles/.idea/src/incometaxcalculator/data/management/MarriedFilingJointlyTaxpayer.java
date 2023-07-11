package incometaxcalculator.data.management;

import java.util.ArrayList;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {
  
  private ArrayList<Double>[] incomeCategory;
  
  

  public MarriedFilingJointlyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    incomeCategory = new ArrayList[4];
    initializeIncomeCategory();
  }
  
  private void initializeIncomeCategory() {
    
    
    incomeCategory[0] = new ArrayList<>();
    incomeCategory[0].add(1930.28);
    incomeCategory[0].add( 0.0705);
    incomeCategory[0].add((double) 36080);
    incomeCategory[1] = new ArrayList<>();
    incomeCategory[1].add(5731.64);
    incomeCategory[1].add( 0.0705);
    incomeCategory[1].add((double) 90000);
    incomeCategory[2] = new ArrayList<>();
    incomeCategory[2].add(9492.82 );
    incomeCategory[2].add( 0.0785);
    incomeCategory[2].add((double) 143350);
    incomeCategory[3] = new ArrayList<>();
    incomeCategory[3].add(18197.69);
    incomeCategory[3].add( 0.0985);
    incomeCategory[3].add((double) 254240);
  }
  
  public double getValue(int x , int y){
    
    return incomeCategory[x].get(y);
    
  }
}