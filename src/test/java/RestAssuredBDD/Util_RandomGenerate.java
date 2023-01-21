package RestAssuredBDD;

import org.apache.commons.lang3.RandomStringUtils;

public class Util_RandomGenerate {

    public static String getFirstName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("vikum"+generatedString);
    }

    public static String getLastName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Sugathadasa"+generatedString);
    }

    public static String getUsernameName(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("vk"+generatedString);
    }

    public static String getPassword(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("7vik3pavithra"+generatedString);
    }

    public static String getEmail(){
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return (generatedString+"@gmail.com");
    }
}
