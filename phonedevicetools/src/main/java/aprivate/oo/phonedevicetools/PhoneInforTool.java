package aprivate.oo.phonedevicetools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;

/**
 * Created by zhuxiaolong on 16/6/23.
 */
public class PhoneInforTool {

    private static PackageInfo packageInfo;
    private static ApplicationInfo applicationInfo;

    /**
     * 获取app 版本名
     * */
    public static String getAppVersionName(Context context) {
       return getPackageInfor(context).versionName;
    }

    /**
     * 获取app 版本号
     * */
    public static int getAppVersionCode(Context context) {
        return getPackageInfor(context).versionCode;
    }


    private static PackageInfo getPackageInfor(Context context){
        if(packageInfo==null) {
            PackageManager manager = context.getPackageManager();
            try {
                packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return packageInfo;
    }



    /**
     * 获取手机屏幕尺寸
     * */
    private static DisplayMetrics getDisplayMetrics(Context context){
        return  context.getResources().getDisplayMetrics();
    }

    public static int getPhoneScreenWidth(Context context){
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getPhoneScreenHeigh(Context context){
        return getDisplayMetrics(context).heightPixels;
    }


    public static float getPhoneScreenScaledDensity(Context context){
        return getDisplayMetrics(context).scaledDensity;
    }

    public static int getPhoneScreendensityDpi(Context context){
        return  getDisplayMetrics(context).densityDpi;
    }

    public static float getPhoneScreenDensity(Context context){
        return getDisplayMetrics(context).density;
    }

    public static float getPhoneTextWidthDpi(Context context){
        return getDisplayMetrics(context).xdpi;
    }

    public static float getPhoneTextHeighDpi(Context context){
        return getDisplayMetrics(context).ydpi;
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @param context
     *            （DisplayMetrics类中属性density）
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue
     * @param context
     *            （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = getDisplayMetrics(context).density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param context
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale =getDisplayMetrics(context).scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param context
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = getDisplayMetrics(context).scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }



}
