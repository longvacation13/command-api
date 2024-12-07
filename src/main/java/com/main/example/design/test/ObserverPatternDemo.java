package com.main.example.design.test;
import java.util.ArrayList;
import java.util.List;

// 주제(Subject) 역할을 하는 클래스
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// 옵저버(Observer) 인터페이스
interface Observer {
    void update();
}

// 실제 옵저버 역할을 하는 클래스
class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("상태가 변경됨: " + subject.getState());
    }
}

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new ConcreteObserver(subject);
        new ConcreteObserver(subject);
        new ConcreteObserver(subject);

        System.out.println("처음 상태: 15");
        subject.setState(15);
        System.out.println("새로운 상태: 30");
        subject.setState(30);
    }
}