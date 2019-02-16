package oop;

enum EnumTest {
    ONE(1), TWO(2), THREE(3){
        @Override
        public boolean isRest() {
            return true;
        }
    };

    private int value;
    private EnumTest(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public boolean isRest(){
        return false;
    }
}

public class OOPEnumTest{
    public static void main(String[] args){
        System.out.println(EnumTest.valueOf("ONE"));
        System.out.println(EnumTest.THREE.isRest());
        System.out.println(EnumTest.THREE.getValue());
        System.out.println(EnumTest.THREE.name());
    }
}