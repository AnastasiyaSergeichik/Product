package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(1, "first", 500, "Author1");
    private Product book2 = new Book(2, "second", 1900, "Author2");
    private Product book3 = new Book(3, "third", 900, "Author3");
    private Product phone1 = new Smartphone(4, "Galaxy S20FE", 52990, "Sumsung");
    private Product phone2 = new Smartphone(5, "Galaxy Note", 67988, "Sumsung");
    private Product phone3 = new Smartphone(8, "iPhone 11", 51750, "Apple");
    private Product phone4 = new Smartphone(4, "Nokia 5.3 4", 13220, "Nokia");
    private Product product1 = new Product(10, "None", 10);
    private Product product2 = new Product(15, "None1", 100);

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(phone4);
        manager.add(product1);
        manager.add(product2);
    }

    @Test
    public void shouldFindByBookAuthor() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookName() {
        Product[] actual = manager.searchBy("first");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneName() {
        Product[] actual = manager.searchBy("iPhone 11");
        Product[] expected = new Product[]{phone3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Sumsung");
        Product[] expected = new Product[]{phone1, phone2};


        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindByNotFoundProduct() {
        Product[] actual = manager.searchBy("Alcatel");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

   // @Test
    //void shouldAddProduct() {
   //     manager = new ProductManager(repository);
   //     manager.add(book2);
  //      manager.add(phone4);
 //   }
}