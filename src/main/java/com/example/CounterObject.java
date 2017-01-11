package com.example;

public class CounterObject {

    public enum Counter {

        VALUE(0);

        public int value;

        Counter(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public CounterObject() {
        Counter.VALUE.value += 1000;
    }

}
