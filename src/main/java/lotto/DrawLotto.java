package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawLotto {
    User user;
    Lotto lotto;

    public DrawLotto() {
    }

    public void drawingLotto() {
        user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        user.setMoneyAndLottoCount(inputMoney()); //구입 금액을 입력하면 user객체에 구입 금액과 구매할 로또의 개수가 setting된다.
        user.setLottoTickets(); //사용자가 가진 구입가능 티켓 숫자만큼 setLottoTickets 함수에서 로또를 발행 및 번호 출력.
        System.out.println("당첨 번호를 입력해 주세요.");
        lotto = new Lotto(inputNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        lotto.setBonusNumber(inputBonusNumber());
        checkWinning(); // 당첨 확인
        System.out.println("당첨 통계\n---");
        user.printLottoResult();
        user.printProfit();

    }

    public int inputMoney() {
        String money = Console.readLine();
        ExceptionHandling.isInputNumbers(money);
        ExceptionHandling.inputMoneyValidate(Integer.parseInt(money));

        return Integer.parseInt(money);
    }

    public List<Integer> inputNumbers() {
        String input = Console.readLine();
        ExceptionHandling.inputNumbersValidate(input);

        //입려한 문자열을 쉼표단위로 split한 후, List에 int값으로 변환 후 넣는다.
        List<Integer> numbers = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String[] str = input.split(",");
        for (int i = 0; i < str.length; i++) {
            numbers.add(str[i].charAt(0) - '0');
        }


        return numbers;
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        ExceptionHandling.isInputNumbers(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void checkWinning() {
        for (int i=0;i<user.getLottoCount();i++){
            compareNumbers(lotto.getNumbers(),user.getUserLottos(i)); //당첨 번호와 사용자의 i번째 로또를 비교한다.
        }
    }
    public void compareNumbers(List<Integer> lotto, List<Integer> userLotto){
        int hasNumber=0;    //사용자의 로또에 포함된 당첨 번호의 수.

        for (int i=0;i<Constants.LOTTO_NUMBER_SIZE;i++){
            if(lotto.contains(userLotto.get(i))){
                hasNumber++;
            }
        }

        if(hasNumber==5){
            hasNumber+=hasBonusNumber(userLotto); //5개 일치한다면 보너스 번호도 확인해야 한다. 보너스번호가 없으면 0을 더해주고, 있으면 보너스 점수를 더해준다.
        }

        getMoney(hasNumber);

    }
    public int hasBonusNumber(List<Integer> userLotto){
        if(userLotto.contains(lotto.getBonusNumber())){
            return Constants.BONUS_SCORE; //보너스 번호가 있다면 보너스 점수 return
        }

        return 0;
    }
    public void getMoney(int hasNumber){
       user.setWinnings(Result.getReward(hasNumber));
       user.setRanks(Result.getRanking(hasNumber));
    }

}


