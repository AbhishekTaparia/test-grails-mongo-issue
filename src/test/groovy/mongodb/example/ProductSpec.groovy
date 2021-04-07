package mongodb.example

import grails.test.mongodb.MongoSpec
import grails.testing.gorm.DomainUnitTest
import com.github.fakemongo.Fongo
import com.mongodb.MongoClient

class ProductSpec extends MongoSpec implements DomainUnitTest<Product> {

    @Override
    MongoClient createMongoClient() {
        new Fongo(getClass().name).mongo
    }

    void 'a negative value is not a valid price'() {
        given:
        domain.price = -2.0d

        expect:
        !domain.validate(['price'])
    }

    void 'a blank name is not save'() {
        given:
        domain.name = ''

        expect:
        !domain.validate(['name'])
    }

    void 'A valid domain is saved'() {
        given:
        domain.name = 'Banana'
        domain.price = 2.15d

        when:
        domain.save()

        then:
        Product.count() == old(Product.count()) + 1
    }
}
