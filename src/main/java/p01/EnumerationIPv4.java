package p01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EnumerationIPv4 {
    public static void main(String[] args) throws UnknownHostException {
        Scanner ans = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Введите первый Ip адрес:");
            Scanner sc1 = new Scanner(System.in);
            String adr1 = sc1.nextLine();

            System.out.println("Введите второй Ip адрес:");
            Scanner sc2 = new Scanner(System.in);
            String adr2 = sc2.nextLine();

            new EnumerationIPv4().go(adr1, adr2);

            System.out.print("Повторить? (да/нет): ");
            answer = ans.nextLine();
        } while (answer.equals("да"));
    }


    private void go(String address1, String address2) {
        IPAddressValidator addrValid = new IPAddressValidator();
        boolean b1 = addrValid.validate(address1);
        boolean b2 = addrValid.validate(address2);
        if (!b1 || !b2) {
            System.err.println("Введите верный формат Ip адреса");
            return;
        }

        long numb1 = ipToLong(address1);
        long numb2 = ipToLong(address2);
        if (numb1 == numb2) {
            System.out.println("2 адреса равны: " + address1);
        } else if (numb2 > numb1) {
            for (long i = numb1 + 1; i < numb2; i++) {
                System.out.println(longToIp(i));
            }
        } else if (numb2 < numb1) {
            for (long i = numb2 + 1; i < numb1; i++) {
                System.out.println(longToIp(i));
            }
        }
    }

    static long ipToLong(String ipAddress) {

        String[] ipAddressToArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressToArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressToArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    static String longToIp(long ip) {
        return ((ip >> 24) & 0xFF) + "."
                + ((ip >> 16) & 0xFF) + "."
                + ((ip >> 8) & 0xFF) + "."
                + (ip & 0xFF);
    }
}
