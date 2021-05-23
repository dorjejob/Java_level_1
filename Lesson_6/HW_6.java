package Java_level_1.git.Lesson_6;

public class HW_6 {
<<<<<<< HEAD

    public static void main(String[] args) {
        String tempWinEvent = "Это получилось";
        String tempLossEvent = "Это не получилось";
        String eventName;
        String eventResult;

        Cats cat1 = new Cats("Барсик", 200, 1);
        Cats cat2 = new Cats("Мурзик", 400, 1);
        Dogs dog1 = new Dogs("Тузик", 500,10);
        Dogs dog2 = new Dogs("Бобик", 350,6);

        Animals[] animals = {cat1, cat2, dog1, dog2};

        float runLength = 250;
        float swimLength =8;

        for (int i = 0; i < animals.length; i++) {
            String nameString = animals[i].getType() + "" + animals[i].getName() + " может ";

            eventName = "пробежать на " + animals[i].getMaxRun() + " м. Пытается пробежать на ";
            eventResult = animals[i].run(runLength) ? tempWinEvent : tempLossEvent;
            result(nameString,eventName,runLength,eventResult);

            int swimResult = animals[i].swim(swimLength);
            eventName = "Проплыть на " + animals[i].getMaxSwim() + " м. Попытка проплыть на ";
            eventResult = (swimResult == Animals.SWIM_OK) ? tempWinEvent : tempLossEvent;

            if (swimResult == Animals.SWIM_NONE)
                eventResult = "Это не получилось т.к. не умеет плавать";
            result(nameString, eventName, swimLength, eventResult);
        }
        System.out.println("All animals " + Animals.countAnimal + " > cat count = " + Cats.countCat + " >dog count = " + Dogs.countDog);

    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + " м и" + resultEvent);
    }

=======
>>>>>>> HW_2
}
