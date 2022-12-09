package lab4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    CSV reader;

    @BeforeEach
    void setUp() {
        reader = new CSV("C://Users/User/IdeaProjects/lab4/src/main/resources/foreign_names.csv",  ';', new ArrayList<>());
    }

    @Test
    void ifSomeLineIsNullTest() {
        reader.readFromCSV();
        boolean notNull = true;
        for (int i = 0; i < reader.getPersons().size(); i++) {
            if(!checkNotNull(reader.getPersons().get(i)))
                notNull = false;
        }

        assertTrue(notNull);
    }

    private boolean checkNotNull(Human person) {
        return person.getID() != 0 && person.getName() != null && person.getGender() != null && person.getBirthday() != null && person.getDepartment() != null && person.getSalary() != 0;
    }
}