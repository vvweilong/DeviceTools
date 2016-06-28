package aprivate.oo.devicetools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import aprivate.oo.phonedevicetools.FileTool;
import aprivate.oo.phonedevicetools.PhoneInforTool;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextView= (TextView) findViewById(R.id.textview);
        initInfor();
    }


    private void initInfor(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(PhoneInforTool.getAppVersionCode(this)+"\n");
        stringBuilder.append(PhoneInforTool.getAppVersionName(this)+"\n");
        stringBuilder.append(PhoneInforTool.getPhoneScreenDensity(this)+"\n");
        stringBuilder.append(PhoneInforTool.getPhoneScreendensityDpi(this)+"\n");
        stringBuilder.append(PhoneInforTool.getPhoneScreenScaledDensity(this)+"\n");
        stringBuilder.append(PhoneInforTool.getPhoneScreenWidth(this)+"\n");
        stringBuilder.append(PhoneInforTool.getPhoneScreenHeigh(this)+"\n");
        stringBuilder.append("1dp ="+PhoneInforTool.dip2px(this,1)+"px \n");
        stringBuilder.append("1sp ="+PhoneInforTool.sp2px(this,1)+"px \n");
        stringBuilder.append("value dir ="+getResources().getString(R.string.valusename));


        mTextView.setText(stringBuilder.toString());
    }


    private void fileInfor(){
        try {
            FileTool.createFile("abc.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
