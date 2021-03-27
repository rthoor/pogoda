import java.io.*;
import java.util.*;

public class Workspace {

    public static void main(String[] args) throws IOException {
        Workspace ws = new Workspace();
        //Путь к файлу импорта
        BufferedReader br = new BufferedReader (new FileReader("C://Users//EvveKiNG//Desktop//Files//export.csv"));
        //Путь к файлу экспорта
        BufferedWriter bw = new BufferedWriter(new FileWriter("C://Users//EvveKiNG//Desktop//Files//stat.text"));
        String row;
        int count = 0;
        ArrayList<Data> dataList = new ArrayList<>();
        while((row = br.readLine())!=null){
            if(count>=10){
                Data data = ws.parseData(row);
                dataList.add(data);
            }
            count++;
        }
        br.close();
        ArrayList<String> stat = ws.getStat(dataList);
        stat.toString();
        for(int i = 0; i < stat.size(); i++){
            bw.write(stat.get(i));
            bw.newLine();
        }
        bw.close();
        for(int j = 0; j < dataList.size(); j++){
            dataList.get(j).getDate();
        }
    }

    Data parseData(String row){
        String[] str = row.split(",");
        Data data = new Data(parseDate(str[0]), (int)Double.parseDouble(str[1]), (int)Double.parseDouble(str[2]), (int)Double.parseDouble(str[3]), parseWindDirection(str[4]));
        return data;
    }

    String parseDate(String str){
        String date = "";
        date += str.substring(9, 11) + ":" + str.substring(11, 13) + " " + str.substring(6, 8) + "." + str.substring(4, 6)+ "." + str.substring(0, 4);
        return date;
    }

    String parseWindDirection(String str){
        double degree = Double.parseDouble(str);

        if(degree > 337.5 || degree <= 22.5){
            return "N";
        }
        if(degree > 22.5 && degree <= 67.5){
            return "NE";
        }
        if(degree > 67.5 && degree <= 112.5){
            return "E";
        }
        if(degree > 112.5 && degree <= 157.5){
            return "SE";
        }
        if(degree > 157.5 && degree <= 202.5){
            return "S";
        }
        if(degree > 202.5 && degree <= 247.5){
            return "SW";
        }
        if(degree > 247.5 && degree <= 292.5){
            return "W";
        }
        if(degree > 292.5 && degree <= 337.5){
            return "NW";
        }
        return "";
    }

    ArrayList<String> getStat(ArrayList<Data> datalList) {
        ArrayList<String> stat = new ArrayList<>();
        int avgTemp = 0;
        int avgHum = 0;
        int avgSpeed = 0;

        String theHottest = "";
        int maxTemp = -100;
        String theLowest = "";
        int minHum = 101;
        String theStrongest = "";
        int maxSpeed = -100;

        HashMap<String, Integer> dir = new HashMap<>();
        dir.put("N", 0);
        dir.put("NE", 0);
        dir.put("E", 0);
        dir.put("SE", 0);
        dir.put("S", 0);
        dir.put("SW", 0);
        dir.put("W", 0);
        dir.put("NW", 0);
        String popDir = "";
        int pop = 0;
        for (int j = 0; j < datalList.size(); j++) {
            avgTemp += datalList.get(j).getTemperature();
            avgHum += datalList.get(j).getRelativeHumidity();
            avgSpeed += datalList.get(j).getWindSpeed();

            if(datalList.get(j).getTemperature() > maxTemp){
                maxTemp = datalList.get(j).getTemperature();
                theHottest = datalList.get(j).getDate();
            }
            if(datalList.get(j).getRelativeHumidity() < minHum){
                minHum = datalList.get(j).getRelativeHumidity();
                theLowest = datalList.get(j).getDate();
            }
            if(datalList.get(j).getWindSpeed() > maxSpeed){
                maxSpeed = datalList.get(j).getWindSpeed();
                theStrongest = datalList.get(j).getDate();
            }
            int k = dir.get(datalList.get(j).getWindDirection());
            k++;
            dir.put(datalList.get(j).getWindDirection(), k);
            if(k > pop){
                pop = k;
                popDir = datalList.get(j).getWindDirection();
            }
        }
        avgTemp /= datalList.size();
        avgHum /= datalList.size();
        avgSpeed /= datalList.size();

        if(avgTemp >= 0) {
            stat.add("Средняя температура: +" + avgTemp + "°C");
        }
        else{
            stat.add("Средняя температура: -" + avgTemp + "°C");
        }
        stat.add("Средняя влажность: " + avgHum + "%");
        stat.add("Средняя скорость ветра: " + avgSpeed + " км/ч");

        stat.add("Самая высокая температура была: " + theHottest);
        stat.add("Самая низкая влажность была: " + theLowest);
        stat.add("Самый сильный ветер был: " + theStrongest);

        stat.add("Самое популярное направление ветра(Сорри за инглиш): " + popDir);

        return stat;
    }
}
