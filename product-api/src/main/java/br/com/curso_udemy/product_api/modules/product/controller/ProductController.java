package br.com.curso_udemy.product_api.modules.product.controller;

import br.com.curso_udemy.product_api.config.exception.SuccessResponse;
import br.com.curso_udemy.product_api.modules.category.dto.CategoryRequest;
import br.com.curso_udemy.product_api.modules.category.dto.CategoryResponse;
import br.com.curso_udemy.product_api.modules.category.service.CategoryService;
import br.com.curso_udemy.product_api.modules.product.dto.ProductRequest;
import br.com.curso_udemy.product_api.modules.product.dto.ProductResponse;
import br.com.curso_udemy.product_api.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest request){
        return productService.save(request);
    }

    @GetMapping
    public List<ProductResponse> findALll(){
        return productService.findAll();
    }
    @GetMapping("{id}")
    public ProductResponse findById(@PathVariable Integer id){
        return productService.findByIdResponse(id);
    }
    @GetMapping("name/{name}")
    public List<ProductResponse> findByDescription(@PathVariable String name){
        return productService.findByName(name);
    }
    @GetMapping("category/{category}")
    public List<ProductResponse> findByCategoryId(@PathVariable Integer categoryId){
        return productService.findByCategoryId(categoryId);
    }
    @GetMapping("supplier/{supplier}")
    public List<ProductResponse> findBySupplierId(@PathVariable Integer supplierId){
        return productService.findBySupplierId(supplierId);
    }
    @PutMapping("{id}")
    public ProductResponse update(@RequestBody ProductRequest request,
                                  @PathVariable Integer id) {
        return productService.update(request, id);
    }

    @DeleteMapping("{id}")
    public SuccessResponse delete(@PathVariable Integer id) {
        return productService.delete(id);
    }
}
