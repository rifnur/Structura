Абстрактная фабрика

public interface CarsFactory {
    Sedan createSedan();
    Hatchback createHatchback();
}

public class LadaFactory implements CarsFactory {}

public class UazFactory implements CarsFactory {}


public class LadaFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  LadaSedan();
    }

    @Override
    public Hatchback createHatchback() {
        return new LadaHatchback();
    }
}

public class UazFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new  UazSedan();
    }

    @Override
    public Hatchback createHatchback() {
        return new UazHatchback();
    }
}

public interface Sedan {}

public interface Hatchback {}


public class LadaHatchback implements Hatchback {
    public LadaHatchback() {
        System.out.println("Создаем LadaHatchback");
    }
}

public class LadaSedan implements Sedan {
    public LadaSedan() {
        System.out.println("Создаем LadaSedan");
    }
}

public class UazHatchback implements Hatchback {
    public UazHatchback () {
        System.out.println("Создаем UazHatchback");
    }
}

public class UazSedan implements Sedan {
    public UazSedan() {
        System.out.println("Создаем UazSedan");
    }
}