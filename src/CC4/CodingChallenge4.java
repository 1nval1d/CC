package CC4;
// Link zu Jar: http://central.maven.org/maven2/org/json/json/20180130/json-20180130.jar
// Maven: http://mvnrepository.com/artifact/org.json/json
// Git: https://github.com/stleary/JSON-java
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CodingChallenge4 {
    public static void main(String[] args) throws Exception{
        //Zeitmessung
        long collectionsStart, collectionsEnd;

        //Einlesen der JSON zum String
        Scanner jsonScanner = new Scanner(new File("4.json"));
        StringBuilder sb = new StringBuilder();
        while(jsonScanner.hasNextLine()){
            sb.append(jsonScanner.nextLine());
        }
        String json = sb.toString();

        //JSON zu List
        JSONObject jsonObject = new JSONObject(json);
        int k = jsonObject.getInt("k");
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        List<Object> dataList = jsonArray.toList();

        //Rotation
        k %= dataList.size();
        collectionsStart = System.nanoTime();
        Collections.rotate(dataList, k);
        collectionsEnd = System.nanoTime();

        //Ausgabe
        System.out.println(collectionsEnd-collectionsStart);
        System.out.println(k);
    }
}
