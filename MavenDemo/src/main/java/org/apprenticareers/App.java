package org.apprenticareers;
import org.apache.commons.lang3.StringUtils;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        String text = "    Hello Maven!    ";

        String trimmed = StringUtils.strip(text);
        String reversed = StringUtils.reverse(trimmed);

        System.out.println(trimmed);
        System.out.println(reversed);
    }
}
