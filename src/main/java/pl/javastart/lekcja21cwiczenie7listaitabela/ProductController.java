package pl.javastart.lekcja21cwiczenie7listaitabela;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // wyświetlenie przefiltrowanej listy produktów
    @GetMapping("/lista")
    public String list(Model model) {
        List<Product> products;
        products = productRepository.findAll();

        model.addAttribute("products", products); //model do wyświetlenia listy

        //licze sume wszystkich produktów
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        model.addAttribute("priceSum", sum); // model dla sumy

        return "list";
    }

    //post maping do dodawania produktów
    @PostMapping("/dodaj")
    public String add(@RequestParam String name, @RequestParam double price) {
        Product product = new Product(name, price);
        productRepository.add(product);
        return "redirect:/lista";
    }
}
