package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DrawLotto {

    public DrawLotto() {
    }


    public void drawingLotto() {
        User user = new User();
        user.setMoneyAndLottoCount(inputMoney()); //구입 금액을 입력받고 1000원 단위가 맞다며 해당 금액과 금액/1000 한 값을 user객체의 setter함수에 전달한다.
        user.setUserLottos(getLottoTickets(user.getLottoCount())); //사용자가 가진 구입가능 티켓 숫자를 넘겨부면 getLottoTickets 함수에서 그 수만큼 로또를 발행해준다.
    }

    public int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public void inputValidate(int money) {
        if (money != Constants.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
    }

}


