package mock;

import com.javaee.springtests.api.v1.model.CustomerDTO;
import com.javaee.springtests.controllers.v1.CustomerController;
import com.javaee.springtests.domain.Customer;
import com.javaee.springtests.services.CustomerService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.when;


public class MockMvcTest {
    @Mock
    CustomerService customerService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.standaloneSetup(new CustomerController(customerService));

        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customer1.setUrl(CustomerController.CUSTOMER_URL + "/1");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");
        customer2.setUrl(CustomerController.CUSTOMER_URL + "/2");

        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));
    }
}
