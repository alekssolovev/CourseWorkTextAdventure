import java.util.HashMap;
import java.util.Map;

public class MenuInvoker {
    private final Map<String, Command> commands; //мапа с командами

    public MenuInvoker() {
        commands = new HashMap<>();
    }

    public void setCommand(String commandName, Command command) {
        commands.put(commandName, command);
    } //сеттер

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        }
    }

    public void undoCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.undo();
        }
    }
}
