package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        user.getLottoTickets(); //사용자가 가진 구입가능 티켓 숫자만큼 getLottoTickets 함수에서 로또를 발행 및 번호 출력.
        System.out.println("당첨 번호를 입력해 주세요.");
        lotto = new Lotto(inputNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        lotto.setBonusNumber(inputBonusNumber());


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
        String[] str = input.split(",");
        for (int i = 0; i < input.length(); i++) {
            numbers.add(str[i].charAt(0) - '0');
        }

        return numbers;
    }
    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();

        ExceptionHandling.isInputNumbers(bonusNumber); //입력한 보너스 번호가 숫자형식인지 확인
        return Integer.parseInt(bonusNumber);
    }

    public void playDrawing() {

    }

}


