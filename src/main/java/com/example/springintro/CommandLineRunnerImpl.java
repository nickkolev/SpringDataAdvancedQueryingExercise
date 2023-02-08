package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();



        /* 13
        Scanner scanner = new Scanner(System.in);

        int amount = Integer.parseInt(scanner.nextLine());

        this.bookService.deleteWithCopiesLessThan(amount);
         */

        /* 12
        Scanner scanner = new Scanner(System.in);

        String date = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());

        int booksUpdated = this.bookService.addCopiesToBooksAfter(date, amount);
        System.out.printf("%s books are released after %s, so total of %d book copies were added", booksUpdated, date, amount);
         */

        /* 11
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        BookSummary summary = this.bookService.getInformationForTitle(title);
        System.out.println(summary.getTitle() + " " + summary.getEditionType() +
                " " + summary.getAgeRestriction() + " " + summary.getPrice());
         */

        /* 10
        this.authorService.getWithTotalCopies()
            .forEach(a -> System.out.println(
                    a.getFirstName() + " " + a.getLastName() +
                    " - " + a.getTotalCopies()));
         */

        /* 09
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int bookCount = this.bookService.countBooksWithTitleLongerThan(length);

        System.out.printf("There are %d books with longer title than %d symbols%n", bookCount, length);
         */

        /* 08
        Scanner scanner = new Scanner(System.in);

        String lastNameStartsWith = scanner.nextLine();
        this.bookService.findAllBooksAuthorLastNameStartingWith(lastNameStartsWith)
                .forEach(b -> System.out.printf
                ("%s -> (%s %s)%n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
         */

        /* 07
        Scanner scanner = new Scanner(System.in);

        String containingText = scanner.nextLine();
        this.bookService.findAllBooksContaining(containingText)
                .forEach(b -> System.out.println(b.getTitle()));
         */

        /* 06
        Scanner scanner = new Scanner(System.in);

        String endsWith = scanner.nextLine();
        this.authorService.getAuthorNameEndsWith(endsWith)
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
         */

        /* 05
        Scanner scanner = new Scanner(System.in);

        String date = scanner.nextLine();

        this.bookService.findBooksReleasedBefore(date)
                .forEach(b -> System.out.printf("%s %s %.2f%n",
                        b.getTitle(), b.getEditionType(), b.getPrice()));
         */

        /* 04
        Scanner scanner = new Scanner(System.in);
        int releaseYear = Integer.parseInt(scanner.nextLine());

        this.bookService.findNotReleasedIn(releaseYear)
                .forEach(b -> System.out.println(b.getTitle()));
         */


        /* 03
          this.bookService.findAllWithPriceNotBetween(5, 40)
                  .forEach(b -> System.out.println(b.getTitle() + " - " + b.getPrice()));

         */

        /* 02
        this.bookService.findAllTitlesByEditionAndCopies(EditionType.GOLD, 5000)
                .forEach(System.out::println);
        */

        /* 01
        Scanner scanner = new Scanner(System.in);
        String restriction = scanner.nextLine();

        this.bookService.findAllTitlesByAgeRestriction(restriction)
                .forEach(System.out::println);
         */
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
