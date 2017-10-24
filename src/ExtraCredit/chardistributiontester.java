package ExtraCredit;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by dk on 10/14/2017.
 */
public class chardistributiontester {
    public static void main(String[] args) throws FileNotFoundException {

        CharDistribution cd = new CharDistribution();

        File file = new File("employee.txt");
        int[] arr = cd.charCounting(file);

        cd.print(arr);
    }
}
