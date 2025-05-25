import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {
    @Test
    public void testEveryStatement() {
        List<Item> items = List.of(new Item("Apple", 2, 200, 0));
        assertEquals(400, SILab2.checkCart(items, "1234567890123456"));

        List<Item> items2 = List.of(new Item(null, 2, 100, 0));
        assertEquals(200, SILab2.checkCart(items2, "1234567890123456"));

        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "abcd1234"));

        List<Item> items3 = List.of(new Item("Banana", 0, 100, 0));
        assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items3, "1234567890123456"));
    }

    @Test
    public void testMultipleCondition() {
        List<Item> items1 = List.of(new Item("item", 10, 300, 0));
        assertEquals(3000, SILab2.checkCart(items1, "1234567890123456"), 0.01);

        List<Item> items2 = List.of(new Item("item", 11, 300, 0));
        assertTrue(SILab2.checkCart(items2, "1234567890123456") < 3000);


        List<Item> items3 = List.of(new Item("item", 10, 300, 0.1));
        assertTrue(SILab2.checkCart(items3, "1234567890123456") < 3000);


        List<Item> items4 = List.of(new Item("item", 11, 300, 0.1));
        assertTrue(SILab2.checkCart(items4, "1234567890123456") < 3000);



        List<Item> items5 = List.of(new Item("item", 10, 301, 0));
        assertTrue(SILab2.checkCart(items5, "1234567890123456") < 3010);


        List<Item> items6 = List.of(new Item("item", 11, 301, 0));
        assertTrue(SILab2.checkCart(items6, "1234567890123456") < 3010);


        List<Item> items7 = List.of(new Item("item", 10, 301, 0.1));
        assertTrue(SILab2.checkCart(items7, "1234567890123456") < 3010);


        List<Item> items8 = List.of(new Item("item", 11, 301, 0.1));
        assertTrue(SILab2.checkCart(items8, "1234567890123456") < 3010);
    }
}


