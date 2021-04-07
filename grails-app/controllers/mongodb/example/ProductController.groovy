package mongodb.example


import grails.rest.*
import grails.converters.*

class ProductController extends RestfulController {
    static responseFormats = ['json', 'xml']
    ProductController() {
        super(Product)
    }

    def search(String q, Integer max ) {
        if (q) {
            def query = Product.where {
                name ==~ ~/$q/
            }
            respond query.list(max: Math.min( max ?: 10, 100))
        }
        else {
            respond([])
        }
    }
}
