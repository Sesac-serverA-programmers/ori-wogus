import java.util.*;

class 더맵게 {
    /**
     * 해결책 1 -> 효율성테스트 탈락
     * 정렬이 nlogn 이고 while이 n 이므로 n^2logn으로 실패?!
     *
     * 해결책 2 -> 우선순위 큐 최소힙구현 -> 성공
     *  add,poll 의 시간복잡도가 logn 이고 while이 n 이므로 nlogn으로 성공?!
     * */
    int[] scovile = {1, 2, 3, 9, 10, 12};
    int k =  7;


    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //우선순위큐를 이용하여 최소 힙 구현.

        for(int i=0;i<scoville.length;i++) //받은값들을 우선순위큐에 저장한다.
        {
            minHeap.add(scoville[i]);
        }

        while(minHeap.size()>1) //큐에 남은갯수가 2개이상일때까지 반복.
        {
            if(minHeap.peek() >= K) //맨 첫번째 음식의 스코빌이 K보다 크거나 같다면 뒤에있는건 당연히 같으니 종료
            {
                return answer; //해당 횟수 리턴
            }

            int first = minHeap.poll();
            int second = minHeap.poll();
            minHeap.add(first+(second*2));

            answer++;

        }

        if(minHeap.poll() < K) //큐에있는 하나의 음식의 스코빌이 K보다 작다면
        {
            return -1; //-1 리턴
        }





//        실패한 해결책
//        List<Integer> sco
//                = Arrays.stream(scoville).boxed().collect(Collectors.toList()); // primitive 타입인 int를 리스트로 변환하기
//
//
//        while(sco.size()>1) //요소가 1개일때까지 반복
//        {
//
//            Collections.sort(sco);// 오름차순 정렬
//            if(sco.get(0) >= K) // 첫번째 요소가 k보다 나머지도 K보다 클테니까 반복 종료
//            {
//                return answer;
//            }
//            int first = sco.get(0);
//            sco.remove(0);
//
//            int second = sco.get(0);
//            sco.remove(0);
//
//            int new_food = first + (second*2);
//            sco.add(new_food); //맨뒤에 새로만든거 저장.
//
//            answer++;
//
//
//        }
//
//        //요소가 1개일때
//        if(sco.get(0)<K) //한개있는게 k보다 작다면 -1을 리턴
//        {
//            return -1;
//        }
        return answer;
    }

    public static void main(String[] args) {
        더맵게 s = new 더맵게();
        System.out.println(s.solution(s.scovile, s.k)) ;

    }


}
