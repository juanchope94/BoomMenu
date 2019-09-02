package com.juan.boommenu;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private boolean init=false;
    private BoomMenuButton boomMenuButton;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int [][] subButtonColors= new int[3][2];
        for(int i=0;i<3;i++)
        {

            subButtonColors[i][1]= ContextCompat.getColor(this,R.color.colorPrimary);
            subButtonColors[i][0]= Util.getInstance().getPressedColor(subButtonColors[i][1]);



        }

        new  BoomMenuButton.Builder().addSubButton(ContextCompat.getDrawable(this,R.drawable.circle_button), subButtonColors[0], "Menu Button")
             .addSubButton(ContextCompat.getDrawable(this,R.drawable.bar),subButtonColors[0],"Recurso de codigo")
             .addSubButton(ContextCompat.getDrawable(this,R.drawable.ham_button_ripple), subButtonColors[0],"Sigueme")
             .button(ButtonType.HAM)
             .boom(BoomType.PARABOLA)
             .place(PlaceType.HAM_3_1)
             .subButtonTextColor(ContextCompat.getColor(this,R.color.default_boom_button_color))
             .subButtonsShadow(Util.getInstance().dp2px(2),Util.getInstance().dp2px(2))
             .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                 @Override
                 public void onClick(int buttonIndex) {
                     switch (buttonIndex)
                     {

                         case 0:
                             Toast.makeText(MainActivity.this,"PRIMER BOTON",Toast.LENGTH_SHORT).show();
                         break;
                     }
                 }
             })
                .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                    @Override
                    public void onClick(int buttonIndex) {
                        switch (buttonIndex)
                        {

                            case 0:
                                Toast.makeText(MainActivity.this,"PRIMER BOTON",Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(MainActivity.this,"SEGUNDO BOTON",Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                Toast.makeText(MainActivity.this,"TERCER BOTON",Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                })
                .init(boomMenuButton);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boomMenuButton=findViewById(R.id.boom);
    }
}
