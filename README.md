# unit_test_springboot
In this project describe how to create unit test in spring boot app.


Prerequisite
1. You understand the concept of unit testing
2. You understand the concept of mock in unit testing
3. You have spring boot app, which used for unit testing


In this tutorial, i will use this scenario
1. client hit api, which api used for save product
2. if data, which client send is bad request(null)
3. the api will send response to the client is exception(error message and http response code)
4. makesure the unit test have same exception(same response code and same error message)
5. makesure the unit test return same object what client send to service layer if save product succes




Let's jump right in
1. Add dependency needed in spring boot app
2. Create test class, according to real class to be tested
    - for example, in this tutorial i test service layer of API
        ProductService   become ProductServiceTest
    - if your idea is intellij, you can easyly create test class using this shortcut ctrl+shift+T
3. create instance Product service using annotation @InjectMocks
4. create mock version of ProductRepository using     @Mock
3. Create method setUp and annotate with  @BeforeEach. 
  -If your tests require specific data, set up test data before executing the test methods.
4. Create method to write unit test(i create two unit test)
   - in this tutorial i create unit test to validate if name of product null, the API will send exception
       - message = 'Name of product can't null'
       - httpStatus = '400'
   - and the second unit test is to validate return object, is same object what the client send to API


Success, happy learning and happy sharing !!!!
