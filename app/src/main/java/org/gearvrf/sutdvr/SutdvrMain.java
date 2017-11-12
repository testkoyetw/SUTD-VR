package org.gearvrf.sutdvr;

import org.gearvrf.FutureWrapper;
import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRMaterial;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRTexture;
import org.gearvrf.sutdvr.components.Entrance;
import org.gearvrf.sutdvr.components.Idc;
import org.gearvrf.sutdvr.components.Lib;
import org.gearvrf.sutdvr.components.MiniMap;
import org.gearvrf.sutdvr.components.NavigationButton;
import org.gearvrf.sutdvr.components.OneStop;
import org.gearvrf.sutdvr.components.TextDescription;
import org.gearvrf.sutdvr.components.Fountain;
import org.gearvrf.sutdvr.focus.ControlSceneObjectBehavior;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;
import org.gearvrf.sutdvr.input.TouchPadInput;
import org.gearvrf.scene_objects.GVRSphereSceneObject;
import org.gearvrf.sutdvr.util.FPSCounter;
import org.gearvrf.sutdvr.util.GazeController;

public class SutdvrMain extends GVRMain {

    private static GVRContext mGVRContext;
    public static GVRScene scene;
    public static GVRSphereSceneObject sphere;
    public static MiniMap map;
    public static TextDescription text;
    public static TextDescription title;

    private GVRTexture mapText;

    /* home page */
    private GVRSceneObject home;
    private NavigationButton zero;

    /* buttons */
    public static NavigationButton ar_p1335_to_lib;
    public static NavigationButton ar_lib_to_p1335;

    public static NavigationButton ar_p1335_to_en;
    public static NavigationButton ar_en_to_p1335;

    public static NavigationButton ar_p1366_to_idc;
    public static NavigationButton ar_idc_to_p1366;

    public static NavigationButton ar_p1370_to_onestop;
    public static NavigationButton ar_onestop_to_p1370;

    public static NavigationButton ar_p1351_to_fountain;
    public static NavigationButton ar_fountain_to_p1351;

    /* sphere texture */
    private static GVRTexture texture;

    /* level one routes */
    public static int[] p1335_to_en = new int[] { R.raw.p1335,
            R.raw.p1339, R.raw.p1338, R.raw.p1366,
            R.raw.p1365, R.raw.p1351, R.raw.p1357,
            R.raw.p1356, R.raw.p1355};
    public static int[] p1335_to_lib = new int[] { R.raw.p1335,R.raw.p1336,
            R.raw.p1337, R.raw.p1340, R.raw.p1341,
            R.raw.p1342, R.raw.p1348};
    public static int[] p1351_to_fountain = new int[] { R.raw.p1351, R.raw.p1353, R.raw.p1354 };
    public static int[] p1366_to_idc = new int[] { R.raw.p1366,R.raw.p1370, R.raw.p1372 };
    public static int[] p1370_to_onestop = new int[] { R.raw.p1370,R.raw.p1371 };

    public SutdvrMain() {
    }

    @Override
    public void onInit(GVRContext gvrContext) {

        mGVRContext = gvrContext;
        scene = gvrContext.getMainScene();

        createHome();
        createTitle();
        createDescription();
        createGazeCursor();
        createSphere();

    }

    public static void loadTexture(int[] route, int i){

        texture = mGVRContext.loadTexture(new GVRAndroidResource(mGVRContext, route[i]));
        sphere.getRenderData().getMaterial().setMainTexture(texture);
    }

    private void createDescription() {

        text = new TextDescription(mGVRContext);
        text.setDescription(R.string.sutd_text);
        text.moveDescription(0.18f,-0.2f,-0.9f);
        scene.addSceneObject(text);
    }

    private void createTitle(){
        title = new TextDescription(mGVRContext);
        title.setTextSize(5);
        scene.addSceneObject(title);
        title.hideText();
    }

    private void createMiniMap(){
        mapText= mGVRContext.loadTexture(new GVRAndroidResource(mGVRContext, R.drawable.m_main));
        map = new MiniMap(mGVRContext,0.25f,0.25f,mapText);
        scene.getMainCameraRig().addChildObject(map);
    }

    private void createHome(){
        home = new GVRSceneObject(mGVRContext, new FutureWrapper<>(mGVRContext.createQuad(1f, 0.39f)), mGVRContext.loadFutureTexture(new GVRAndroidResource(mGVRContext, R.drawable.sutd_logo)));
        home.getTransform().setPosition(0f, 0.4f, -1.3f);
        home.getRenderData().setDepthTest(false);
        home.getRenderData().setRenderingOrder(100000);
        scene.addSceneObject(home);

        zero = new NavigationButton(mGVRContext);
        zero.getTransform().setPosition(0f,0f,-1.0f);
        zero.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                createMiniMap();

                ar_p1335_to_lib = new NavigationButton(mGVRContext);
                ar_p1335_to_lib.getTransform().setPosition(-1.2f, 0.2f, -0.3f);
                ar_p1335_to_lib.rotateButton(45,0,1,0);
                ar_lib_to_p1335 = new NavigationButton(mGVRContext);
                ar_lib_to_p1335.removeButton();

                ar_p1335_to_en = new NavigationButton(mGVRContext);
                ar_p1335_to_en.getTransform().setPosition(0.3f, 0.1f, -1.01f);
                ar_en_to_p1335 = new NavigationButton(mGVRContext);
                ar_en_to_p1335.removeButton();

                ar_p1351_to_fountain = new NavigationButton(mGVRContext);
                ar_p1351_to_fountain.removeButton();

                ar_fountain_to_p1351 = new NavigationButton(mGVRContext);
                ar_fountain_to_p1351.removeButton();

                ar_p1366_to_idc = new NavigationButton(mGVRContext);
                ar_p1366_to_idc.removeButton();

                ar_idc_to_p1366 = new NavigationButton(mGVRContext);
                ar_idc_to_p1366.removeButton();

                ar_p1370_to_onestop = new NavigationButton(mGVRContext);
                ar_p1370_to_onestop.removeButton();

                ar_onestop_to_p1370 = new NavigationButton(mGVRContext);
                ar_onestop_to_p1370.removeButton();

                new Fountain();
                new Lib();
                new Entrance();
                new Idc();
                new OneStop();

                text.hideText();
                zero.removeButton();
                home.getTransform().setPosition(0f, 10f, 15f);
                home.getRenderData().getMaterial().setOpacity(0);
            }
        });
        scene.addSceneObject(zero);
    }

    private void createSphere(){

        GVRMaterial material = new GVRMaterial(mGVRContext);
        material.setMainTexture(mGVRContext.loadTexture(new GVRAndroidResource(
                mGVRContext, R.raw.p1335)));
        sphere = new GVRSphereSceneObject(mGVRContext,72, 144, false,material);
        sphere.getTransform().setRotationByAxis(260,0,1,0);
        sphere.getTransform().setScale(2f,2f,2f);
        scene.addSceneObject(sphere);


    }

    private void createGazeCursor() {
        GazeController.setupGazeCursor(mGVRContext);

    }

 @Override
    public void onStep() { FPSCounter.tick();

     TouchPadInput.process();

     ControlSceneObjectBehavior.process(mGVRContext);

     float[] lookAt = mGVRContext.getMainScene().getMainCameraRig().getLookAt();

     double degree = Math.atan2(lookAt[0], -lookAt[2]) * 180.0 / Math.PI;
     if (degree < 0) {
         degree += 360.0;
    }

     float sds = Math.round(degree);
     map.getTransform().setRotationByAxis(sds,0,0,1);

  }
}