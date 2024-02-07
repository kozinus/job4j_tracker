package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    public void whenItemWasFound() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Name");
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(output);
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findByName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasNotFound() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByNameAction findByName = new FindByNameAction(output);

        Input input = mock(Input.class);

        findByName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by name ===" + ln
                        + "Заявки с именем: null не найдены" + ln
        );
    }
}