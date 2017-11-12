package org.gearvrf.sutdvr.components;

import android.graphics.Color;
import android.view.Gravity;

import org.gearvrf.GVRContext;
import org.gearvrf.scene_objects.GVRTextViewSceneObject;
import org.gearvrf.sutdvr.R;

public class TextDescription extends GVRTextViewSceneObject{

    private GVRContext gvrContext;

    public TextDescription(GVRContext gvrContext) {
        super(gvrContext);
        this.gvrContext = gvrContext;
        setText(gvrContext.getContext().getString(R.string.sutd_text));
        setGravity(Gravity.LEFT);
        setTextColor(Color.WHITE);
        setTextSize(3);
        getTransform().setScale(0.3f, 0.3f, 1f);
        getRenderData().setRenderingOrder(100010);


    }

    public void showText() {
        getRenderData().getMaterial().setOpacity(1);
    }

    public void hideText() {
        getRenderData().getMaterial().setOpacity(0);
        getTransform().setPosition(0,0,-10);

    }

    public void setDescription(int id){
        String string = gvrContext.getContext().getString(id);
        setText(string);
    }

    public void moveDescription(float x, float y, float z){
        getTransform().setPosition(x, y, z);
    }

    public void rotateDescription(float degree, float x, float y, float z){
        getTransform().setRotationByAxis(degree,x,y,z);
    }
}
