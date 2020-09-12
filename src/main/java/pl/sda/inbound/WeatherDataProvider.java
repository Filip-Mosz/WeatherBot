//to działą
//ToDo zaglębić się, żeby wykorzystać to i wysłać do bazy
package pl.sda.inbound;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

//public class WeatherDataProvider {
//    public static String requestCurrentData() throws IOException {
//
//        BufferedReader in = null;
//        BufferedWriter out = null;
//        StringBuilder result = new StringBuilder();
//
//        try {
//            in = new BufferedReader(new FileReader("src/main/resources/city.list.json"));
//            out = new BufferedWriter(new FileWriter("user_output.txt"));
//
//            String line;
//            while ((line = in.readLine()) != null) {
//                out.write(line);
//                result.append(line);
//            }
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }
//        return result.toString();
//    }
//}
public class WeatherDataProvider {

    public static String requestCurrentData(String urlAsString) throws IOException {
        URL url = new URL(urlAsString);
        try (InputStream in = url.openStream()) {
            byte[] bytes = in.readAllBytes();
            return new String(bytes, Charset.defaultCharset());
        }
    }
}
