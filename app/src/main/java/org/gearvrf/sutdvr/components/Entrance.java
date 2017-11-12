package org.gearvrf.sutdvr.components;

import org.gearvrf.sutdvr.R;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;

import static org.gearvrf.sutdvr.SutdvrMain.ar_en_to_p1335;
import static org.gearvrf.sutdvr.SutdvrMain.ar_lib_to_p1335;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_en;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_lib;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1351_to_fountain;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1366_to_idc;
import static org.gearvrf.sutdvr.SutdvrMain.loadTexture;
import static org.gearvrf.sutdvr.SutdvrMain.map;
import static org.gearvrf.sutdvr.SutdvrMain.p1335_to_en;
import static org.gearvrf.sutdvr.SutdvrMain.scene;
import static org.gearvrf.sutdvr.SutdvrMain.sphere;
import static org.gearvrf.sutdvr.SutdvrMain.text;
import static org.gearvrf.sutdvr.SutdvrMain.title;

public class Entrance {

    private int i_en;

    public Entrance(){
        createButtonSet(ar_p1335_to_en,ar_en_to_p1335);
    }

    private void createButtonSet(final NavigationButton b1, final NavigationButton b2){

        b1.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_en++;
                createButton(b1,b2);

            }
        });

        b2.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_en--;
                createButton(b1,b2);

            }
        });

        scene.addSceneObject(b1);
        scene.addSceneObject(b2);
    }


    private void createButton(NavigationButton b1, NavigationButton b2){


        if (i_en == 0){

            sphere.getTransform().setRotationByAxis(260,0,1,0);
            ar_p1335_to_lib.moveButton(-1.2f, 0.2f, -0.3f);
            ar_p1335_to_lib.rotateButton(45,0,1,0);

            b1.moveButton(0.3f, 0.1f, -1.01f);
            b2.removeButton();

            map.setMap(0);
        }
        else if (i_en == 1){
            sphere.getTransform().setRotationByAxis(80,0,1,0);
            b1.moveButton(0.56f,0.2f,-1.0f);
            b1.rotateButton(340,0,1,0);

            ar_lib_to_p1335.removeButton();
            ar_p1335_to_lib.removeButton();

            b2.moveButton(-1.2f,0.15f,-0.2f);
            b2.rotateButton(90,0,1,0);

            map.setMap(0);
        }
        else if (i_en == 2){
            sphere.getTransform().setRotationByAxis(80,0,1,0);
            b1.moveButton(1.2f,0.16f,-0.7f); //taxi stand
            b1.rotateButton(270,0,1,0);

            b2.moveButton(-0.9f,0.16f,-0.1f);
            b2.rotateButton(90,0,1,0);
            ar_p1366_to_idc.removeButton();

            map.setMap(1);
        }
        else if (i_en == 3){
            sphere.getTransform().setRotationByAxis(340,0,1,0);
            b1.moveButton(0.7f,0.1f,-1.0f);
            b1.rotateButton(340,0,1,0);

            b2.moveButton(-1.1f,0.2f,0.2f);
            b2.rotateButton(100,0,1,0);

            ar_p1366_to_idc.moveButton(0.6f,0.15f,1.0f); //idc button
            ar_p1366_to_idc.rotateButton(190,0,1,0);

            map.setMap(2);
        }
        else if (i_en == 4){
            sphere.getTransform().setRotationByAxis(230,0,1,0); //wooden path
            b1.moveButton(0.85f,0.15f,-0.4f);
            b1.rotateButton(270,0,1,0);

            b2.moveButton(-0.9f,0.15f,0.4f);
            b2.rotateButton(100,0,1,0);

            ar_p1351_to_fountain.removeButton();
            ar_p1366_to_idc.removeButton();

            map.setMap(2);
        }
        else if (i_en == 5){
            sphere.getTransform().setRotationByAxis(110,0,1,0);
            b1.moveButton(0.0f,0.1f,-1.0f);
            b1.rotateButton(0,0,1,0);

            b2.moveButton(-0.2f,0.14f,1.2f);
            b2.rotateButton(180,0,1,0);

            ar_p1351_to_fountain.moveButton(-0.9f,0.1f,-0.6f);
            ar_p1351_to_fountain.rotateButton(80,0,1,0);

            map.setMap(3);
        }
        else if (i_en == 6){
            sphere.getTransform().setRotationByAxis(100,0,1,0);//slope
            b1.moveButton(0.7f,0.2f,-0.60f);
            b1.rotateButton(290,0,1,0);

            b2.moveButton(-0.7f,0.04f,0.5f);
            b2.rotateButton(100,0,1,0);

            ar_p1351_to_fountain.removeButton();

            map.setMap(4);
        }
        else if (i_en == 7){
            sphere.getTransform().setRotationByAxis(90,0,1,0);
            b1.moveButton(0.6f,0.17f,-1.0f);
            b1.rotateButton(340,0,1,0);

            b2.moveButton(-1.2f,0.14f,-0.2f);
            b2.rotateButton(90,0,1,0);

            map.setMap(5);
        }
        else if (i_en == 8){
            sphere.getTransform().setRotationByAxis(0,0,1,0);
            b1.removeButton();

            b2.moveButton(-0.5f,0.17f, 0.8f);
            b2.rotateButton(170,0,1,0);

            map.setMap(5);
        }

        loadTexture(p1335_to_en, i_en);

        if (i_en == 5){
            title.setDescription(R.string.gom_title);
            title.moveDescription(0.5f,0.25f,1.2f);
            title.rotateDescription(210,0,1,0);
            title.showText();

            text.setDescription(R.string.gom_text);
            text.moveDescription(0.49f,0.15f,1.2f);
            text.rotateDescription(210,0,1,0);
            text.showText();

        }
        else if (i_en == 8){
            title.setDescription(R.string.upperchangi_title);
            title.moveDescription(0.9f,0.02f,-1.0f);
            title.rotateDescription(330,0,1,0);
            title.showText();

        }
        else {
            title.hideText();
            text.hideText();
        }




    }
}
