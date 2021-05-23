package Java_level_1.git.Lesson_6;

public class Cats extends Animals {
    public static int countCat = 0;

    Cats(String name, float maxRun, float maxSwim) {
        super("Пес", name, maxRun, maxSwim);
        ++countCat;
    }
    @Override
    public int swim(float distance) { return Animals.SWIM_NONE ;}
}
