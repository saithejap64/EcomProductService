# EcomProductService

----
**DTO and DB:**
   
DB --DTO---> Controller ---DTO---> Service ---(forms entity, business logic)---entity---> Repository ---entity---> DB
 
* Code at service
* Code at mapper, invoked from service

**3rd Party Client**

---DTO---> Controller ---DTO--->Service---DTO---> Client--->DTO

* Ideally all API's and client calls should have their own DTO's
  * Request
  * Response

* DB => POST/product => create product 
  * 2 DTOs => CreateProductRequest, CreateProductResponse
* Client(3rd party) => POST/product(API at BE) => /fakeStore/product(API at 3rd party)
-----
**UNIT TESTING**

* Dev : add features, maintain, new development
* QA : test all the things
  * manual testing
  * automation testing
* Types of testing:
  * Manual testing
  * Automation testing/ Regression
  * Unit testing
  * Integration testing
  * Performance testing (Load testing/ stress testing)
* UNIT TESTING:
  *     ( Controller method ----> Service method ----> Repo method ----> DB (Mock) )