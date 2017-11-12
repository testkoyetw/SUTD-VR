package org.gearvrf.sutdvr.components;

import org.gearvrf.sutdvr.R;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;

import static org.gearvrf.sutdvr.SutdvrMain.ar_en_to_p1335;
import static org.gearvrf.sutdvr.SutdvrMain.ar_idc_to_p1366;
import static org.gearvrf.sutdvr.SutdvrMain.ar_onestop_to_p1370;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_en;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1366_to_idc;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1370_to_onestop;
import static org.gearvrf.sutdvr.SutdvrMain.loadTexture;
import static org.gearvrf.sutdvr.SutdvrMain.map;
import static org.gearvrf.sutdvr.SutdvrMain.p1366_to_idc;
import static org.gearvrf.sutdvr.SutdvrMain.scene;
import static org.gearvrf.sutdvr.SutdvrMain.sphere;
import static org.gearvrf.sutdvr.SutdvrMain.text;
import static org.gearvrf.sutdvr.SutdvrMain.title;

public class Idc {
    int i_idc;
    public Idc(){

        createButtonSet(ar_p1366_to_idc,ar_idc_to_p1366);
    }



    private void createButtonSet(final NavigationButton b1, final NavigationButton b2){

        b1.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_idc++;
                createButton(b1,b2);

            }
        });

        b2.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_idc--;
                createButton(b1,b2);

            }
        });

        scene.addSceneObject(b1);
        scene.addSceneObject(b2);
    }

    private void createButton(NavigationButton b1, NavigationButton b2){


        if (i_idc == 0){
            sphere.getTransform().setRotationByAxis(340,0,1,0);
            b2.removeButton();

            b1.moveButton(0.6f,0.15f,1.0f);
            b1.rotateButton(190,0,1,0);

            ar_p1335_to_en.moveButton(0.7f,0.1f,-1.0f);
            ar_p1335_to_en.rotateButton(340,0,1,0);

            ar_en_to_p1335.moveButton(-1.1f,0.2f,0.2f);
            ar_en_to_p1335.rotateButton(100,0,1,0);

            ar_p1370_to_onestop.removeButton();
            ar_onestop_to_p1370.removeButton();

            map.setMap(2);
        }
        else if (i_idc == 1){
            sphere.getTransform().setRotationByAxis(90,0,1,0);

            b1.moveButton(0.3f,0.1f,1.0f);
            b1.rotateButton(180,0,1,0);

            b2.moveButton(-0.1f,0f,-1.0f);

            ar_p1335_to_en.removeButton();
            ar_en_to_p1335.removeButton();

            ar_p1370_to_onestop.moveButton(-1.1f,0.1f,0.5f);
            ar_p1370_to_onestop.rotateButton(100,0,1,0);

            map.setMap(7);
        }
        else if (i_idc == 2){
            sphere.getTransform().setRotationByAxis(45,0,1,0);

            b2.moveButton(-0.1f,0f,-1.0f);

            b1.removeButton();
            ar_p1370_to_onestop.removeButton();
            ar_onestop_to_p1370.removeButton();

            map.setMap(8);
        }

        if (i_idc == 2){
            title.setDescription(R.string.idc_title);
            title.moveDescription(-1.2f,0.25f,0.7f);
            title.rotateDescription(90,0,1,0);
            title.showText();

            text.setDescription(R.string.idc_text);
            text.moveDescription(-1.19f,0.1f,0.7f);
            text.rotateDescription(90,0,1,0);
            text.showText();

        }else if (i_idc == 1){
            title.setDescription(R.string.centre_title);
            title.moveDescription(0.1f,0.3f,1.0f);
            title.rotateDescription(210,0,1,0);

            title.showText();
            text.hideText();
        }
        else {
            title.hideText();
            text.hideText();
        }

        loadTexture(p1366_to_idc, i_idc);


    }
}
