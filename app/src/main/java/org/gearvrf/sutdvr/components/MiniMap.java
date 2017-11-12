package org.gearvrf.sutdvr.components;

import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;
import org.gearvrf.sutdvr.R;

public class MiniMap extends GVRSceneObject{

    private int[] maps = new int[]{R.drawable.m_main,R.drawable.m_taxi,R.drawable.m_wood,R.drawable.m_bridge,R.drawable.m_slope,R.drawable.m_exit,
    R.drawable.m_lt1,R.drawable.m_c,R.drawable.m_idc,R.drawable.m_lib};

    private GVRContext gvrContext;
    private GVRTexture texture;

    public MiniMap(GVRContext gvrContext, float width, float height, GVRTexture texture) {
        super(gvrContext, width, height, texture);

        this.gvrContext = gvrContext;
        getRenderData().setDepthTest(false);
        getRenderData().setRenderingOrder(100000);
        getTransform().setPosition(0.09f, -0.088f, -0.99f);
    }

    public void setMap(int i){
        texture = gvrContext.loadTexture(new GVRAndroidResource(gvrContext, maps[i]));
        getRenderData().getMaterial().setMainTexture(texture);
    }
}
