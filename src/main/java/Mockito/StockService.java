package Mockito;

public interface StockService {
    public double getPrice(Stock stock);
    public int getValue(int value);
    public boolean connectToDB(String type);
    public void add(int index, String element);
    public int getUniqueId();
}
