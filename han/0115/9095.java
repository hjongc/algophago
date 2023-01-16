import java.io.*;
class q9095 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            int test_case = Integer.parseInt(br.readLine());
            System.out.println(plus123(test_case));
        }
    }
    public static int plus123(int i){
        if (i == 1) return 1;
        else if (i == 2) return 2;
        else if (i == 3) return 4;
        else return plus123(i-1) + plus123(i-2) + plus123(i-3);
    }
}
