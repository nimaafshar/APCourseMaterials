import java.util.Scanner;

public class Main {

    static int search(int arr[], int left,int right,int query) {
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == query) {
                return mid;
            }

            if (arr[mid] < query) {
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[] arr = new int[m+1];
        for(int i=0;i<m;i++) {
            arr[i] = s.nextInt();
        }
        for (int i=1;i<=n;i++ ){
            int x = s.nextInt();
            int res = search(arr,0,m-1,x);
            if (res==-1) {
                System.out.println("not found");
            }
            else {
                System.out.println(res);
            }
        }
    }
}
