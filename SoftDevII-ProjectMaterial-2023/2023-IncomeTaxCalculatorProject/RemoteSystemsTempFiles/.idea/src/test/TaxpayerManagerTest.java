package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

class TaxpayerManagerTest {

  
  
  @Test
  public void createTaxpayerTest() throws WrongTaxpayerStatusException {
   
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    assertTrue(Manager1.containsTaxpayer(111111111));
  }
  
  @Test
  public void getTaxpayerNameTest() throws WrongTaxpayerStatusException {
   
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
   
    assertTrue(Manager1.getTaxpayerName(111111111).equals("dionisis kaisaris"));
  }
  
  @Test
  public void getTaxpayerStatusTest() throws WrongTaxpayerStatusException {
   
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
   
    assertTrue(Manager1.getTaxpayerStatus(111111111).equals("Married Filing Jointly"));
  }
  
  @Test
  public void containsTaxpayerTest() throws WrongTaxpayerStatusException{
   
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    
    assertTrue(Manager1.containsTaxpayer(111111111));
    assertTrue(Manager1.containsTaxpayer());
  }
  
  @Test
  public void removeTaxpayerTest() throws WrongTaxpayerStatusException{
   
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    

    assertTrue(Manager1.containsTaxpayer(111111111));
    Manager1.removeTaxpayer(111111111);
    assertFalse(Manager1.containsTaxpayer(111111111));
    
  }
  
  @Test
  public void addReceiptTest() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    
    Manager1.addReceipt(1010, "25/2/2014" , 2000, "Basic", "String Hand Made Clothes", "Greece", "Ioannina", "Kaloudi",10, 111111111);
    assertTrue(Manager1.containsReceipt(1010));
  }
  
  @Test
  public void removeReceiptTest() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    
    Manager1.addReceipt(10, "25/2/2014" , 2000, "Basic", "String Hand Made Clothes", "Greece", "Ioannina", "Kaloudi",10, 111111111);
    assertTrue(Manager1.containsReceipt(10));
    
    Manager1.removeReceipt(10);
    assertFalse(Manager1.containsReceipt(10));
  }
 

  @Test
  public void saveLogFileTest() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException, WrongFileFormatException {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.createTaxpayer("dionisis kaisaris",111111111, "Married Filing Jointly", 22570);
    
    Manager1.addReceipt(11, "25/2/2014" , 2000, "Basic", "String Hand Made Clothes", "Greece", "Ioannina", "Kaloudi",10, 111111111);
    assertTrue(Manager1.containsReceipt(11));
    
    Manager1.saveLogFile(111111111, "txt");

  }
  
  
  @Test
  public void loadTaxpayerTest() throws WrongTaxpayerStatusException, IOException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException, WrongFileFormatException, NumberFormatException, WrongFileEndingException {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("111111111_INFO.txt");
   assertTrue(Manager1.containsReceipt(11));
    
  }


  @Test
  public void SingleTaxpayerIncomeTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException  {
    
     TaxpayerManager Manager1 = new TaxpayerManager();
     Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.txt");
    
      Double income = Double.valueOf(Manager1.getTaxpayerIncome(123456789));
      
      double expectedValue;
      if (income < 24680) {
        expectedValue = 0.0535 * income;
        
      } else if (income < 81080) {
        expectedValue = 1320.38 + 0.0705 * (income - 24680);
      } else if (income < 90000) {
        expectedValue = 5296.58 + 0.0785 * (income - 81080);
      } else if (income < 152540) {
        expectedValue = 5996.80 + 0.0785 * (income - 90000);
      } else {
        expectedValue = 10906.19 + 0.0985 * (income - 152540);
      }
      
      assertEquals(Manager1.getTaxpayerBasicTax(123456789) ,expectedValue );
    
    
    
  }
  
  @Test
  public void HeadofHouseholdTaxpayerIncomeTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException  {
    
     TaxpayerManager Manager1 = new TaxpayerManager();
     Manager1.loadTaxpayer("headofhouseholdTaxpayerIncomeTest_INFO.txt");
    
      Double income = Double.valueOf(Manager1.getTaxpayerIncome(123456789));
      double expectedValue;
      if (income < 30390) {
        expectedValue = 0.0535 * income;
      } else if (income < 90000) {
        expectedValue = 1625.87 + 0.0705 * (income - 30390);
      } else if (income < 122110) {
        expectedValue = 5828.38 + 0.0705 * (income - 90000);
      } else if (income < 203390) {
        expectedValue = 8092.13 + 0.0785 * (income - 122110);
      } else {
        expectedValue = 14472.61 + 0.0985 * (income - 203390);
      }
      assertEquals(Manager1.getTaxpayerBasicTax(123456789) ,expectedValue );
    
    
    
  }
  @Test
  public void MarriedFilingJointlyTaxpayerIncomeTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException  {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("MarriedFilingJointlyTaxpayerIncomeTest_INFO.txt");
   
     Double income = Double.valueOf(Manager1.getTaxpayerIncome(123456789));
     double expectedValue;
     if (income < 36080) {
       expectedValue = 0.0535 * income;
     } else if (income < 90000) {
       expectedValue = 1930.28 + 0.0705 * (income - 36080);
     } else if (income < 143350) {
       expectedValue = 5731.64 + 0.0705 * (income - 90000);
     } else if (income < 254240) {
       expectedValue = 9492.82 + 0.0785 * (income - 143350);
     } else {
       expectedValue = 18197.69 + 0.0985 * (income - 254240);
     }
     
     assertEquals(Manager1.getTaxpayerBasicTax(123456789) , expectedValue );
   
   
   
 }
  @Test
  public void MarriedFilingSeparatelyTaxpayerIncomeTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException  {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("MarriedFilingSeparatelyTaxpayerIncomeTest_INFO.txt");
   
     Double income = Double.valueOf(Manager1.getTaxpayerIncome(123456789));
     
     double expectedValue;
     if (income < 18040) {
       expectedValue = 0.0535 * income;
     } else if (income < 71680) {
       expectedValue = 965.14 + 0.0705 * (income - 18040);
     } else if (income < 90000) {
       expectedValue = 4746.76 + 0.0785 * (income - 71680);
     } else if (income < 127120) {
       expectedValue = 6184.88 + 0.0785 * (income - 90000);
     } else {
       expectedValue = 9098.80 + 0.0985 * (income - 127120);
     }
     assertEquals(Manager1.getTaxpayerBasicTax(123456789) ,expectedValue );
 }
  
  @Test
  public void xlmFileReaderTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException {
    
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.xml");
    Double income = Double.valueOf(Manager1.getTaxpayerIncome(123456789));
    
    assertEquals(income , 35000);
    
  }
  
  @Test
  public void xmlInfoWriterTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
    //its a template not implemented yet
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.xml");
    Manager1.addReceipt(171232, "25/2/2014" , 2000, "Basic", "String Hand Made Clothes", "Greece", "Ioannina", "Kaloudi",10, 111111111);
    
    Manager1.removeTaxpayer(123456789);
    //assertFalse(Manager1.containsReceipt(171232));
    Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.xml");
    
    assertTrue(Manager1.containsReceipt(171232));
  }
  
 
  
  @Test
  public void txtInfoWriterTest() throws NumberFormatException, IOException, WrongFileFormatException, WrongFileEndingException, WrongTaxpayerStatusException, WrongReceiptKindException, WrongReceiptDateException, ReceiptAlreadyExistsException {
  //its a template not implemented yet
    TaxpayerManager Manager1 = new TaxpayerManager();
    Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.txt");
    Manager1.addReceipt(123, "25/2/2014" , 2000, "Basic", "String Hand Made Clothes", "Greece", "Ioannina", "Kaloudi",10, 111111111);
    
    Manager1.removeTaxpayer(123456789);
    //assertFalse(Manager1.containsReceipt(123));
    Manager1.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.txt");
    
    TaxpayerManager Manager2 = new TaxpayerManager();
    Manager2.loadTaxpayer("SingleTaxpayerIncomeTest_INFO.txt");
    assertTrue(Manager2.containsReceipt(123));
  }
  
  
}

