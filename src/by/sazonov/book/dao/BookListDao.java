package by.sazonov.book.dao;

import by.sazonov.book.entity.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookListDao {
    static public ArrayList<Book> list;
    static private FileReader file;
    static private Scanner in;
    static private FileWriter fileWriter;

    static {
        try {
            file = new FileReader("src/resources/text.txt");
            in = new Scanner(file);
            list = new ArrayList<>();
            while (in.hasNextLine()) {
                String[]lineFile = in.nextLine().split(",");
                Book book = new Book(lineFile[0],Integer.parseInt(lineFile[1]),Integer.parseInt(lineFile[2]),lineFile[3],lineFile[4]);
                list.add(book);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeApplication() throws IOException {
        fileWriter = new FileWriter("src/resources/text.txt",false);
        StringBuilder returnString = new StringBuilder();
        for (Book e:list) {
            returnString.append(e.getName()+","+
                    String.valueOf(e.getYear())+","+
                    String.valueOf(e.getPage())+"," +
                    e.getAuthor().getfirstName()+","+
                    e.getAuthor().getlastName()+"\n");
        }
        fileWriter.write(new String(returnString));
        fileWriter.close();
    }
}
