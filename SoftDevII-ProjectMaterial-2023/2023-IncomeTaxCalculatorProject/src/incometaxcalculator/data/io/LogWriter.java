package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.data.management.TaxpayerManager;

public abstract class LogWriter implements FileWriter{
  
  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;
  
  protected abstract String getFormat(int index);
  protected abstract String placeExtension(int index);
  protected abstract String getExtension();
  
  public void generateFile(int taxRegistrationNumber) throws IOException {
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + "_LOG." + getExtension()));
    outputStream.println(getFormat(0) + " " +   manager.getTaxpayerName(taxRegistrationNumber) +  placeExtension(0));
    outputStream.println(getFormat(1) + " " +  taxRegistrationNumber + placeExtension(1));
    outputStream.println(getFormat(2) + " " +  manager.getTaxpayerIncome(taxRegistrationNumber) + placeExtension(2));
    outputStream
        .println(getFormat(3) + " " +   manager.getTaxpayerBasicTax(taxRegistrationNumber) + placeExtension(3));
    if ( manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
      outputStream.println(getFormat(4)
          + " " +  manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + placeExtension(4));
    } else {
      outputStream.println(getFormat(5)
          + " " +  manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + placeExtension(5));
    }
    outputStream
        .println(getFormat(6) + " " +   manager.getTaxpayerTotalTax(taxRegistrationNumber) + placeExtension(6));
    outputStream.println(
        getFormat(7) + " " +   manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + placeExtension(7));
    outputStream.println(
        getFormat(8) + " " +   manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT)
        + placeExtension(8));
    outputStream.println(
        getFormat(9) + " " +   manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + placeExtension(9));
    outputStream.println(
        getFormat(10) + " " +  manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) +placeExtension(10));
    outputStream.println(
        getFormat(11) + " " +  manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + placeExtension(11));
    outputStream.println(
        getFormat(12) + " " +   manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + placeExtension(12));
    outputStream.close();
  }


}
