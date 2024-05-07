package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Book;
import exercise.repository.BookRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::map).toList();
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
        return bookMapper.map(book);
    }

    public BookDTO createBook(BookCreateDTO bookCreateDTO) {
        try {
            Book book = bookMapper.map(bookCreateDTO);
            book = bookRepository.save(book);
            return bookMapper.map(book);
        } catch (Exception e) {
            throw new ConstraintViolationException(null);
        }
    }

    public BookDTO updateBook(BookUpdateDTO bookUpdateDTO, Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
        bookMapper.update(bookUpdateDTO, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
        bookRepository.deleteById(id);
    }
    // END
}
