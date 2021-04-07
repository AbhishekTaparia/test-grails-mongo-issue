package mongodb.example

import org.bson.types.ObjectId

class Product {

    String name
    Double price
    ObjectId id

    //tag::constraints[]
    static constraints = {
        name blank: false
        price range: 0.0..1000.00
    }
    //end::constraints[]
}
