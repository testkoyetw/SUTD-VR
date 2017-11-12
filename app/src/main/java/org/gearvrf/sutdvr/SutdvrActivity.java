package org.gearvrf.sutdvr;

import android.os.Bundle;
import android.view.MotionEvent;

import org.gearvrf.GVRActivity;
import org.gearvrf.sutdvr.focus.VRSamplesTouchPadGesturesDetector;
import org.gearvrf.sutdvr.input.TouchPadInput;
import org.gearvrf.sutdvr.focus.VRSamplesTouchPadGesturesDetector.SwipeDirection;

public class SutdvrActivity extends GVRActivity implements
        VRSamplesTouchPadGesturesDetector.OnTouchPadGestureListener {

    private VRSamplesTouchPadGesturesDetector mDetector = null;
   private SutdvrMain main;

    private static final int TAP_INTERVAL = 300;
    private long mLatestTap = 0;


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        main = new SutdvrMain();
        setMain(main, "gvr.xml");
        mDetector = new VRSamplesTouchPadGesturesDetector(this, this);
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        main.onTouchEvent(event);
        return super.onTouchEvent(event);
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mDetector == null) {
            return false;
        }
        TouchPadInput.input(event);
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTap(MotionEvent e) {
        if (System.currentTimeMillis() > mLatestTap + TAP_INTERVAL) {
            mLatestTap = System.currentTimeMillis();
            TouchPadInput.onSingleTap();
        }

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        TouchPadInput.onLongPress();
    }

    @Override
    public boolean onSwipe(MotionEvent e, SwipeDirection swipeDirection, float velocityX,
                           float velocityY) {
        TouchPadInput.onSwipe(swipeDirection);

        return false;
    }

    @Override
    public void onSwiping(MotionEvent e, MotionEvent e2, float velocityX, float velocityY,
                          SwipeDirection swipeDirection) {
    }

    @Override
    public void onSwipeOppositeLastDirection() {
    }
}
