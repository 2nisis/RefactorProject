package incometaxcalculator.data.management;

import java.util.ArrayList;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {
  
  private  ArrayList<Double>[] incomeCategory;
  

  public MarriedFilingSeparatelyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    incomeCategory = new ArrayList[4];
    initializeIncomeCategory();
  }
  
  private void initializeIncomeCategory() {

    incomeCategory[0] = new ArrayList<>();
    incomeCategory[0].add(965.14);
    incomeCategory[0].add( 0.07055);
    incomeCategory[0].add((double) 18040);
    incomeCategory[1] = new ArrayList<>();
    incomeCategory[1].add(4746.76);
    incomeCategory[1].add( 0.0785 );
    incomeCategory[1].add((double) 71680);
    incomeCategory[2] = new ArrayList<>();
    incomeCategory[2].add( 6184.88 );
    incomeCategory[2].add( 0.0785 );
    incomeCategory[2].add((double) 90000);
    incomeCategory[3] = new ArrayList<>();
    incomeCategory[3].add(9098.80);
    incomeCategory[3].add( 0.0985);
    incomeCategory[3].add((double) 127120);
  }

  public double getValue(int x , int y){
    
    return incomeCategory[x].get(y);
    
  }
}