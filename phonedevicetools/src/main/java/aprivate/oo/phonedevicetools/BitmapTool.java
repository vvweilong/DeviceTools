package aprivate.oo.phonedevicetools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.View;

/**
 * Created by zhuxiaolong on 16/7/6.
 */
public class BitmapTool {
/*
*
*根据路径 加载图片到 bitmap
* */
    public static Bitmap loadBitmap(String path) {
        if (null == path) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        //不对图进行压缩
        options.inSampleSize = 1;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            return bitmap;
        } catch (OutOfMemoryError e) {

        }
        return null;
    }

    // Rotates the bitmap by the specified degree.
    // If a new bitmap is created, the original bitmap is recycled.
    public static Bitmap rotate(Bitmap b, int degrees) {
        if (degrees != 0 && b != null) {
            Matrix m = new Matrix();
            m.setRotate(degrees);
            try {
                Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
                if (null != b2 && b != b2) {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex) {
                // We have no memory to rotate. Return the original bitmap.
            }
        }
        return b;
    }

    /*
    * 从资源文件获取 bitmap
    * */
    public static Bitmap loadBitmap(Context context, int resource) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resource);


        return bitmap;
    }




    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth() , v.getHeight(), Bitmap.Config.RGB_565);
        Canvas c = new Canvas(b);
        c.drawColor(Color.WHITE);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    public static Bitmap loadBitmapFromResourse(Context c,int rsid){
        Bitmap bitmap= BitmapFactory.decodeResource(c.getResources(),rsid);
        return bitmap;
    }

    public Bitmap addBitmapHorizontal(Bitmap left, Bitmap right) {
        int width =left.getWidth() + right.getWidth();
        int height = Math.max(left.getHeight(), right.getHeight());
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(left, 0, 0, null);
        canvas.drawBitmap(right, left.getWidth(), 0, null);
        return result;
    }
    public Bitmap addBitmapVertical(Bitmap top, Bitmap bottom) {
        int width =top.getHeight() + bottom.getHeight();
        int height = Math.max(top.getWidth(), bottom.getWidth());
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(top, 0, 0, null);
        canvas.drawBitmap(bottom, 0, top.getHeight(), null);
        return result;
    }



}
