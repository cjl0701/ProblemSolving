package BruteForce;
//소수찾기 더 빠른 버전
import java.util.HashSet;

//길이 m 미만의 모든 조합을 만들기 위해, 선택할 때마다 저장
//중복 체크로 해시맵을 활용!(배열로 표현하면 7자리 숫자의 인덱스가 되므로 메모리 크기가 커진다) hashset을 써도 된다.
//교훈: 다른 풀이에서 얻은 인사이트가 도움이 되는구나!
public class Q2_2 {
    static int[] nums;
    static int cnt = 0;
    static boolean[] check;
    static HashSet<Integer> newNum = new HashSet<>();

    static boolean isPrime(int n) {//애초에 짝수 거르고 i+=2씩 증가하는 방법이 더 효율적이다.
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    static void go(int num, int idx) {
        if (!newNum.contains(num)) {//새로운 수
            newNum.add(num);
            if (isPrime(num)) cnt++;
        }
        if (idx == nums.length) return;//다 썼다.
        for (int i = 0; i < nums.length; i++) {
            if (check[i]) continue;
            check[i] = true;//선택
            go(num * 10 + nums[i], idx + 1);
            check[i] = false;//선택x
        }
    }

    static public int solution(String numbers) {
        //숫자 재료로 만들기
        nums = new int[numbers.length()];
        check = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++)
            nums[i] = numbers.charAt(i) - '0';
        go(0, 0);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}
