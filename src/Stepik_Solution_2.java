import java.util.*;
import java.util.stream.Collectors;

public class Stepik_Solution_2 {
    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("User1","KazNITU"),
                new LogEntry("User2","KazNITU"),
                new LogEntry("User3","KazNITU2"),
                new LogEntry("User3","KazNITU3"),
                new LogEntry("User4","KazNITU2"));
        Map<String, Long> clickCount = logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
        System.out.println(clickCount.toString());
    }
}

class LogEntry {
    private Date created = new Date();
    private String login;
    private String url;
    public LogEntry(String login, String url){
        this.login = login;
        this.url = url;
    }
    public Date getCreated(){
        return created;
    }
    public String getLogin(){
        return login;
    }
    public String getUrl(){
        return url;
    }
}
