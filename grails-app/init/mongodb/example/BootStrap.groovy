package mongodb.example

class BootStrap {

    def init = { servletContext ->
        Product product = new Product();
        product.name = "Apple"
        product.price = 20

        product.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
