package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact.calc(-2);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenSucceed() {
        assertThat(Fact.calc(5)).isEqualTo(120);
    }
}