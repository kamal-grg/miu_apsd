import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Product implements Comparable<Product> {
    private int productId;
    private String name;
    private Date dateOfSupplied;
    private int quantityInStock;
    private double unitPrice;
public Product()
{
    this.productId = getUniqueID();
    this.name = "";
    this.dateOfSupplied = new Date();
    this.quantityInStock = 0;
    this.unitPrice = 0.0;
}
    public Product(String name, Date dateOfSupplied, int quantityInStock, double unitPrice) {
        this.productId = getUniqueID();
        this.name = name;
        this.dateOfSupplied = dateOfSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    private int getUniqueID()
    {
        Random random = new Random();
        int id=random.nextInt(90000) + 10000;
        return id;
    }
    public int getProdutId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfSupplied() {
        return dateOfSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateOfSupplied=" + dateOfSupplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }



    @Override
    public int compareTo(Product otherProduct) {
        return this.name.compareTo(otherProduct.name);

    }
}
