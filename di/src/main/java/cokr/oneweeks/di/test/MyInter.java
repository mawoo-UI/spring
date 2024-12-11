package cokr.oneweeks.di.test;

@FunctionalInterface
public interface MyInter {
    Integer run(String str);

    default Integer de(String str) {
        return Integer.parseInt(str);
    }

    static Integer sm(String str) {
        return Integer.parseInt(str);
    }
}
