package learn.sort;

import java.util.Arrays;

/**
 * @description: 书籍类
 * @author: guoping wang
 * @date: 2018/8/28 14:01
 * @project: cc-leetcode
 */
public class Book implements Comparable<Book> {

    private String name;
    private int page;
    private int price;

    public Book(String name, int page, int price) {
        this.name = name;
        this.page = page;
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        if (this.price < o.price) {
            return -1;
        }
        if (this.price > o.price) {
            return 1;
        }
        if (this.page < o.page) {
            return -1;
        }
        if (this.page > o.page) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", page=" + page +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Book book1 = new Book("book1", 200, 10);
        Book book2 = new Book("book2", 230, 30);
        Book book3 = new Book("book3", 400, 30);
        Book book4 = new Book("book4", 400, 50);
        Book[] books = {book2, book3, book1, book4};
        for (Book book : books) {
            System.out.println(book);
        }
        Arrays.sort(books);
        System.out.println("排序后：");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
