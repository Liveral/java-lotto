package lotto;
import camp.nextstep.edu.missionutils.Console;

public class DrawLotto {

    public DrawLotto() {
    }


    public void drawingLotto(){
        User user=new User();
        user.setMoneyAndLottoCount(inputMoney());

    }
    public int inputMoney(){
        return Integer.parseInt(Console.readLine());
    }

    public void inputValidate(int money){
        if(money!=Constants.LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
    }

}


