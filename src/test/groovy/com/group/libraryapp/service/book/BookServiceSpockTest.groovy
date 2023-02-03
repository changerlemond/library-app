package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.repository.book.BookQuerydslRepository
import com.group.libraryapp.repository.user.loanhistory.UserLoanHistoryQuerydslRepository
import spock.lang.Specification

class BookServiceSpockTest extends Specification {

    BookService bookService

    BookRepository bookRepository
    UserRepository userRepository
    UserLoanHistoryQuerydslRepository userLoanHistoryQuerydslRepository
    BookQuerydslRepository bookQuerydslRepository

    def setup() {
        bookRepository = GroovyMock()
        userRepository = GroovyMock()
        userLoanHistoryQuerydslRepository = GroovyMock()
        bookQuerydslRepository = GroovyMock()

        bookService = new BookService(
                bookRepository, userRepository, userLoanHistoryQuerydslRepository, bookQuerydslRepository
        )
    }

    def "saveBookTest"() {

        given:
        def id = null
        BookRequest bookRequest = new BookRequest("1234", BookType.COMPUTER)

        and:
        bookRepository.findByName(bookRequest.getName()) >> Optional.empty()

        when:
        bookService.saveBook(bookRequest)

        then:
        1 * bookRepository.save({
            it.name == bookRequest.getName()
            it.type == bookRequest.getType()
            it.id == id
        }
        ) >> { args -> args[0] }
    }

}
