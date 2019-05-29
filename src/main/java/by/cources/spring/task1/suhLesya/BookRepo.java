package by.cources.spring.task1.suhLesya;

import by.cources.spring.task1.spring.Car;
import by.cources.spring.task1.spring.Main;
import by.cources.spring.task1.spring.Wheel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookRepo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ctx.getBean("firstWheel", Wheel.class).rotate();
        ctx.getBean(Car.class).go();
    }
}
