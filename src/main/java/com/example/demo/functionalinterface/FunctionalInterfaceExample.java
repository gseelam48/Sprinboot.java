package com.example.demo.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceExample {

    int add(int a, int b);

    default int sub(int a, int b) {
        return a - b;
    }

    default int multi(int a, int b) {
        return a * b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    static int div1(int a, int b) {
        return a / b;
    }
}

class FunctionalInterfaceImpl {
    public static void main(String[] args) {
        FunctionalInterfaceExample example = new FunctionalInterfaceExample() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(example.add(2, 3));
        FunctionalInterfaceExample example1 = (a, b) -> a + b;
        System.out.println(example1.add(2,4));

    }
}
