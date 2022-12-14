package lab4;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.List;

/**
 * Class which is describing methods for reading data from CSV-file and printing it
 */
public class CSV {

    private String csvFilePath;
    private char separator;
    private List<Human> persons;

    /** Constructor with parameters for an object of the сsvReaderPrinter.CsvReaderPrinter class */
    public CSV(String csvFilePath, char separator, List<Human> persons) {
        this.csvFilePath = csvFilePath;
        this.separator = separator;
        this.persons = persons;
    }

    /**
     * Method for reading data from CSV-file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws CsvValidationException
     */
    public void readFromCSV() {
        try (FileReader in = new FileReader(csvFilePath)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Human person = new Human(Integer.valueOf(nextLine[0]), nextLine[1], nextLine[2], new Division(nextLine[4]), Integer.valueOf(nextLine[5]), nextLine[3]);
                persons.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for printing of read data
     */
    public void printCSVData() {
        for(int i = 0; i < persons.size(); i++){
            System.out.print(persons.get(i).getID() + "\t \t");
            System.out.print(persons.get(i).getName() + "\t \t");
            System.out.print(persons.get(i).getGender() + "\t \t");
            System.out.print(persons.get(i).getBirthday() + "\t \t");
            System.out.print(persons.get(i).getDepartment().getID() + "\t \t");
            System.out.print(persons.get(i).getDepartment().getTitle() + "\t \t");
            System.out.print(persons.get(i).getSalary() + "\t \t");
            System.out.println();
        }
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public void setCsvFilePath(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public List<Human> getPersons() {
        return persons;
    }

    public void setPersons(List<Human> persons) {
        this.persons = persons;
    }
}