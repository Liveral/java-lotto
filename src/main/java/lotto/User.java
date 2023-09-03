package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int money; //사용자의 구입 금액
    private int lottoCount; // 사용자가 구매한 로또의 개수
    private final List<List<Integer>> userLottos = new ArrayList<>(); //사용자가 가지고 있는 로또의 리스트
    private int winnings=0; //사용자의 당첨금

    public void getWinnings(int money) {
        winnings+=money;
    }

    public User() {
    }

    public int getMoney() {
        return money;
    }
    public List<Integer> getUserLottos(int index){
        return userLottos.get(index); //index번째 로또를 return 해준다.
    }
    public void setMoneyAndLottoCount(int money) {
        this.money = money;
        this.lottoCount = money / 1000;

        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }


    public void setLottoTickets() {

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(numbers);
        }

        printLottoTickets();
    }

    public void printLottoTickets() {
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(userLottos.get(i).toString());
        }
    }
}
