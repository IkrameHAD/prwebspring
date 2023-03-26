package org.centrale.prweb.prwebspring.items;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.centrale.prweb.prwebspring.items.Borrow;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-26T17:48:16", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Date> personBirthdate;
    public static volatile CollectionAttribute<Person, Borrow> borrowCollection;
    public static volatile SingularAttribute<Person, Integer> personId;
    public static volatile SingularAttribute<Person, String> personLastname;
    public static volatile SingularAttribute<Person, String> personFirstname;

}