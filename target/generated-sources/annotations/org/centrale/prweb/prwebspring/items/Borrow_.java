package org.centrale.prweb.prwebspring.items;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.centrale.prweb.prwebspring.items.Book;
import org.centrale.prweb.prwebspring.items.Person;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-13T13:50:02", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Borrow.class)
public class Borrow_ { 

    public static volatile SingularAttribute<Borrow, Date> borrowReturn;
    public static volatile SingularAttribute<Borrow, Integer> borrowId;
    public static volatile SingularAttribute<Borrow, Person> personId;
    public static volatile SingularAttribute<Borrow, Date> borrowDate;
    public static volatile SingularAttribute<Borrow, Book> bookId;

}