package pl.codemiry.ksb2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {
    @RequestMapping(method = RequestMethod.GET, value = "/{age}")
    public String getProducts(@RequestParam String name,
                              @RequestParam(required = false, defaultValue = "") String surname,
                              @PathVariable(required = false) String age,
                              @RequestHeader(required = false, defaultValue = "") String description,
                              @RequestBody(required = false) String info) {
        return "Hello " + name + " " + surname + " masz " + age + " lat." + description + " " + info;
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
