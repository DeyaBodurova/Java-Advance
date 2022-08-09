package Hotel;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public List<Person> roster;
    public String name;
    public int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (name.equals(person.getName()) && hometown.equals(person.getHometown())) {
                return person;
            }
        }
        return null;
    }

    public void add(Person person) {
        if (roster.size() < this.capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the Advance.hotel %s are:%n", this.name));
        for (Person person : roster) {
            sb.append(String.format("%s%n", person.toString()));
        }
        return sb.toString();
    }
}
