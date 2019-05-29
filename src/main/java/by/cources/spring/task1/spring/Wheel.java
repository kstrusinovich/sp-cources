package by.cources.spring.task1.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Wheel {

  @Autowired
  private Car owner;

  public Car getOwner() {
    return owner;
  }

  public void setOwner(Car owner) {
    this.owner = owner;
  }

  public void rotate() {
    System.out.println(owner);
    // change position of car
  }
}