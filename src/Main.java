import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
     //   JSONObject j = new JSONObject();

        CircularQueue q = new CircularQueue(ObjectLength(parser));


        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("./data.json"));
            for (Object o : a) {

                JSONObject data = (JSONObject) o;

                Rocket rocket = new Rocket((long) data.get("sicaklik"),(long) data.get("basinc"),(long) data.get("eğim"));


                long sicaklik = (long) data.get("sicaklik");
                long basinc = (long) data.get("basinc");
                long egim = (long) data.get("eğim");

                rocket.updateMeasurements(sicaklik, basinc, egim);
                q.enqueue(rocket);

             //   System.out.println("Sicaklik: " + ((Rocket) q.peek()).getSıcaklık()+ ", Basinc: " +((Rocket) q.peek()).getBasınç()+ ", Eğim: " + ((Rocket) q.peek()).getEğim());

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        datasPrint(q);
       // dataCompare(q,q2);



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

    static void dataCompare(CircularQueue q1 , CircularQueue q2){
        for (int i = 0; i < q1.size(); i++) {
            if(((Rocket) q1.peek()).getBasınç() != ((Rocket) q2.peek()).getBasınç()){

                System.out.println(((Rocket) q1.peek()).getBasınç() +" vs " +  ((Rocket) q2.peek()).getSıcaklık());
                q1.dequeue();
                q2.dequeue();
            }
        }

    }
    static  void datasPrint(CircularQueue q){
        for (int i = 0; i < q.size(); i++) {

               System.out.println("Sicaklik: " + ((Rocket) q.peek()).getSıcaklık()+ ", Basinc: " +((Rocket) q.peek()).getBasınç()+ ", Eğim: " + ((Rocket) q.peek()).getEğim());

            q.dequeue();
        }
    }


}