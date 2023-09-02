package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DrawLottoTest {
    @DisplayName("입력받은 구입 금액이 1000원 단위가 아니면 예외를 발생시킵니다.")
    @Test
    void inputValidate(){
        DrawLotto drawLotto= new DrawLotto();

        assertThatThrownBy(() -> drawLotto.inputValidate(9500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}