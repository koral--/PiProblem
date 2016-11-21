package de.db.piproblem.util;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class ImeiHelper {

    private ImeiHelper() {
        //to keep access to class static
    }


    public static String getIMEI(final Context context) {
        final TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
}
