# EcomProductService

----
**DTO and DB:**

     ( DB --DTO---> Controller ---DTO---> Service ---(forms entity, business logic)---entity---> Repository ---entity---> DB )
* Code at service
* Code at mapper, invoked from service

**3rd Party Client**

    ( ---DTO---> Controller ---DTO--->Service---DTO---> Client--->DTO )

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
* TDD (Test Driven Development):
  * Writes the test cases
  * Write the actual code
  * Test if all the test cases pass or not
* BDD (Behaviour Driven Development):
  * Do the development based on behaviour requirement
  * Write test cases and test
* Dependency : starter-test
---
 
* @Before : used for setting up the test env 
  * runs only once when we are executing the tests in the class
* @After : used for destroying the test env 
  * runs only once after we are executing the tests in the class
* @BeforeEach : used for setting up for all the tests 
  * runs before every test cases
* @AfterEach : : used for destroying for all the tests
  * runs after every test cases

----
**AAA Pattern** 
* Arrange
  * all mock data creation
  * all mock behaviour
  * expected data
* Act
  * actually calling the method we are testing
* Assert
  * checks/ validation