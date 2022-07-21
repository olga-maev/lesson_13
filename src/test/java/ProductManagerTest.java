import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Fox in forest", 250, "Anna");
    Book book2 = new Book(2, "Travel Fox ", 400, "Mark");
    Smartphone smartphone1 = new Smartphone(3, "Honor 50S", 14500, "China");
    Book book3 = new Book(4, "Mark and Fox in forest", 300, "Spider");
    Smartphone smartphone2 = new Smartphone(5, "Honor 10 PRO", 24500, "China");
    Book book4 = new Book(6, "Red and black", 200, "Anna");
    Smartphone smartphone3 = new Smartphone(7, "Honor", 10000, "China");

    @Test
    public void souldRemoveId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone3);

        manager.removeId(smartphone3.getId());

        Product[] actual = repository.findAll();

        Product[] expected = {book1, book2, book3, book4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void souldFindNothing() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(smartphone2);
        manager.add(book4);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Sergey");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void souldFindOne() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(smartphone2);
        manager.add(book4);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("10");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void souldFindFew() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(book3);
        manager.add(smartphone2);
        manager.add(book4);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }


}
