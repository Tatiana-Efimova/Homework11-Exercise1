import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.border.TitledBorder;

public class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Выполнить задание 1");
        boolean expected = true;
        boolean actual = task.matches("Выполнить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(1, "Выполнить задание 1");
        boolean expected = false;
        boolean actual = task.matches("Не выполнить");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testForGetterTitle() {
        SimpleTask title = new SimpleTask(2, "Задача");
        Assertions.assertEquals("Задача", title.getTitle());
    }


    @Test
    public void testMeetingMatchesTopic() {
        Meeting task = new Meeting(3, "Запуск тестовой версии", "Приложение", "август");
        boolean expected = true;
        boolean actual = task.matches("Запуск");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting task = new Meeting(3, "Запуск тестовой версии", "Приложение", "август");
        boolean expected = true;
        boolean actual = task.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting task = new Meeting(4, "Запуск тестовой версии", "Приложение", "август");
        boolean expected = false;
        boolean actual = task.matches("Тесты");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Проверить", "Согласовать", "Выполнить"};
        Epic task = new Epic(15, subtasks);
        boolean expected = true;
        boolean actual = task.matches("Выполнить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Проверить", "Согласовать", "Выполнить"};
        Epic task = new Epic(15, subtasks);
        boolean expected = false;
        boolean actual = task.matches("Не выполнить");

        Assertions.assertEquals(expected, actual);
    }

}
