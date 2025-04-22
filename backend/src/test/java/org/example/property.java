package org.example;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class property {

    @Property
    public void testStringConcatenationLength(String a, String b) {
        assert (a + b).length() >= a.length();
    }

    @Property
    public void testIsValidPwdLengthAndUniqueness(@InRange(minInt = 100000, maxInt = 99999999) int pwd) {
        String s = String.valueOf(pwd);

        boolean allSame = s.chars().distinct().count() == 1;

        boolean expectedValid = s.length() >= 6 && !allSame;

        assertEquals(expectedValid, LoginController.isValidPwd(pwd));
    }

}
