package Java_level_1.git.Lesson_6;

public class Dogs extends Animals {
    public static int countDog = 0;

    Dogs(String name, float maxRun, float maxSwim) {
        super("Пес", name, maxRun, maxSwim);
        ++countDog;
    }

}
