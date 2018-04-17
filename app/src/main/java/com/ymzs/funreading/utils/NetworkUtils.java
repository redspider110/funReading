package com.ymzs.funreading.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * NetworkUtils
 * <ul>
 * <strong>Attentions</strong>
 * <li>You should add <strong>android.permission.ACCESS_NETWORK_STATE</strong> in manifest, to get network status.</li>
 * </ul>
 *
 */
public final class NetworkUtils {

    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_DISCONNECT = "disconnect";

    // The absence of a connection type.
    public static final int TYPE_NONE  = -1;

    /**
     * Get network type
     *
     * @param context
     * @return
     */
    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        return networkInfo == null ? TYPE_NONE : networkInfo.getType();
    }

    /**
     * Get network type name
     *
     * @param context
     * @return
     */
    public static String getNetworkTypeName(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (manager == null || (networkInfo = manager.getActiveNetworkInfo()) == null) {
            return NETWORK_TYPE_DISCONNECT;
        }

        if (networkInfo.isConnected()) {
            String typeName = networkInfo.getTypeName();
            if ("WIFI".equalsIgnoreCase(typeName)) {
                return typeName;
            } else if ("MOBILE".equalsIgnoreCase(typeName)) {
                int type = networkInfo.getType();
                if(type == TYPE_NONE){
                    return NETWORK_TYPE_DISCONNECT;
                }

                switch (type) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                        return "GPRS";
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                        return "EDGE";
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                        return "UMTS";
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                        return "HSDPA";
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                        return "HSUPA";
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                        return "HSPA";
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                        return "CDMA";
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        return "CDMA - EvDo rev. 0";
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        return "CDMA - EvDo rev. A";
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        return "CDMA - EvDo rev. B";
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                        return "CDMA - 1xRTT";
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return "LTE";
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                        return "CDMA - eHRPD";
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        return "iDEN";
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        return "HSPA+";
                    case TelephonyManager.NETWORK_TYPE_GSM:
                        return "GSM";
                    case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
                        return "TD_SCDMA";
                    case TelephonyManager.NETWORK_TYPE_IWLAN:
                        return "IWLAN";
//            case TelephonyManager.NETWORK_TYPE_LTE_CA:
//                return "LTE_CA";
                    default:
                        return "UNKNOWN";
                }
            } else {
                return NETWORK_TYPE_UNKNOWN;
            }
        }
        return  NETWORK_TYPE_DISCONNECT;
    }

    /**
     * Whether is fast mobile network
     *
     * @param context
     * @return
     */
    private static boolean isFastMobileNetwork(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager == null) {
            return false;
        }

        switch (telephonyManager.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return false;
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return false;
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return false;
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return true;
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return true;
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return false;
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return true;
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return true;
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return true;
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return true;
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return true;
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return false;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return true;
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return false;
            default:
                return false;
        }
    }

    /**
     * is network available?
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            return null != info && info.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * is mobile network connected.
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            return (getNetworkType(context) == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    /**
     * is wifi connected.
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            return (getNetworkType(context) == ConnectivityManager.TYPE_WIFI);
        }
        return false;
    }
}
