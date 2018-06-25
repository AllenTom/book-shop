package services.book;

import database.models.Book;
import database.models.dao.BookDAO;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    public List<Book> findAll() throws SQLException;
}
