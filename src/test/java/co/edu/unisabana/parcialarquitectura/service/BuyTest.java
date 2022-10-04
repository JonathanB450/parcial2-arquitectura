package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import co.edu.unisabana.parcialarquitectura.repository.IDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class BuyTest {

  @Mock
  private IDatabase database = new Database();

  @Mock
  private final Buy service = new Buy(database);


  @Test
  public void test() {
    service.makePurchase(2, 3, "Books");
  }

  @Test
  public void Given_same_buyerCode_and_vendorCode_When_makePurchase_Then_throw_IllegalSaleException(){
    Assertions.assertThrows(IllegalSaleException.class, () -> {
      service.makePurchase(1, 1, "A");
    });
  }

  @Test
  public void Given_different_buyerCode_and_vendorCode_and_result_equals_1_When_makePurchase_Then_return_productSold(){
    Mockito.when(database.savePurchase(2, "A")).thenReturn(1);
    String result = service.makePurchase(1, 2, "A");
    Assertions.assertEquals("Product sold", result);
  }

  @Test
  public void Given_different_buyerCode_and_vendorCode_and_result_equals_2_When_makePurchase_Then_return_theSaleWasNotPossible(){
    Mockito.when(database.savePurchase(2, "A")).thenReturn(2);
    String result = service.makePurchase(1, 2, "A");
    Assertions.assertEquals("The sale was not possible", result);
  }
}