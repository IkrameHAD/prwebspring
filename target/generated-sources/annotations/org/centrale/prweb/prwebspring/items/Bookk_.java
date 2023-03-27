package org.centrale.prweb.prwebspring.items;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.centrale.prweb.prwebspring.items.Borrow;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-27T14:48:54", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Bookk.class)
public class Bookk_ { 

    public static volatile SingularAttribute<Bookk, String> bookAuthors;
    public static volatile CollectionAttribute<Bookk, Borrow> borrowCollection;
    public static volatile SingularAttribute<Bookk, Integer> bookAvailable;
    public static volatile SingularAttribute<Bookk, Integer> bookId;
    public static volatile SingularAttribute<Bookk, String> bookTitle;

}