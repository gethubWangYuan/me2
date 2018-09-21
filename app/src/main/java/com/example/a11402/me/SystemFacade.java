package com.example.a11402.me;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import java.io.File;

/*
 * created by taofu on 2018/8/29
 **/
public class SystemFacade {


    public static boolean hasIcecreamSandwichMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    public static boolean hasJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean hasM() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static boolean hasN() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }

    public static int getDensityDpi(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.densityDpi;
    }


    public static File getExternalCacheDir(Context context){
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File cacheDir = context.getExternalCacheDir();
            return cacheDir;
        }

        return null;
    }


    public static boolean hasPermission(Context context, String...permissions){
        if(context == null)
            throw new NullPointerException("context is null");

        for(String permission : permissions){
            if(ContextCompat.checkSelfPermission(context,permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /*
        获取状态栏的高度
     */
    public static int getStatusBarHeight(Activity activity) {
        int statusHeight = 0;
        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight){
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
                statusHeight = activity.getResources().getDimensionPixelSize(i5);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return statusHeight;
    }
}