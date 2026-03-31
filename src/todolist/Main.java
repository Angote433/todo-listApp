package todolist;

import java.time.LocalDateTime;

public class Main {
    static void main() {
        Operations op = new Operations();
        op.createTask("Gym","Go to gym", LocalDateTime.of(2024, 12, 25, 10, 30, 0));
        op.createTask("Kitchen","Prepare dinner",LocalDateTime.of(2024, 12, 25, 10, 30, 0));

        op.viewAllTasks();
    }
}
