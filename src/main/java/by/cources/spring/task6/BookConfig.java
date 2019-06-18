package by.cources.spring.task6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @Configuration Она сообщает контейнеру Spring, что это класс конфигурации,
// содержащий определения и зависимости bean-компонентов
@PropertySource("classpath:task6/database.properties")
// @PropertySource  Свойства представлены набором объектов PropertySource
// и значения в итоге получаются из тех же источников, как System.getProperties() и System.getenv()
@ComponentScan("by.cources.spring.task6")
// @ComponentScan Для того, чтобы ваша конфигурация могла знать о компонентах
// и вы могли бы их использовать
@Import({
    BookJpaConfig.class,
    BookWebConfig.class,
    BookSecurityConfig.class
})
// @Import Создавая конфигурацию, можно также её разбивать на составные части, что также улучшит читабельность
// и панимание архитектуры вашего приложения.
// Для этого в конфигурацию необходимо добавить аннотацию @Import,
// в параметрах которой указываются другие классы с аннотацией @Configuration
public class BookConfig {

}
