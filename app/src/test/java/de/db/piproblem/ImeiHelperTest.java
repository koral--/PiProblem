package de.db.piproblem;

import android.content.Context;
import android.telephony.TelephonyManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.db.piproblem.util.ImeiHelper;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

import static org.junit.Assert.assertEquals;

@RunWith(JMockit.class)
public class ImeiHelperTest {
    private final String defaultImei = "123456789012345";

    @Tested
    private ImeiHelper imeiHelper;

    @Mocked
    private TelephonyManager telephonyManager;

    @Mocked
    private Context context;

    @Test
    public void testGetIMEI() {

        new Expectations() {
            {
                context.getSystemService("phone");
                result = telephonyManager;

                telephonyManager.getDeviceId();
                result = defaultImei;
            }
        };

        final String imei = ImeiHelper.getIMEI(context);
        assertEquals(defaultImei, imei);
    }
}
