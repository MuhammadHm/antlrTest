package GeneratedCode.sample1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Address {
    //Attributes
    public static String Country;
    public static String City;

    public static ArrayList<Address> data = new ArrayList<>();

    String joinPredicate;

    //Methods


    public ArrayList<Address> getData() {
        return data;
    }

    public void setData(ArrayList<Address> data) {
        this.data = data;
    }

    public static void loadData() {
        if (data.isEmpty()) {
            if (true) {
                Address Address0 = new Address();
                data.add(Address0);
            }

        }
    }

}