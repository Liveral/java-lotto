package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {

    @DisplayName("입력받은 당첨 번호에 쉼표(,)가 없다면 예외를 발생시킵니다.")
    @Test
    void isInputHasCommas(){
        assertThatThrownBy(() -> ExceptionHandling.isInputHasCommas("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨 번호에 숫자가 아닌 문자가 들어있으면 예외를 발생시킵니다.")
    @Test
    void isInputNumbers(){
        assertThatThrownBy(() -> ExceptionHandling.isInputNumbers("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 구입 금액이 1000원 단위가 아니면 예외를 발생시킵니다.")
    @Test
    void inputMoneyValidate(){
        assertThatThrownBy(() -> ExceptionHandling.inputMoneyValidate(9500))
                .isInstanceOf(IllegalArgumentException.class);
    }


}