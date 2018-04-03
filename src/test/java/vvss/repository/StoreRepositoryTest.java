package vvss.repository;

import org.junit.*;
import vvss.model.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by tnagy on 4/3/2018.
 */
public class StoreRepositoryTest {
    private StoreRepository target;

    private static final Product PRODUCT = new Product(12, "asd", "asd", 21);
    private static final Product PRODUCT_2 = new Product(2, "asd2", "asd1", 1);
    private static final List<Product> PRODUCT_LIST = Arrays.asList(PRODUCT, PRODUCT_2);

    @Before
    public void setup() {
        target = new StoreRepository("testProducts.txt");
    }

    @Test
    public void testGetProductsCategory() {
        assert true;
    }

    @Test
    public void testAddProductWithCorrectValues() {
        try {
            target.addNewProduct(PRODUCT);
            assertEquals(PRODUCT, target.getFirst());
        } catch (Exception ex) {
            fail("Szar vagy :(");
        }
    }
}
