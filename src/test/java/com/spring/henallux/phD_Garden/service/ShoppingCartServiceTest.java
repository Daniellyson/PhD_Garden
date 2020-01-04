package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.dao.DiscountDAO;
import com.spring.henallux.phD_Garden.dataAccess.dao.UserDAO;
import com.spring.henallux.phD_Garden.dataAccess.entity.DiscountEntity;
import com.spring.henallux.phD_Garden.dataAccess.repository.DiscountRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.DiscountConverter;
import com.spring.henallux.phD_Garden.exception.QuantityException;
import com.spring.henallux.phD_Garden.model.Discount;
import com.spring.henallux.phD_Garden.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {


    private HashMap<Product, Integer> shoppingCart;

    @Mock
    private DiscountRepository discountRepository;
    @Mock
    private DiscountConverter discountConverter;

    private DiscountDAO discountDAO;

    private ShoppingCartService shoppingCartService;

    @Before
    public void setUp() throws Exception {

        shoppingCartService = new ShoppingCartService();
        discountDAO = new DiscountDAO(discountRepository, discountConverter);
    }

    @Test
    public void successExistsByUsernameTest() {

        List<DiscountEntity> mokedDiscounts = new ArrayList<>();
        DiscountEntity discount1 = new DiscountEntity();
        discount1.setId(1);
        DiscountEntity discount2 = new DiscountEntity();
        discount2.setId(2);
        mokedDiscounts.add(discount1);
        mokedDiscounts.add(discount2);

        when(discountRepository.findByStartDateBeforeAndEndDateAfterAndProductEntityId(new Date(), new Date(), 1)).thenReturn(mokedDiscounts);

        List<DiscountEntity> discounts = new ArrayList<>();
        DiscountEntity discount3 = new DiscountEntity();
        discount3.setId(1);
        DiscountEntity discount4 = new DiscountEntity();
        discount4.setId(2);
        discounts.add(discount3);
        discounts.add(discount4);

        DiscountEntity discount = new DiscountEntity();
        discount.setId(1);
        when(discountConverter.discountModelToDiscountEntity(discountDAO.getDiscountById(discounts.get(0).getId()))).thenReturn(discount);

        assertEquals(discount.getId(),  discounts.get(0).getId());
    }

    @Test
    public void failExistsByUsernameTest() {

        List<DiscountEntity> mokedDiscounts = new ArrayList<>();
        DiscountEntity discount1 = new DiscountEntity();
        discount1.setId(1);
        DiscountEntity discount2 = new DiscountEntity();
        discount2.setId(2);
        mokedDiscounts.add(discount1);
        mokedDiscounts.add(discount2);

        when(discountRepository.findByStartDateBeforeAndEndDateAfterAndProductEntityId(new Date(), new Date(), 1)).thenReturn(mokedDiscounts);

        List<DiscountEntity> discounts = new ArrayList<>();
        DiscountEntity discount3 = new DiscountEntity();
        discount3.setId(1);
        DiscountEntity discount4 = new DiscountEntity();
        discount4.setId(2);
        discounts.add(discount3);
        discounts.add(discount4);

        DiscountEntity discount = new DiscountEntity();
        discount.setId(5);
        when(discountConverter.discountModelToDiscountEntity(discountDAO.getDiscountById(discounts.get(0).getId()))).thenReturn(discount);

        assertNotEquals(discount.getId(),  discounts.get(0).getId());

    }

    @Test
    public void calculationTotalPriceWithOneTest() throws QuantityException {

        Product product1 = new Product();
        product1.setPrice(10.0);

        shoppingCart = new HashMap<>();
        shoppingCart.put(product1, 5);

        double totalPrice = 0.0;

        totalPrice = shoppingCartService.calculationTotalPrice(shoppingCart);


        Assert.assertEquals( 50.00, totalPrice, 0.01);
    }

    @Test
    public void calculationTotalPriceWithManyTest() throws QuantityException {

        Product product1 = new Product();
        product1.setPrice(10.0);

        Product product2 = new Product();
        product2.setPrice(20.0);

        shoppingCart = new HashMap<>();
        shoppingCart.put(product1, 5);
        shoppingCart.put(product2, 1);

        double totalPrice = 0.0;

        totalPrice = shoppingCartService.calculationTotalPrice(shoppingCart);

        Assert.assertEquals( 70.00, totalPrice, 0.01);
    }

    @Test
    public void calculationTotalPriceWithoutShoppingCartTest() throws QuantityException {

        shoppingCart = new HashMap<>();

        double totalPrice = 0.0;

        totalPrice = shoppingCartService.calculationTotalPrice(shoppingCart);

        Assert.assertEquals( 0.0, totalPrice, 0.01);
    }

    @Test (expected = QuantityException.class)
    public void calculationTotalPriceWithMinusTest() throws QuantityException {

        Product product1 = new Product();
        product1.setPrice(10.0);

        shoppingCart = new HashMap<>();
        shoppingCart.put(product1, -5);


        shoppingCartService.calculationTotalPrice(shoppingCart);

    }

    @Test (expected = QuantityException.class)
    public void calculationTotalPriceWithZeroTest() throws QuantityException {

        Product product1 = new Product();
        product1.setPrice(10.0);

        shoppingCart = new HashMap<>();
        shoppingCart.put(product1, 0);


        shoppingCartService.calculationTotalPrice(shoppingCart);

    }
}