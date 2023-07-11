package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public abstract class InfoWriter implements FileWriter{
  
  protected abstract String getFormat(int index);
  protected abstract String placeExtension(int index);
  protected abstract String getExtension();
  
  public void generateFile(int taxRegistrationNumber) throws IOException {
    TaxpayerManager manager = new TaxpayerManager();
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + "_INFO." + getExtension()));
    outputStream.println(getFormat(0) + " " + manager.getTaxpayerName(taxRegistrationNumber) +  placeExtension(0));
    outputStream.println(getFormat(1) + " " + taxRegistrationNumber + placeExtension(1));
    outputStream.println(getFormat(2) + " " + manager.getTaxpayerStatus(taxRegistrationNumber) + placeExtension(2));
    outputStream.println(getFormat(3) + " " + manager.getTaxpayerIncome(taxRegistrationNumber) +  placeExtension(3));
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println(getFormat(4)+ " " );
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }

  private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
    TaxpayerManager manager = new TaxpayerManager();
    HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
    Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      HashMap.Entry<Integer, Receipt> entry = iterator.next();
      Receipt receipt = entry.getValue();
      outputStream.println(getFormat(5) + " " + receipt.getId() +  placeExtension(4));
      outputStream.println(getFormat(6) + " " + receipt.getIssueDate() +  placeExtension(5));
      outputStream.println(getFormat(7) + " " + receipt.getKind() +  placeExtension(6));
      outputStream.println(getFormat(8) + " " + receipt.getAmount() +  placeExtension(7));
      outputStream.println(getFormat(9) + " " + receipt.getCompany() +  placeExtension(8));
      outputStream.println(getFormat(10) + " " + receipt.getAddress().getCountry()  + placeExtension(9));
      outputStream.println(getFormat(11) + " " + receipt.getAddress().getCity()  + placeExtension(10));
      outputStream.println(getFormat(12) + " " + receipt.getAddress().getStreet() + placeExtension(11));
      outputStream.println(getFormat(13) + " " + receipt.getAddress().getNumber() + placeExtension(12));
      outputStream.println();
    }
  }

}
