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


        File file = new File( "./TR_SuperLeague_19_20.txt");

        CircularQueue q = new CircularQueue(ObjectLength(parser));

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



    }

    static int ObjectLength(JSONParser parser){

        int numOfData = 0;
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("./data.json"));
            for (Object o : a) {
                numOfData++;

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return numOfData;
    }
}