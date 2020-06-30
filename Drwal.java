import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drwal {

    private static void drawMe(String s, String feeder) {
        String [] helpArray = s.split("\n");
        int max=0;
        for(String iterator: helpArray){
            if(iterator.length()>max){
                max=iterator.length();
            }
        }
        int[][] array = new int[helpArray.length+1][max+1];

        for(int i=0; i<helpArray.length; i++){
            for(int j=0; j<helpArray[i].length(); j++){
                if (helpArray[i].split("")[j].equals(" ")) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }
        boolean switcher;
        for(int i=0; i<helpArray.length; i++){
            switcher=false;
            for(int j=0; j<max; j++){
                if(array[i][j]==1){
                    for(int k=j+1; k<max; k++){
                        switcher=false;
                        if(array[i][k]==1){
                            switcher=true;
                            break;
                        }
                    }
                }else {
                    if(switcher){
                        array[i][j]=2;
                    }
                }
            }
        }

        for(int i=0; i<helpArray.length; i++){
            for(int j=0; j<max; j++){
                if(array[i][j]==1)
                    System.out.print("#");
                else if(array[i][j]==2)
                    System.out.print(feeder);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void main(String []args) throws IOException {

        if(args.length!=5 || !args[0].matches("[0-9]+") || !args[1].matches("[0-9]+")
                          || !args[3].matches("[0-9]+") || !args[4].matches("[0-9]+")){
            System.out.println("klops");
            return;
        }

        int xStart= Integer.parseInt(args[0]), yStart= Integer.parseInt(args[1]), height= Integer.parseInt(args[3]), weight= Integer.parseInt(args[4]);

        if(xStart>50 || yStart>50){
            System.out.println("klops");
            return;
        }

        if(xStart>height || yStart>weight){
            System.out.println("klops");
            return;
        }


        String feeder=args[2];

        StringBuilder stringBuilder=new StringBuilder();

        String line;
        List<String> list=new ArrayList<>();
        int i=0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            line=scanner.nextLine();
            if (xStart-1 < i && xStart-1 + height > i) {
                if (line.length() > yStart + weight) {
                    list.add(line.substring(yStart, yStart + weight));
                } else {
                    if(yStart>line.length()){

                    }else
                        list.add(line.substring(yStart, line.length()));
                }
            }
            i++;
        }

        for(String s: list){
            stringBuilder.append(s);
            stringBuilder.append("\n");
        }
        drawMe(stringBuilder.toString(), feeder);
    }

}
