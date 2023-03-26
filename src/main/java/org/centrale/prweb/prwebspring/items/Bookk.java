/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.prweb.prwebspring.items;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author T480
 */
@Entity
@Table(name = "book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByBookTitle", query = "SELECT b FROM Book b WHERE b.bookTitle = :bookTitle"),
    @NamedQuery(name = "Book.findByBookAuthors", query = "SELECT b FROM Book b WHERE b.bookAuthors = :bookAuthors")})
    

public class Bookk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "book_title")
    private String bookTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "book_authors")
    private String bookAuthors;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_available")
    private Integer bookAvailable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<Borrow> borrowCollection;

    public Bookk() {
    }

    public Bookk(Integer bookId) {
        this.bookId = bookId;
    }

    public Bookk(Integer bookId, String bookTitle, String bookAuthors, Integer bookAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthors = bookAuthors;
        this.bookAvailable = bookAvailable;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAvailable(Integer bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    public Integer getBookAvailable() {
        return bookAvailable;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public Collection<Borrow> getBorrowCollection() {
        return borrowCollection;
    }

    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
        this.borrowCollection = borrowCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookk)) {
            return false;
        }
        Bookk other = (Bookk) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.centrale.prweb.prwebspring.items.Book[ bookId=" + bookId + " ]";
    }
    
}
