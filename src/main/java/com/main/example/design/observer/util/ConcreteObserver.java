package com.main.example.design.observer.util;

// 실제 옵저버 역할을 수행함
public class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("status changed : "+subject.getState());
    }

}
