package com.productassignmentspringjdbc.product;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ProductController {
    private final ProductRepository productRepository = new ProductRepository();

    @GetMapping("/addProduct")
    public String showProductPage(Model model) {
        model.addAttribute("productList", this.getProductsFromDatabase());

        return "addProduct";
    }


    @PostMapping("/addProduct")
    public String addNewProductItem(Product product) {
        this.addProductsToDatabase(product);
        this.getProductsFromDatabase();
        return "redirect:products";
    }


    @GetMapping("/products") //
    public String showAllProducts(Model model) {
        model.addAttribute("productList", this.getProductsFromDatabase());
        return "products";
    }


    private void addProductsToDatabase(Product product) {
        productRepository.createProduct(product);
        System.out.println(product);

    }



    private ArrayList<Product> getProductsFromDatabase() {
        return this.productRepository.findAllProducts();
    }


    private Product getProductFromDatabase(int id) {
        return this.productRepository.findProductById(id);
    }



    @GetMapping("/addProduct/delete/{productId}")
    public String deleteProduct(@PathVariable(name = "productId") int productId) {
        this.productRepository.deleteProduct(productId);
        return "redirect:/products?message=product_deleted";
    }


//    @GetMapping("/edit{productId}")
//    public String showUpdateProductPage(@PathVariable(name = "productId") int productId, Model model) {
//        model.addAttribute("product", this.getProductFromDatabase(productId));
//        return "updateProduct";
//    }

    @GetMapping("/edit{productId}")
    public String showUpdateProductPage(@PathVariable int productId, Model model) {
        model.addAttribute("product", this.getProductFromDatabase(productId));
        return "updateProduct";
    }


    @PostMapping("/updateProduct/{productId}")
    public String updateProduct(@PathVariable int productId, Product updatedProduct) {
        this.productRepository.updateProduct(productId, updatedProduct);
        System.out.println(updatedProduct.toString());
        return "redirect:/products";
    }
}


