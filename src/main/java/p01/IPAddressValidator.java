package p01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPAddressValidator {
    private Pattern pattern;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    IPAddressValidator() {
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    boolean validate(String ip) {
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
