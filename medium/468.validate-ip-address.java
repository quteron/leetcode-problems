class Solution {
    public String validIPAddress(String s) {
        if (isValidIPv4(s)) {
            return "IPv4";
        }

        if (isValidIPv6(s)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidIPv4(String s) {
        String[] parts = s.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            if (part.length() < 1 || part.length() > 3) {
                return false;
            }

            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }

            Integer number;
            try {
                number = Integer.valueOf(part);
            } catch (NumberFormatException e) {
                return false;
            }

            if (number == null || number > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidIPv6(String s) {
        String[] parts = s.split(":", -1);
        if (parts.length != 8) {
            return false;
        }

        for (String part : parts) {
            if (part.length() < 1 || part.length() > 4) {
                return false;
            }

            Integer number;
            try {
                number = Integer.valueOf(part, 16);
            } catch (NumberFormatException e) {
                return false;
            }
            if (number == null || number > 65535) {
                return false;
            }
        }

        return true;
    }
}
