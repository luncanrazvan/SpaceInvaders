package com.example.spaceinvaders;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.graphics.Rect;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int screenWidth;
    private int screenHeight;

    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    private ImageView spaceship;

    private ImageView bullet;

    private ImageView bulletMonster;
    private ImageView bulletMonster1;
    private ImageView bulletMonster2;
    private ImageView bulletMonster3;
    private ImageView bulletMonster4;
    private ImageView bulletMonster5;
    private ImageView bulletMonster6;
    private ImageView bulletMonster7;
    private ImageView bulletMonster8;

    private Button leftButton;
    private Button rightButton;
    private Button fireButton;

    private boolean moveBulletWithSpaceship=true;
    private boolean ableToFire=true;
    private boolean repeat=true;
    private boolean ableToAttack=true;
    private boolean ableToAttack1=true;
    private boolean ableToAttack2=true;
    private boolean ableToAttack3=true;
    private boolean ableToAttack4=true;
    private boolean ableToAttack5=true;
    private boolean ableToAttack6=true;
    private boolean ableToAttack7=true;
    private boolean ableToAttack8=true;
    private boolean firing=false;
    private boolean firing1=false;
    private boolean firing2=false;
    private boolean firing3=false;
    private boolean firing4=false;
    private boolean firing5=false;
    private boolean firing6=false;
    private boolean firing7=false;
    private boolean firing8=false;

    private float imageX;
    private float imageY;

    private float imageX1;
    private float imageY1;

    private float imageX2;
    private float imageY2;

    private float imageX3;
    private float imageY3;

    private float imageX4;
    private float imageY4;

    private float imageX5;
    private float imageY5;

    private float imageX6;
    private float imageY6;

    private float imageX7;
    private float imageY7;

    private float imageX8;
    private float imageY8;

    private float bmx0;
    private float bmy0;

    private float bmx1;
    private float bmy1;

    private float bmx2;
    private float bmy2;

    private float bmx3;
    private float bmy3;

    private float bmx4;
    private float bmy4;

    private float bmx5;
    private float bmy5;

    private float bmx6;
    private float bmy6;

    private float bmx7;
    private float bmy7;

    private float bmx8;
    private float bmy8;

    private float spX;
    private float spY;

    private float bulX;
    private float bulY;

    private int direction;

    private int monsterSpeed=500;

    private Handler handler=new Handler();
    private Handler handler1=new Handler();

    private Handler monster0=new Handler();
    private Timer timer0=new Timer();

    private Handler monster1=new Handler();
    private Timer timer1=new Timer();

    private Handler monster2=new Handler();
    private Timer timer2=new Timer();

    private Handler monster3=new Handler();
    private Timer timer3=new Timer();

    private Handler monster4=new Handler();
    private Timer timer4=new Timer();

    private Handler monster5=new Handler();
    private Timer timer5=new Timer();

    private Handler monster6=new Handler();
    private Timer timer6=new Timer();

    private Handler monster7=new Handler();
    private Timer timer7=new Timer();

    private Handler monster8=new Handler();
    private Timer timer8=new Timer();


    private int[] timeStamps=new int[]{5000,10000,15000,20000,25000,30000,35000,40000,45000};
    private int[] timeForFire=new int[9];
    private int counter=0;

    private TextView gameStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        float doi=2;

        super.onCreate(savedInstanceState);
        firingTiming();
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        spaceship=findViewById(R.id.spaceship);
        bullet=findViewById(R.id.bullet);

        gameStatus=findViewById(R.id.gameStatus);
        gameStatus.setVisibility(View.INVISIBLE);

        bulletMonster=findViewById(R.id.bulletMonster0);
        bulletMonster1=findViewById(R.id.bulletMonster1);
        bulletMonster2=findViewById(R.id.bulletMonster2);
        bulletMonster3=findViewById(R.id.bulletMonster3);
        bulletMonster4=findViewById(R.id.bulletMonster4);
        bulletMonster5=findViewById(R.id.bulletMonster5);
        bulletMonster6=findViewById(R.id.bulletMonster6);
        bulletMonster7=findViewById(R.id.bulletMonster7);
        bulletMonster8=findViewById(R.id.bulletMonster8);


        leftButton=findViewById(R.id.btnLeft);
        rightButton=findViewById(R.id.btnRight);
        fireButton=findViewById(R.id.btnFire);

        bmx0=0;
        bmy0=0;
        bulletMonster.setX(bmx0);
        bulletMonster.setY(bmy0);

        bmx1=0;
        bmy1=0;
        bulletMonster1.setX(bmx1);
        bulletMonster1.setY(bmy1);

        bmx2=0;
        bmy2=0;
        bulletMonster2.setX(bmx2);
        bulletMonster2.setY(bmy2);

        bmx3=0;
        bmy3=0;
        bulletMonster3.setX(bmx3);
        bulletMonster3.setY(bmy3);

        bmx4=0;
        bmy4=0;
        bulletMonster4.setX(bmx4);
        bulletMonster4.setY(bmy4);

        bmx5=0;
        bmy5=0;
        bulletMonster5.setX(bmx5);
        bulletMonster5.setY(bmy5);

        bmx6=0;
        bmy6=0;
        bulletMonster6.setX(bmx6);
        bulletMonster6.setY(bmy6);

        bmx7=0;
        bmy7=0;
        bulletMonster7.setX(bmx7);
        bulletMonster7.setY(bmy7);

        bmx8=0;
        bmy8=0;
        bulletMonster8.setX(bmx8);
        bulletMonster8.setY(bmy8);

        imageX=0;
        imageY=0;

        imageX1=300;
        imageY1=0;

        imageX2=600;
        imageY2=0;

        imageX3=0;
        imageY3=300;

        imageX4=300;
        imageY4=300;

        imageX5=600;
        imageY5=300;

        imageX6=0;
        imageY6=600;

        imageX7=300;
        imageY7=600;

        imageX8=600;
        imageY8=600;


        spY=screenHeight-30;


        spaceship.setX(screenWidth/doi);
        spaceship.setY(spY);

        bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
        bullet.setX(bulX);
        bulY=1700;
        bullet.setY(bulY);
        bullet.setVisibility(View.INVISIBLE);

        WindowManager wm=getWindowManager();
        Display display=wm.getDefaultDisplay();
        final Point size=new Point();
        display.getSize(size);
        screenWidth=size.x;
        screenHeight=size.y;

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float doi=2;
                if(spX>0){
                    spX-=20;
                    spaceship.setX(spX);
                    if(moveBulletWithSpaceship){
                        bulX=spaceship.getX()+spaceship.getWidth()/doi;
                        bullet.setX(bulX);
                    }

                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spX<screenWidth){
                    spX+=20;
                    spaceship.setX(spX);
                    if(moveBulletWithSpaceship){

                    }
                }
            }
        });

        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float doi=2;
                if(ableToFire){
                    repeat=true;
                    ableToFire=false;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bullet.setVisibility(View.VISIBLE);
                    moveBulletWithSpaceship=false;
                    mRunnable2.run();
                }
            }
        });
        bulletMonster.setVisibility(View.INVISIBLE);
        bulletMonster1.setVisibility(View.INVISIBLE);
        bulletMonster2.setVisibility(View.INVISIBLE);
        bulletMonster3.setVisibility(View.INVISIBLE);
        bulletMonster4.setVisibility(View.INVISIBLE);
        bulletMonster5.setVisibility(View.INVISIBLE);
        bulletMonster6.setVisibility(View.INVISIBLE);
        bulletMonster7.setVisibility(View.INVISIBLE);
        bulletMonster8.setVisibility(View.INVISIBLE);
        startRepeating();
        timer0.schedule(new TimerTask() {
            @Override
            public void run() {
                monster0.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack && imageView.getVisibility()==View.VISIBLE){
                            firing=true;
                            bulletMonster.setVisibility(View.VISIBLE);
                            if(collision(bulletMonster,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;

                            }
                        }
                        if(bmy0>=1900){
                            bulletMonster.setVisibility(View.GONE);
                            ableToAttack=false;
                        }
                        bmy0+=10;
                        bulletMonster.setY(bmy0);
                    }
                });
            }
        },timeForFire[0],20);

        timer8.schedule(new TimerTask() {
            @Override
            public void run() {
                monster8.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack8 && imageView8.getVisibility()==View.VISIBLE){
                            firing8=true;
                            bulletMonster8.setVisibility(View.VISIBLE);
                            if(collision(bulletMonster8,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster8.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy8>=1900){
                            bulletMonster8.setVisibility(View.GONE);
                            ableToAttack8=false;
                        }
                        bmy8+=10;
                        bulletMonster8.setY(bmy8);
                    }
                });
            }
        },timeForFire[8],20);

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                monster1.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack1 && imageView1.getVisibility()==View.VISIBLE){
                            firing1=true;
                            bulletMonster1.setVisibility(View.VISIBLE);

                            if(collision(bulletMonster1,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster1.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy1>=1900){
                            bulletMonster1.setVisibility(View.GONE);
                            ableToAttack1=false;
                        }
                        bmy1+=10;
                        bulletMonster1.setY(bmy1);
                    }
                });
            }
        },timeForFire[1],20);

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                monster2.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack2 && imageView2.getVisibility()==View.VISIBLE){
                            firing2=true;
                            bulletMonster2.setVisibility(View.VISIBLE);

                            if(collision(bulletMonster2,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster2.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }

                        }
                        if(bmy2>=1900){
                            bulletMonster2.setVisibility(View.GONE);
                            ableToAttack2=false;
                        }
                        bmy2+=10;
                        bulletMonster2.setY(bmy2);
                    }
                });
            }
        },timeForFire[2],20);

        timer3.schedule(new TimerTask() {
            @Override
            public void run() {
                monster3.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack3 && imageView3.getVisibility()==View.VISIBLE){
                            firing3=true;
                            bulletMonster3.setVisibility(View.VISIBLE);
                            if(collision(bulletMonster3,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster3.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy3>=1900){
                            bulletMonster3.setVisibility(View.GONE);
                            ableToAttack3=false;
                        }
                        bmy3+=10;
                        bulletMonster3.setY(bmy3);
                    }
                });
            }
        },timeForFire[3],20);

        timer4.schedule(new TimerTask() {
            @Override
            public void run() {
                monster4.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack4 && imageView4.getVisibility()==View.VISIBLE){
                            firing4=true;
                            bulletMonster4.setVisibility(View.VISIBLE);

                            if(collision(bulletMonster4,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster4.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy4>=1900){
                            bulletMonster4.setVisibility(View.GONE);
                            ableToAttack4=false;
                        }
                        bmy4+=10;
                        bulletMonster4.setY(bmy4);
                    }
                });
            }
        },timeForFire[4],20);

        timer5.schedule(new TimerTask() {
            @Override
            public void run() {
                monster5.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack5 && imageView5.getVisibility()==View.VISIBLE){
                            firing5=true;
                            bulletMonster5.setVisibility(View.VISIBLE);
                            if(collision(bulletMonster5,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster5.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy5>=1900){
                            bulletMonster5.setVisibility(View.GONE);
                            ableToAttack5=false;
                        }
                        bmy5+=10;
                        bulletMonster5.setY(bmy5);
                    }
                });
            }
        },timeForFire[5],20);

        timer6.schedule(new TimerTask() {
            @Override
            public void run() {
                monster6.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack6 && imageView6.getVisibility()==View.VISIBLE){
                            firing6=true;
                            bulletMonster6.setVisibility(View.VISIBLE);

                            if(collision(bulletMonster6,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster6.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy6>=1900){
                            bulletMonster6.setVisibility(View.GONE);
                            ableToAttack6=false;
                        }
                        bmy6+=10;
                        bulletMonster6.setY(bmy6);
                    }

                });
            }
        },timeForFire[6],20);

        timer7.schedule(new TimerTask() {
            @Override
            public void run() {
                monster7.post(new Runnable() {
                    @Override
                    public void run() {
                        if(ableToAttack7 && imageView7.getVisibility()==View.VISIBLE){
                            firing7=true;
                            bulletMonster7.setVisibility(View.VISIBLE);

                            if(collision(bulletMonster7,spaceship)){
                                gameStatus.setText("Game Over");
                                gameStatus.setVisibility(View.VISIBLE);
                                spaceship.setVisibility(View.GONE);
                                bulletMonster7.setVisibility(View.GONE);
                                fireButton.setEnabled(false);
                                leftButton.setEnabled(false);
                                rightButton.setEnabled(false);
                                ableToAttack=false;
                                imageView.setVisibility(View.GONE);
                                imageView1.setVisibility(View.GONE);
                                imageView2.setVisibility(View.GONE);
                                imageView3.setVisibility(View.GONE);
                                imageView4.setVisibility(View.GONE);
                                imageView5.setVisibility(View.GONE);
                                imageView6.setVisibility(View.GONE);
                                imageView7.setVisibility(View.GONE);
                                imageView8.setVisibility(View.GONE);
                                ableToAttack1=false;
                                ableToAttack2=false;
                                ableToAttack3=false;
                                ableToAttack4=false;
                                ableToAttack5=false;
                                ableToAttack6=false;
                                ableToAttack7=false;
                                ableToAttack8=false;
                            }
                        }
                        if(bmy7>=1900){
                            bulletMonster7.setVisibility(View.GONE);
                            ableToAttack7=false;
                        }
                        bmy7+=10;
                        bulletMonster7.setY(bmy7);
                    }
                });
            }
        },timeForFire[7],20);
    }

    public void firingTiming(){
        Random random=new Random();
        for(int i=0; i<9; i++){
            int x=random.nextInt(9);
            timeForFire[counter]=timeStamps[x];
            counter++;
        }
    }

    public void startRepeating(){
        mRunnable.run();
    }

    private Runnable mRunnable2=new Runnable() {
        @Override
        public void run() {
            if(repeat){
                bulY-=10;
                bullet.setY(bulY);
                if(collision(bullet,imageView) && imageView.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView1)&& imageView1.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView1.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView2)&& imageView2.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView2.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView3)&& imageView3.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView3.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView4)&& imageView4.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView4.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView5)&& imageView5.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView5.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView6)&& imageView6.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView6.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView7)&& imageView7.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView7.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(collision(bullet,imageView8)&& imageView8.getVisibility()==View.VISIBLE){
                    counter--;
                    monsterSpeed-=70;
                    if(counter==0){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        gameStatus.setText("You won!");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    imageView8.setVisibility(View.INVISIBLE);
                    ableToFire=true;
                    repeat=false;
                }
                if(bulY<=0){
                    float doi=2;
                    bulX=spaceship.getX()+spaceship.getWidth()/doi-20;
                    bullet.setX(bulX);
                    bulY=1700;
                    bullet.setY(bulY);
                    bullet.setVisibility(View.GONE);
                    ableToFire=true;
                    repeat=false;
                }
                handler1.removeCallbacksAndMessages(null);
                handler1.postDelayed(this,10);
            }

        }
    };

    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            float doi=2;
            if(direction==0){
                imageX+=30;
                imageX1+=30;
                imageX2+=30;
                imageX3+=30;
                imageX4+=30;
                imageX5+=30;
                imageX6+=30;
                imageX7+=30;
                imageX8+=30;
                if((screenWidth-imageX2<=imageView2.getWidth() && (imageView2.getVisibility()==View.VISIBLE || imageView5.getVisibility()==View.VISIBLE || imageView8.getVisibility()==View.VISIBLE))
                ||(screenWidth-imageX1<=imageView1.getWidth() && (imageView1.getVisibility()==View.VISIBLE || imageView4.getVisibility()==View.VISIBLE || imageView7.getVisibility()==View.VISIBLE)
                ||(screenWidth-imageX<=imageView.getWidth() && (imageView.getVisibility()==View.VISIBLE || imageView3.getVisibility()==View.VISIBLE || imageView6.getVisibility()==View.VISIBLE)
                        && (imageView2.getVisibility()==View.INVISIBLE || imageView5.getVisibility()==View.INVISIBLE || imageView8.getVisibility()==View.INVISIBLE)))){
                    direction=1;
                    imageY+=50;
                    imageY1+=50;
                    imageY2+=50;
                    imageY3+=50;
                    imageY4+=50;
                    imageY5+=50;
                    imageY6+=50;
                    imageY7+=50;
                    imageY8+=50;
                    if(imageY8>=1599){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView8.setVisibility(View.GONE);
                        gameStatus.setText("Game Over");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    imageView.setY(imageY);
                    imageView1.setY(imageY1);
                    imageView2.setY(imageY2);
                    imageView3.setY(imageY3);
                    imageView4.setY(imageY4);
                    imageView5.setY(imageY5);
                    imageView6.setY(imageY6);
                    imageView7.setY(imageY7);
                    imageView8.setY(imageY8);
                }
            }
            if(direction==1){
                imageX-=30;
                imageX1-=30;
                imageX2-=30;
                imageX3-=30;
                imageX4-=30;
                imageX5-=30;
                imageX6-=30;
                imageX7-=30;
                imageX8-=30;
                if((imageX<=0 && (imageView.getVisibility()==View.VISIBLE || imageView3.getVisibility()==View.VISIBLE || imageView6.getVisibility()==View.VISIBLE))
                        ||(imageX1<=0 && (imageView1.getVisibility()==View.VISIBLE || imageView4.getVisibility()==View.VISIBLE || imageView7.getVisibility()==View.VISIBLE)
                        ||(imageX2<=0 && (imageView2.getVisibility()==View.VISIBLE || imageView5.getVisibility()==View.VISIBLE || imageView8.getVisibility()==View.VISIBLE)
                        && (imageView1.getVisibility()==View.INVISIBLE || imageView4.getVisibility()==View.INVISIBLE || imageView7.getVisibility()==View.INVISIBLE)))){
                    direction=0;
                    imageY+=50;
                    imageY1+=50;
                    imageY2+=50;
                    imageY3+=50;
                    imageY4+=50;
                    imageY5+=50;
                    imageY6+=50;
                    imageY7+=50;
                    imageY8+=50;
                    if ((imageY2>=2000 &&(imageView2.getVisibility()==View.VISIBLE || imageView1.getVisibility()==View.VISIBLE || imageView.getVisibility()==View.VISIBLE) && (imageView8.getVisibility()==View.INVISIBLE || imageView7.getVisibility()==View.INVISIBLE || imageView6.getVisibility()==View.INVISIBLE) &&(imageView5.getVisibility()==View.INVISIBLE || imageView4.getVisibility()==View.INVISIBLE || imageView3.getVisibility()==View.INVISIBLE)) ||
                        (imageY5>=2000 &&(imageView5.getVisibility()==View.VISIBLE || imageView4.getVisibility()==View.VISIBLE || imageView3.getVisibility()==View.VISIBLE) && (imageView8.getVisibility()==View.INVISIBLE || imageView7.getVisibility()==View.INVISIBLE || imageView6.getVisibility()==View.INVISIBLE)) ||
                        (imageY8>=2000 &&(imageView8.getVisibility()==View.VISIBLE || imageView7.getVisibility()==View.VISIBLE || imageView6.getVisibility()==View.VISIBLE))){
                        fireButton.setEnabled(false);
                        leftButton.setEnabled(false);
                        rightButton.setEnabled(false);
                        imageView.setVisibility(View.GONE);
                        imageView1.setVisibility(View.GONE);
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.GONE);
                        imageView5.setVisibility(View.GONE);
                        imageView6.setVisibility(View.GONE);
                        imageView7.setVisibility(View.GONE);
                        imageView8.setVisibility(View.GONE);
                        gameStatus.setText("Game Over");
                        gameStatus.setVisibility(View.VISIBLE);
                    }
                    imageView.setY(imageY);
                    imageView1.setY(imageY1);
                    imageView2.setY(imageY2);
                    imageView3.setY(imageY3);
                    imageView4.setY(imageY4);
                    imageView5.setY(imageY5);
                    imageView6.setY(imageY6);
                    imageView7.setY(imageY7);
                    imageView8.setY(imageY8);
                }
            }
            imageView.setX(imageX);
            imageView1.setX(imageX1);
            imageView2.setX(imageX2);
            imageView3.setX(imageX3);
            imageView4.setX(imageX4);
            imageView5.setX(imageX5);
            imageView6.setX(imageX6);
            imageView7.setX(imageX7);
            imageView8.setX(imageX8);
            if(!firing){
                bmx0=imageX+imageView.getWidth()/doi-20;
                bmy0=imageY+30;
                bulletMonster.setX(bmx0);
                bulletMonster.setY(bmy0);
            }
            if(!firing1){
                bmx1=imageX1+imageView1.getWidth()/doi-20;
                bmy1=imageY1+30;
                bulletMonster1.setX(bmx1);
                bulletMonster1.setY(bmy1);
            }
            if(!firing2){
                bmx2=imageX2+imageView2.getWidth()/doi-20;
                bmy2=imageY2+30;
                bulletMonster2.setX(bmx2);
                bulletMonster2.setY(bmy2);
            }
            if(!firing3){
                bmx3=imageX3+imageView3.getWidth()/doi-20;
                bmy3=imageY3+30;
                bulletMonster3.setX(bmx3);
                bulletMonster3.setY(bmy3);
            }
            if(!firing4){
                bmx4=imageX4+imageView4.getWidth()/doi-20;
                bmy4=imageY4+30;
                bulletMonster4.setX(bmx4);
                bulletMonster4.setY(bmy4);
            }
            if(!firing5){
                bmx5=imageX5+imageView5.getWidth()/doi-20;
                bmy5=imageY5+30;
                bulletMonster5.setX(bmx5);
                bulletMonster5.setY(bmy5);
            }
            if(!firing6){
                bmx6=imageX6+imageView6.getWidth()/doi-20;
                bmy6=imageY6+30;
                bulletMonster6.setX(bmx6);
                bulletMonster6.setY(bmy6);
            }
            if(!firing7){
                bmx7=imageX7+imageView7.getWidth()/doi-20;
                bmy7=imageY7+30;
                bulletMonster7.setX(bmx7);
                bulletMonster7.setY(bmy7);
            }
            if(!firing8){
                bmx8=imageX8+imageView8.getWidth()/doi-20;
                bmy8=imageY8+30;
                bulletMonster8.setX(bmx8);
                bulletMonster8.setY(bmy8);
            }
            handler.postDelayed(this,monsterSpeed);
        }
    };

    public boolean collision(ImageView a, ImageView b){
        float bl=a.getY();
        float bt=a.getX();
        float br=a.getWidth()+bl;
        float bb=a.getHeight()+bt;
        float pl=b.getY();
        float pt=b.getX();
        float pr=b.getWidth()+pl;
        float pb=b.getHeight()+pt;
        if(bl<=pr && bl>=pl && bt>=pt && bt<=pb){
            return true;
        }else if(br>=pl && br<=pr && bb>=pt && bb<=pb){
            return true;
        }else if(bt<=pb && bt>=pt && br>=pl && br<=pr){
            return true;
        }else if(bb>=pt && bb<=pb && bl>=pl && bl<=pr){
            return true;
        }
        return false;
    }

}
