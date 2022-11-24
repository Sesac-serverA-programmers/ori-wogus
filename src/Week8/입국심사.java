package Week8;

import java.util.Arrays;

public class 입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        int left = 1;
        int right = n * (times[times.length - 1]);

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }


        return answer;
    }

}
