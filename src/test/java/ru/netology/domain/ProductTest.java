package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTest {
    private Product book1 = new Book(1, "first", 500, "Author1");
    private Product book2 = new Book(2, "second", 1900, "Author2");
    private Product book3 = new Book(3, "third", 900, "Author3");
    private Product phone1 = new Smartphone(4, "Galaxy S20FE", 52990, "Sumsung");
    private Product phone2 = new Smartphone(5, "Galaxy Note", 67988, "Sumsung");
    private Product phone3 = new Smartphone(8, "iPhone 11", 51750, "Apple");
    private Product phone4 = new Smartphone(4, "Nokia 5.3 4", 13220, "Nokia");
    private Product product1 = new Product(10, "None1", 150);
    private Product product2 = new Product(10, "None2", 200);

    @Test
    public void searchBookNameMatch() {
        boolean actual = book1.matches("first");
        assertTrue(actual);
    }

    @Test
    public void searchBookNameNotMatch() {
        boolean actual = book1.matches("third");
        assertFalse(actual);
    }

    @Test
    public void searchBookAuthorMatch() {
        boolean actual = book2.matches("Author2");
        assertTrue(actual);
    }

    @Test
    public void searchBookAuthorNotMatch() {
        boolean actual = book3.matches("Author1");
        assertFalse(actual);
    }

    @Test
    public void searchSmartphoneNameMatch() {
        boolean actual = phone1.matches("Galaxy S20FE");
        assertTrue(actual);
    }

    @Test
    public void searchSmartphoneNameNotMatch() {
        boolean actual = phone2.matches("iPhone 11");
        assertFalse(actual);
    }

    @Test
    public void searchSmartphoneManufacturerMatch() {
        boolean actual = phone3.matches("Apple");
        assertTrue(actual);
    }

    @Test
    public void searchSmartphoneManufacturerNotMatch() {
        boolean actual = phone4.matches("Sumsung");
        assertFalse(actual);
    }

    @Test
    void matchesProductNameMatch() {
        boolean actual = product1.matches("None1");
        assertTrue(actual);
    }

    @Test
    void matchesProductNameNotMatch() {
        boolean actual = product2.matches("None1");
        assertFalse(actual);
    }

}
