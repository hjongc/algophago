import java.io.*;
import java.util.StringTokenizer;
class q1924 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int month = Integer.parseInt(st.nextToken());
        int date = Integer.parseInt(st.nextToken());
        int total_date = 0;
        switch(month){
            case 12: total_date += 30;
            case 11: total_date += 31;
            case 10: total_date += 30;
            case 9: total_date += 31;
            case 8: total_date += 31;
            case 7: total_date += 30;
            case 6: total_date += 31;
            case 5: total_date += 30;
            case 4: total_date += 31;
            case 3: total_date += 28;
            case 2: total_date += 31;
        }
        total_date += (date-1);
        switch(total_date % 7){
            case 0: bw.write("MON"); break;
            case 1: bw.write("TUE"); break;
            case 2: bw.write("WED"); break;
            case 3: bw.write("THU"); break;
            case 4: bw.write("FRI"); break;
            case 5: bw.write("SAT"); break;
            case 6: bw.write("SUN"); break;
        }
        bw.flush();
    }
}
