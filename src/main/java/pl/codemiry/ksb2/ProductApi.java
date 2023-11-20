package pl.codemiry.ksb2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {
    @RequestMapping(method = RequestMethod.GET)
    public String getProducts() {
        return "Hello World with GET";
    }

    @PostMapping
    public String addProducts() {
        return "Hello World with POST";
    }

    @PutMapping
    public String modProducts() {
        return "Hello World with PUT";
    }

    @DeleteMapping
    public String removeProducts() {
        return "Hello World with DELETE";
    }
}
