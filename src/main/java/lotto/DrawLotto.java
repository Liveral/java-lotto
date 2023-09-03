package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawLotto {

    public DrawLotto() {
    }


    public void drawingLotto() {
        User user = new User();
        Lotto lotto;

        System.out.println("구입금액을 입력해 주세요.");
        user.setMoneyAndLottoCount(inputMoney()); //구입 금액을 입력받고 1000원 단위가 맞다면 그 값을 전달
        user.getLottoTickets(); //사용자가 가진 구입가능 티켓 숫자만큼 getLottoTickets 함수에서 그 수만큼 로또를 발행 및 결과 출력.
        System.out.println("당첨 번호를 입력해 주세요.");
        lotto=new Lotto(inputNumbers());


    }

    public int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }

    public void inputMoneyValidate(int money) {
        if (money != Constants.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
    }

    public List<Integer> inputNumbers(){
        String input=Console.readLine();
        inputNumbersValidate(input);

        //입려한 문자열을 쉼표단위로 split한 후, List에 int값으로 변환 후 넣는다.
        List<Integer> numbers=new ArrayList<>();
        String[] str=input.split(",");
        for (int i=0;i<input.length();i++){
            numbers.add(str[i].charAt(0)-'0');
        }

        return numbers;
    }

    public void inputNumbersValidate(String inputString){
        //","가 포함되지 않은 입력이면 예외처리
        isInputHasCommas(inputString);

        String[] inputs=inputString.split(",");
        //쉼표(,)로 구분된 문자열이 하나라도 숫자가 아니라면 예외처리
        for (String num : inputs){
            isInputNumbers(num);
        }

    }
    public void isInputHasCommas(String input){
        if(!input.contains(",")){
            throw new IllegalArgumentException("[ERROR] 입력된 형식이 올바르지 않습니다(번호를 쉼표(,)를 기준으로 구분하여 입력하세요).");
        }
    }

    public void isInputNumbers(String input){
        try {
            int number=Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 입력된 형식이 올바르지 않습니다(숫자를 입력하세요).");
            throw e;
        }
    }

}


