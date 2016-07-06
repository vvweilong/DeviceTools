package aprivate.oo.phonedevicetools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by zhuxiaolong on 16/7/6.
 */
public class BitmapTool {

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth() , v.getHeight(), Bitmap.Config.ARGB_8888);
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
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(left, 0, 0, null);
        canvas.drawBitmap(right, left.getWidth(), 0, null);
        return result;
    }
    public Bitmap addBitmapVertical(Bitmap top, Bitmap bottom) {
        int width =top.getHeight() + bottom.getHeight();
        int height = Math.max(top.getWidth(), bottom.getWidth());
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(top, 0, 0, null);
        canvas.drawBitmap(bottom, 0, top.getHeight(), null);
        return result;
    }



}
