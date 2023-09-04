package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ExceptionHandling {
    public static void isInputMoneyZero(String input){
        if(Integer.parseInt(input)==0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원보다 커야합니다.");
        }
    }


    public static void isInputNumbers(String input){

        if(!input.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException("[ERROR] 입력된 형식이 올바르지 않습니다(숫자를 입력하세요).");
        }
    }
    public static void inputMoneyValidate(int money) {
        if (money%1000!=0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
    }

    public static void isInputHasCommas(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 입력된 형식이 올바르지 않습니다(번호를 쉼표(,)를 기준으로 구분하여 입력하세요).");
        }
    }

    public static void inputNumbersValidate(String inputString) {
        //","가 포함되지 않은 입력이면 예외처리
        isInputHasCommas(inputString);

        String[] inputs = inputString.split(",");
        //쉼표(,)로 구분된 문자열이 하나라도 숫자가 아니라면 예외처리
        for (String num : inputs) {
            isInputNumbers(num);
        }

    }
}
