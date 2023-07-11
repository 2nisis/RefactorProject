package incometaxcalculator.data.management;

import java.util.ArrayList;

public class SingleTaxpayer extends Taxpayer {
  
  private  ArrayList<Double>[] incomeCategory;
  

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    incomeCategory = new ArrayList[4];
    initializeIncomeCategory();
    
  }
  
  private void initializeIncomeCategory() {
    
    incomeCategory[0] = new ArrayList<>();
    incomeCategory[0].add(1320.38);
    incomeCategory[0].add(0.0705);
    incomeCategory[0].add((double) 24680);
    incomeCategory[1] = new ArrayList<>();
    incomeCategory[1].add(5296.58);
    incomeCategory[1].add(0.0785);
    incomeCategory[1].add((double) 81080);
    incomeCategory[2] = new ArrayList<>();
    incomeCategory[2].add(5996.80);
    incomeCategory[2].add(0.0785);
    incomeCategory[2].add((double) 90000);
    incomeCategory[3] = new ArrayList<>();
    incomeCategory[3].add(10906.19);
    incomeCategory[3].add( 0.0985);
    incomeCategory[3].add((double) 152540);
  }
  public double getValue(int x , int y){
    
    return incomeCategory[x].get(y);
    
  }
}
