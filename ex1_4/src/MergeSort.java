import java.io.*;
import java.util.*;

public class MergeSort {

    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left, int right){
        int i = 0;
        int l = 0;
        int r = 0;
        while(l<left && r<right){
            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left){
            arr[i++] = left_arr[l++];
        }
        while(r<right){
            arr[i++] = right_arr[r++];
        }
    }

    public static void mergeSort(int [] arr, int len){
        if (len < 2){
            return;
        }
        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k++;
            }
        }
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
        merge(left_arr,right_arr,arr,mid,len-mid);
    }

    public static void solve(InputReader in, PrintWriter out) {
        int N = in.nextInt();
        int arr[] = new int[N];
        for(int j = 0; j<N; j++){
            arr[j] = in.nextInt();
        }
        mergeSort(arr, N);
        out.print("Результат сортировки: ");
        for(int j = 0; j<N; j++){
            out.print(arr[j] + " ");
        }
    }

    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            inputStream = new FileInputStream("input.txt");
            outputStream = new FileOutputStream("output.txt");
        } catch (Exception e) {
            inputStream = System.in;
            outputStream = System.out;
        }

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        solve(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}