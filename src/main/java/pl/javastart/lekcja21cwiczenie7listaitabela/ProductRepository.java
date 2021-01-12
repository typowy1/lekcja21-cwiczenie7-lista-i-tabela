package pl.javastart.lekcja21cwiczenie7listaitabela;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Masło", 4.2));
        products.add(new Product("Mleko", 5.1));
        products.add(new Product("Pralka", 2004.2));
        products.add(new Product("Opona", 200.0));
        products.add(new Product("Telefon", 3004.2));
    }

    //szukanie po kategori
//    public List<Product> findByCategory(ProductCategory category) {
//        List<Product> result = new ArrayList<>();
//        for (Product product : products) {
//            if (product.getCategory() == category) {
//                result.add(product);
//            }
//        }
//        return result;
//     }

    //znajdź wszystkie
    public List<Product> findAll() {
        return products;
    }

    //dodaj produkt
    public void add(Product product) {
        products.add(product);
    }
}
