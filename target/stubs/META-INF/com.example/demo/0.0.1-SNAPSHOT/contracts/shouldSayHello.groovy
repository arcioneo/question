import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url '/sayhello/Eduardo'
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
                "msg" : "hello Eduardo"
        ])
        headers {
            contentType('application/json')
        }
    }
}