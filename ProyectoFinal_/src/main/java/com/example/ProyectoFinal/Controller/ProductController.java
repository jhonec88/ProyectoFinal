package com.example.ProyectoFinal.Controller;


import com.example.ProyectoFinal.Model.ProductModel;
import com.example.ProyectoFinal.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
// @RequestMapping("/api/V1")
public class ProductController {

    // @Autowired, no se requiere porque se prefiere el uso del @RequiredArgsConstructor
    private final ProductService productService;


    // private ProductRepository productRepository; // Inyectas tu interfaz. Solo se deja como ejemplo, no se requiere porque se está usando un Service
    // public List<ProductModel> products = new ArrayList<>(); // No se usa, es solo cuando los datos están en una estructura

    @GetMapping("/saludo")
    // @RequestMapping(value="/saludo", method=RequestMethod.GET) Es equivalente a @GetMapping("/saludo")
    public String getProducts(@RequestParam String name) {
        return "Hello ".concat(name).concat(" Is everything working fine with the application?"); //concat(id.toString(), concat(String.valueOf(id) si el parámetro es un int
        // return String.format("Hola %s, How are things going?", name); // Otra forma de conformar el mensaje
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        // List<ProductModel> listaProducts = productRepository.findAll(); // Buscamos todos los registros en la tabla usando el repositorio
        List<ProductModel> listaProducts = productService.findAll(); // Tenemos esta línea porque se configura el Service
        return ResponseEntity.ok(listaProducts); // Devolvemos la lista con un estado HTTP 200 OK
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> getProductid(@PathVariable Long id) {
        ProductModel product = ProductService.findById(id).orElseThrow(() -> new RuntimeException("Product not found")); //La excepción se ve en la pantalla de ejecución de InttelliJ
        return ResponseEntity.ok(product);
    }

    /*@GetMapping("/product_dto")
    public ResponseEntity<ProductDTO> findId(@RequestParam Long id) {
        ProductDTO productDTO = productService.findDTOById(id); // Cuando los datos están en una DB
        return ResponseEntity.ok(productDTO);
    }*/

    @GetMapping("/product_model")
    public ResponseEntity<ProductModel> getProduct2id(@RequestParam(required = false) Long id) {
        // Product product = products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found")); // Cuando los datos están en una estructura
        ProductModel product = ProductService.findById(id).orElseThrow(() -> new RuntimeException("Product not found")); // Cuando los datos están en una DB
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
        ProductModel productSave = productService.saveProduct(product);
        return ResponseEntity.ok(productSave);
    }

    @PostMapping("/product_new")
    public ResponseEntity<ProductModel> createProduct_new(@RequestBody ProductModel product) {
        // Long nextId = productService.findAll().stream().mapToLong(ProductModel::getId).max().orElse(0L) + 1; Es requerido si no se usa @Id y @GeneratedValue(strategy = GenerationType.IDENTITY) en ProductModel
        ProductModel newProduct = productService.saveProduct(ProductModel.builder()
                // .id(nextId)
                .nombre(product.getNombre())
                .descripcion(product.getDescripcion())
                .precio(product.getPrecio())
                .canDisp(product.getCanDisp())
                .categoria(product.getCategoria())
                .fecha(product.getFecha())
                .build()
        );
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/del_product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

/*
    @PostMapping("/users")
    public ResponseEntity<UsersModel> createUser(@RequestBody UsersModel user) {
        UsersModel savedUser = CustomUserDetailsService.save(user);
        return ResponseEntity.ok(savedUser);
    }*/
}
