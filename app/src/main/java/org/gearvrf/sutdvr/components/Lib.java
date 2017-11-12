package org.gearvrf.sutdvr.components;

import org.gearvrf.GVRContext;
import org.gearvrf.sutdvr.R;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;

import static org.gearvrf.sutdvr.SutdvrMain.ar_lib_to_p1335;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_en;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_lib;
import static org.gearvrf.sutdvr.SutdvrMain.map;
import static org.gearvrf.sutdvr.SutdvrMain.p1335_to_lib;
import static org.gearvrf.sutdvr.SutdvrMain.scene;
import static org.gearvrf.sutdvr.SutdvrMain.sphere;
import static org.gearvrf.sutdvr.SutdvrMain.text;
import static org.gearvrf.sutdvr.SutdvrMain.title;
import static org.gearvrf.sutdvr.SutdvrMain.loadTexture;

public class Lib {

    private int i_lib;

    public Lib(){

        createButtonSet(ar_p1335_to_lib,ar_lib_to_p1335);
    }



    private void createButtonSet(final NavigationButton b1, final NavigationButton b2){

        b1.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_lib++;
                createButton(b1,b2);

            }
        });

        b2.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_lib--;
                createButton(b1,b2);

            }
        });

        scene.addSceneObject(b1);
        scene.addSceneObject(b2);
    }

    private void createButton(NavigationButton b1, NavigationButton b2){


        if (i_lib == 0){
            b2.removeButton();

            sphere.getTransform().setRotationByAxis(260,0,1,0);

            ar_p1335_to_en.moveButton(0.3f, 0.1f, -1.01f);

            b1.moveButton(-1.2f, 0.2f, -0.3f);
            b1.rotateButton(45,0,1,0);

            map.setMap(0);
        }
        else if (i_lib == 1){
            sphere.getTransform().setRotationByAxis(90+180+30,0,1,0);
            b1.moveButton(0.3f, 0.2f, -1.0f);

            b1.moveButton(1.6f, 0.2f, -0.2f);
            b1.rotateButton(275,0,1,0);

            b2.moveButton(0.3f, 0.1f, 1.0f);
            b2.rotateButton(180,0,1,0);

            ar_p1335_to_en.removeButton();

            map.setMap(9);
        }
        else if (i_lib == 2){
            sphere.getTransform().setRotationByAxis(200-180-30,0,1,0);
            b1.moveButton(1.6f, 0.14f, -0.2f);
            b1.rotateButton(275,0,1,0);

            b2.moveButton(0f, 0f, -1.2f);
            b2.rotateButton(0,0,1,0);
        }
        else if (i_lib == 3){
            sphere.getTransform().setRotationByAxis(340-180,0,1,0);
            b1.moveButton(1.6f, 0.2f, -0.2f);
            b1.rotateButton(275,0,1,0);

            b2.moveButton(-0.8f, 0.15f, 0.2f);
            b2.rotateButton(70,0,1,0);
        }
        else if (i_lib == 4){
            sphere.getTransform().setRotationByAxis(310-180+30+30,0,1,0);
            b1.moveButton(0.2f, 0.2f, -1.2f);
            b1.rotateButton(0,0,1,0);

            b2.moveButton(-1.2f, 0.2f, 0.2f);
            b2.rotateButton(90,0,1,0);
        }
        else if (i_lib == 5){
            sphere.getTransform().setRotationByAxis(300-180,0,1,0);
            b1.moveButton(1.6f, 0.2f, -0.2f);
            b1.rotateButton(275,0,1,0);

            b2.moveButton(1.0f, 0.1f, 1.3f);
            b2.rotateButton(235,0,1,0);
        }
        else if (i_lib == 6){
            sphere.getTransform().setRotationByAxis(40+180,0,1,0);

            b1.removeButton();
            b2.moveButton(-1.3f, 0.1f, 0.2f);
            b2.rotateButton(90,0,1,0);

        }
        loadTexture(p1335_to_lib, i_lib);

        if (i_lib ==3){

            title.setDescription(R.string.lib_title);
            title.moveDescription(0.9f, 0.4f, -0.5f);
            title.rotateDescription(310,0,1,0);
            title.showText();

            text.setDescription(R.string.lib_text);
            text.moveDescription(0.89f, 0.3f, -0.5f);
            text.rotateDescription(310,0,1,0);
            text.showText();

        }
        else {
            title.hideText();
            text.hideText();
        }




    }
}

