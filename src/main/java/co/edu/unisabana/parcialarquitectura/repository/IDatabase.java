package co.edu.unisabana.parcialarquitectura.repository;

public interface IDatabase{
    int savePurchase(int buyerCode, String item);
}