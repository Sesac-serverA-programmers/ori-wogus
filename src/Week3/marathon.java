package Week3;

import java.util.Arrays;
import java.util.Collections;

public class marathon {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Collections.sort(Arrays.asList(participant));  // Collections.sort는 최악 nlogn     // Arrays.sort는 최악 n^2  //둘다 통과는됨
        Collections.sort(Arrays.asList(completion));

        for(int i=0;i<participant.length-1;i++)
        {
            if(!participant[i].equals(completion[i]))
            {
                return participant[i];
            }
        }
        answer = participant[participant.length-1];


        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant,completion));


    }


}
