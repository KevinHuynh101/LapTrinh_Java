package huynhnam.BTValidation.controller;

import huynhnam.BTValidation.models.Product;
import huynhnam.BTValidation.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listproduct",productService.GetAll());
        return "products/index";
    }
    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("product", new Product());
        return "products/create";
    }
    @PostMapping("/create")
    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product",newProduct);
            return "products/create";
        }
        if (imageProduct != null && imageProduct.getSize() > 0)
        {
            try{
                File saveFile = new ClassPathResource("static/images").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path =  Paths.get(saveFile.getAbsolutePath()+ File.separator + newImageFile);
                Files.copy( imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImage(newImageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.add(newProduct);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model) {

        Product product = productService.get((int) id);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit (@Valid Product editProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product",editProduct);
            return "products/edit";
        }
        if (imageProduct != null && imageProduct.getSize() > 0)
        {
            try{
                File saveFile = new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath()+ File.separator + editProduct.getImage());
                Files.copy( imageProduct.getInputStream(),  path,  StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.edit(editProduct);
        return "redirect:/products";
    }

}
