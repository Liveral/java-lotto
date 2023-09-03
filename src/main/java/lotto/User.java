package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int money; //사용자의 구입 금액
    private int lottoCount; // 사용자가 구매한 로또의 개수
    private final List<List<Integer>> userLottos = new ArrayList<>(); //사용자가 가지고 있는 로또의 리스트
    private int[] ranks=new int[Constants.LOTTO_NUMBER_SIZE]; // 사용자가 각 등수를 몇번 했는지 기록할 배열.
    private long winnings=0; //사용자의 당첨금


    public void setWinnings(long money) {
        winnings+=money;
    }
    public void setRanks(int rank){
        ranks[rank]++;
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
    public void printLottoResult(){
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.printf("3개 일치 (%s원) - %d개\n",df.format(Result.getReward(3)),ranks[5]);
        System.out.printf("4개 일치 (%s원) - %d개\n",df.format(Result.getReward(4)),ranks[4]);
        System.out.printf("5개 일치 (%s원) - %d개\n",df.format(Result.getReward(5)),ranks[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n",df.format(Result.getReward(10)),ranks[2]);
        System.out.printf("6개 일치 (%s원) - %d개\n",df.format(Result.getReward(6)),ranks[1]);
    }
}
