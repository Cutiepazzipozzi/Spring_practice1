package spring.practice.controller;

public class MemberForm {
    private String name;
    private int age;

    private Long id;

    private static long sequence = 0L;

    public void setId() {
        this.id = ++sequence;
    }
    public Long getId() { return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
