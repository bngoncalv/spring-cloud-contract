import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/api/v1/customers'
    }
    response {
        status 200
        body('[{"firstName":"Michale","lastName":"Weston","url":"/api/v1/customers/1"},{"firstName":"Sam","lastName":"Axe","url":"/api/v1/customers/2"}]')
        headers {
            contentType(applicationJson())
        }
    }
}
