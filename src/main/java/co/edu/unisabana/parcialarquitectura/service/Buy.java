package co.edu.unisabana.parcialarquitectura.service;


import co.edu.unisabana.parcialarquitectura.repository.Database;

public class Buy {


  public String makePurchase(Database database, int vendorCode, int buyerCode, String item) {
    if (buyerCode == vendorCode) {
      throw new IllegalSaleException(vendorCode, buyerCode);
    }
    int result = database.savePurchase(buyerCode, item);
    if (result == 1) {
      return "Product sold";
    } else {
      return "The sale was not possible";
    }
  }
}
