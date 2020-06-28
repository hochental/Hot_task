import java.util.ArrayList;
import java.util.List;

public class Galaktyka {

    private void galactic(int size, String xy){

        int entry=size;
        int opposite=size;

        switch (xy){
            case "N":
            case "S":
                entry=entry+2;
                opposite=opposite+3;
                break;
            case "W":
            case "E":
                entry=entry+3;
                opposite=opposite+2;
                break;
        }

        boolean[][] array = new boolean[entry+5][opposite+5];

        for(int i=0; i<entry; i++){
            for(int j=0; j<opposite; j++){
                if(i==entry-1 || i==0) {
                    array[i][j]=true;
                }else if(j==opposite-1 || j==0){
                    array[i][j]=true;
                }
            }
        }
        int x=0;
        int y=0;
        boolean isAdding=true;
        boolean isFrontal=false;

        switch (xy){
            case "W":
                array[1][0]=false;
                x=2;
                y=1;
                if(size>1)
                    array[x][y]=true;
                isFrontal=false;
                isAdding=true;
                break;
            case "N":
                array[0][opposite-2]=false;
                x=1;
                y=opposite-3;
                if(size>1)
                    array[x][y]=true;
                isFrontal=true;
                isAdding=true;
                break;
            case "E":
                array[entry-2][opposite-1]=false;
                x=entry-3;
                y=opposite-2;
                if(size>1)
                    array[x][y]=true;
                isFrontal=false;
                isAdding=false;
                break;
            case "S":
                array[entry-1][1]=false;
                x=entry-2;
                y=2;
                if(size>1)
                    array[x][y]=true;
                isFrontal=true;
                isAdding=false;
                break;
        }

        int counter=0;

        if(size>2) {
            do {
                if (isFrontal) {
                    if (isAdding && !array[x + 2][y]) {
                        x++;
                    } else if (!isAdding && !array[x - 2][y]) {
                        x--;
                    } else {
                        isFrontal = !isFrontal;
                    }
                } else {
                    if (isAdding && !array[x][y + 2]) {
                        y++;
                    } else if (!isAdding && !array[x][y - 2]) {
                        y--;
                    } else {
                        isFrontal = !isFrontal;
                        isAdding = !isAdding;
                    }
                }
                array[x][y] = true;
                counter++;
            } while (counter < size * size);
        }
        if(size==2){
            switch (xy){
                case "W":
                    array[x][y++]=true;
                    break;
                case "N":
                    array[x++][y]=true;
                    break;
                case "E":
                    array[x][y--]=true;
                    break;
                case "S":
                    array[x--][y]=true;
                    break;
            }
        }
        int years=0;
        for(int i=0; i<entry; i++){
            for(int j=0; j<opposite; j++){
                if(array[i][j])
                    System.out.print("*");
                else {
                    System.out.print(" ");
                    years++;
                }
            }
            System.out.println();
        }
        System.out.println(years);
    }
    public static void main(String []args){
        Galaktyka main2 = new Galaktyka();
        if(args.length!=1 || !args[0].split("")[0].matches("[0-9]+")){
            System.out.println("klops");
            return;
        }
        int size = Integer.parseInt(args[0].substring(0,args[0].length()-1));
        String directions=args[0].split("")[args[0].length()-1];


        List<String> directionsList = new ArrayList<>();
        directionsList.add("W");
        directionsList.add("N");
        directionsList.add("S");
        directionsList.add("E");

        if(size<0 || size>1000 || !directionsList.contains(directions)){
            System.out.println("klops");
        }else
            main2.galactic(size, directions);
    }

}
