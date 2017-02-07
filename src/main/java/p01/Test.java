package p01;

public class Test {
    public static void main(String[] args) {
        IPAddressValidator addrValid = new  IPAddressValidator();
        System.out.println(addrValid.validate("0.0.0.q"));
    }
}
