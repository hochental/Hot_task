public class Kosmolot {


    private void generateLab(int size, boolean aromur){


        boolean[][] array = new boolean[size+(size-1)+1][(int) Math.pow(size, 2)+1];

        int tempSize;

        for(int y=0; y<Math.pow(size, 2); y=y+size) {
            tempSize = size-1;
            for (int i = 0; i <= size + (size - 1)+1; i++) {
                if (i < (size+(size-1))/2+1) {
                    for (int j = i; j >= 0; j--) {
                        array[i][j+y]=true;
                    }
                } else {
                    for (int j = tempSize-1; j >= 0; j--) {
                        array[i][j+y]=true;
                    }
                    tempSize--;
                }
            }
        }

        if(aromur){
            for(int i=0; i<=size+(size-1)-1; i++){
                for(int j=0; j<=(int) Math.pow(size, 2); j++){
                    if(j==0 || j==(int) Math.pow(size, 2)-1 && array[i][j]){
                        System.out.print(">");
                    }
                    else if(array[i][j] && array[i][j+1])
                        System.out.print("*");
                    else if(array[i][j] && i<size)
                        System.out.print("\\");
                    else if(array[i][j] && i>=size)
                        System.out.print("/");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }else{
            for(int i=0; i<=size+(size-1); i++){
                for(int j=0; j<=(int) Math.pow(size, 2); j++){
                    if(array[i][j])
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Kosmolot main = new Kosmolot();
        if(args.length!=2 || !args[0].matches("[0-9]+")){
            System.out.println("klops");
            return;
        }
        int size = Integer.parseInt(args[0]);
        String armour = args[1];
        if (size > 0 && size < 75 && (armour.equals("N") || armour.equals("Y"))) {
            if (armour.equals("N")) {
                main.generateLab(size, false);
            } else {
                main.generateLab(size, true);
            }
        } else {
            System.out.println("klops");
        }
    }
}
