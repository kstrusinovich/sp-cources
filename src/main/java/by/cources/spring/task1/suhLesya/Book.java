package by.cources.spring.task1.suhLesya;
import by.cources.spring.task1.spring.Wheel;
import org.springframework.beans.factory.annotation.Autowired;

public class Book {

    @Autowired
    private Wheel firstWheel;

    public Book() {
    }

    public Wheel getFirstWheel() {
        return firstWheel;
    }

    public void setFirstWheel(Wheel firstWheel) {
        this.firstWheel = firstWheel;
    }

}
