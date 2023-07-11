package incometaxcalculator.data.io;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.exceptions.WrongFileFormatException;

public class FileWriterFactory {
  

  
  public FileWriter generateFileWriter(String fileFormat) throws WrongFileFormatException {
    
    if (fileFormat.equals("txt")) {
      return new TXTLogWriter();
    } else if (fileFormat.equals("xml")) {
      return new XMLLogWriter();
    } else {
      throw new WrongFileFormatException();
    }
  }
  public void updateFiles(int taxRegistrationNumber) throws IOException {
    if (new File(taxRegistrationNumber + "_INFO.xml").exists()) {
       new XMLInfoWriter().generateFile(taxRegistrationNumber);
    }
    if (new File(taxRegistrationNumber + "_INFO.txt").exists()) {
       new TXTInfoWriter().generateFile(taxRegistrationNumber);
    }
    
  } 
}
