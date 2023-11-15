import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Clock;

public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
     //   JSONObject j = new JSONObject();

        CircularQueue q = new CircularQueue(45);
        File file = new File( "./TR_SuperLeague_19_20.txt");

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("./data.json"));
            for (Object o : a) {
              //  System.out.println(o);
                JSONObject data = (JSONObject) o;

                long sicaklik = (long) data.get("sicaklik");
                long basinc = (long) data.get("basinc");
                long egim = (long) data.get("eğim");

                System.out.println("Sicaklik: " + sicaklik + ", Basinc: " + basinc + ", Eğim: " + egim);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

/*
        try {
            Object obj = parser.parse(new FileReader("./data.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            String sıcaklık = (String) jsonObject.get("sicaklik");
            System.out.println(sıcaklık);
        }catch (Exception e){
             e.printStackTrace();
        }*/

    //    BufferedReader reader;
    //    reader = new BufferedReader(new FileReader(file));
    //    String line = reader.readLine();

      //  line = reader.readLine();

    }

    static int ObjectLength(JSONParser parser){

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("./data.json"));
            for (Object o : a) {
                //  System.out.println(o);
                JSONObject data = (JSONObject) o;

                long sicaklik = (long) data.get("sicaklik");
                long basinc = (long) data.get("basinc");
                long egim = (long) data.get("eğim");

                System.out.println("Sicaklik: " + sicaklik + ", Basinc: " + basinc + ", Eğim: " + egim);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}