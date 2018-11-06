package com.phua.localvariabletypeinference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TypeInference {

    private static void readFile() throws IOException {
        var fileName = "Phua.txt";
        var line = "";
        var fileReader = new FileReader(fileName);
        var bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void var() { // syntactically correct

        var numbers = List.of(1, 2, 3, 4, 5); // inferred value ArrayList<String>

        // Index of Enhanced For Loop
        for (var number : numbers) {
            System.out.println(number);
        }

        var map1 = new HashMap(); // Inferred as HashMap
        var map2 = new HashMap<>(); // Inferred as HashMap<Object, Object>

        var person = new Object() {
            class Name {
                String firstName;
                String lastName;

                Name(String firstName, String lastName) {
                    super();
                    this.firstName = firstName;
                    this.lastName = lastName;
                }

                String getFirstName() {
                    return firstName;
                }

                public void setFirstName(String firstName) {
                    this.firstName = firstName;
                }
            }

            Name name;

            public String displayName() {
                return name.getFirstName() + " " + name.lastName;
            }
        };
        person.name = person.new Name("Phua", "Test");
        System.out.println(person.displayName());
    }


}
