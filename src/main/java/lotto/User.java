package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money; //사용자의 구입 금액
    private int lottoCount; // 사용자가 구매한 로또의 개수
    private List<List<Integer>> userLottos; //사용자가 가지고 있는 로또의 리스트

    public User() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoneyAndLottoCount(int money) {
        this.money = money;
        this.lottoCount=money/1000;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setUserLottos(List<List<Integer>> lottoTicket) {
       this.userLottos = lottoTicket;
    }

    public void getLottoTickets() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(numbers);
        }
    }
}
