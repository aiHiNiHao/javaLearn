package designmode;

public class DecoratorModeTest {
    public static void main(String[] args) {
        Man man = new Man();
        ManDecorator manDecorator = new ManDecorator();
        manDecorator.setPerson(man);
        ManManDecorator manManDecorator = new ManManDecorator();
        manManDecorator.setPerson(manDecorator);
        manManDecorator.eat();
    }


    interface Person {
        void eat();
    }

    static class Man implements Person {
        @Override
        public void eat() {
            System.out.println("eat");
        }
    }

    static abstract class PersonDecorator implements Person {
        private Person person;

        public void setPerson(Person person) {
            this.person = person;
        }

        @Override
        public void eat() {
            person.eat();
        }
    }

    static class ManDecorator extends PersonDecorator {
        @Override
        public void eat() {
            super.eat();
            System.out.println("eat once age");
        }
    }

    static class ManManDecorator extends PersonDecorator {
        @Override
        public void eat() {
            super.eat();
            System.out.println("eat 饱饱了");
        }
    }
}
