package services.book;

import database.models.Book;
import database.models.dao.BookDAO;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public List<Book> findAll() throws SQLException {
        {
            BookDAO dao = new BookDAO();
            return dao.getAllBooks();
        }
    }
}
