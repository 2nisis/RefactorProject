package incometaxcalculator.data.management;

import java.util.ArrayList;
import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);
  
  public abstract double getValue(int x , int y);
  /*private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;*/
  
  public double calculateBasicTax() {
    if (income < this.getValue( 0 , 2 )) {
      return 0.0535 * income;
    } else if (income <  this.getValue( 1 , 2 )) {
      return this.getValue( 0 , 0 ) + this.getValue( 0 , 1 )* (income - this.getValue( 0 , 2 ));
    } else if (income < this.getValue( 2 , 2 )) {
      return  this.getValue( 1 , 0 ) + this.getValue( 1 , 1 ) * (income - this.getValue( 1 , 2 ));
    } else if (income < this.getValue( 3 , 2 )) {
      return  this.getValue( 2 , 0 ) + this.getValue( 2 , 1 ) * (income - this.getValue( 2 , 2 ));
    } else {
      return this.getValue( 3 , 0 ) + this.getValue( 3 , 1 ) * (income - this.getValue( 3 , 2 ));
    }
  }

  public Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }
  
  

  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
        
    
    String[] listOfKinds = {"Entertainment" , "Basic" , "Travel" , "Health" , "Other"};
        
        for (int index = 0 ; index <=4 ; index++) {
          if(listOfKinds[index].equals(receipt.getKind())) {
            amountPerReceiptsKind[index] += receipt.getAmount();
            receiptHashMap.put(receipt.getId(), receipt);
            totalReceiptsGathered++;
            return;
          }
        }
        throw new WrongReceiptKindException();
       
    
 }

  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    
    Receipt receipt = receiptHashMap.get(receiptId);
    
    String[] listOfKinds = {"Entertainment" , "Basic" , "Travel" , "Health" , "Other"};
    
    for (int index = 0 ; index <=4 ; index++) {
      if(listOfKinds[index].equals(receipt.getKind())) {
        amountPerReceiptsKind[index] -= receipt.getAmount();
        totalReceiptsGathered--;
        receiptHashMap.remove(receiptId);
        return;
      }
    }
    throw new WrongReceiptKindException();
    
    
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getTotalAmountOfReceipts();
    
    double[] listOfPercentages = {0.2 , 0.4 , 0.6 };
    double[] listOfWeights = {0.08 , 0.04 , -0.15 };
    for (int index = 0 ; index >=2 ; index++) {
      if(totalAmountOfReceipts < listOfPercentages[index] ) {
        return calculateBasicTax() *listOfWeights[index];    
      }
    } 
    return -calculateBasicTax() * 0.3;
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() { 
    return calculateBasicTax();
  }

}