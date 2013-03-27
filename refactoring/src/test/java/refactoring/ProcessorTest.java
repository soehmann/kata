package refactoring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static refactoring.AddressDataBuilder.aAddress;
import static refactoring.ItemBuilder.aItem;
import static refactoring.ShoppingCartBuilder.aShoppingCart;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProcessorTest {

    private Order order;
    private Processor toTest;

    @Before
    public void setUp() throws Exception {
        order = new Order();
        toTest = new Processor();
    }

    @Test
    public void testProcess() throws Exception {

        toTest.process(order, shoppingCart());

        assertThat(order.isValid(), is(true));
        assertThat(order.getOrderSum(), is(new BigDecimal("18.80")));
        assertThat(order.getBilling().getStreet(), is("Irgendwo da draussen im Wald hinter den Bergen ..."));
    }

    @Test
    public void testBulkyOrder() {
        final ShoppingCart shoppingCart = aShoppingCart().withBillingAddress(aAddress())
                                                         .withDeliveryAddress(aAddress())
                                                         .withItem(aItem().isBulky().build())
                                                         .build();

        toTest.process(order, shoppingCart);
        assertThat(order.getOrderSum(), is(new BigDecimal("27.80")));
        assertThat(order.isValid(), is(true));
    }

    @Test
    public void testPackstationOrder() {
        final ShoppingCart shoppingCart = aShoppingCart().withBillingAddress(aAddress())
                                                         .withDeliveryAddress(aAddress().withStreet("packstation"))
                                                         .withItem(aItem())
                                                         .build();

        toTest.process(order, shoppingCart);
        assertThat(order.getOrderSum(), is(new BigDecimal("18.80")));
        assertThat(order.getDelivery().getStreet(), is("packstation"));
        assertThat(order.isValid(), is(true));
    }


    private ShoppingCart shoppingCart() {
        return aShoppingCart().withBillingAddress(aAddress())
                              .withDeliveryAddress(aAddress())
                              .withItem(aItem())
                              .build();
    }
}
