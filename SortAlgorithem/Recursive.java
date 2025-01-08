package SortAlgorithem;

public class Recursive {
//Find the factorial using recursive & iterative approach
    public static void main(String[] args) {
        System.out.println("The factorial is via recursive call"+recursiveFactorial(3));
        System.out.println("The factorial is via iterative call"+iterativeFactorial(3));
    }
    public static int recursiveFactorial (int num){
        if(num == 0){
            return 1;
        }
        return num * recursiveFactorial(num -1);
    }
    public static int iterativeFactorial(int num){
        if(num == 0){
            return 1;
        }
        int factorial =1;
        for(int i=1;i<=num;i++){
            factorial *=i;
        }
        return factorial;
    }
}
