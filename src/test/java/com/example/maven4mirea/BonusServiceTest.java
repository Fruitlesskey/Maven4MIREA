package com.example.maven4mirea;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusServiceTest {

  @Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные:
    long amount = 1000;
    boolean registered = true;
    long expected = 30;
    // ызываем целевой метод:
    long actual = service.calculate(amount,
        registered);
    // производим проверку (сравниваем ожидаемый и
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = true;
    long expected = 500;
    // вызываем целевой метод:
    long actual = service.calculate(amount,
        registered);
    // производим проверку (сравниваем ожидаемый и
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForNotRegisteredAndUnderLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные:
    long amount = 10000;  // Сумма покупки, при которой бонус будет меньше 500
    boolean registered = false;
    long expected = 100;  // 1% от 10000

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForNotRegisteredAndOverLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные:
    long amount = 100_000;  // Сумма покупки, при которой 1% превышает лимит
    boolean registered = false;
    long expected = 500;  // Максимальный бонус

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }
}