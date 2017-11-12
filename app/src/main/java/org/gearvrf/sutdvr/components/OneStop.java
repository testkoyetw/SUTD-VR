package org.gearvrf.sutdvr.components;

import org.gearvrf.sutdvr.R;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;

import static org.gearvrf.sutdvr.SutdvrMain.ar_idc_to_p1366;
import static org.gearvrf.sutdvr.SutdvrMain.ar_onestop_to_p1370;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1366_to_idc;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1370_to_onestop;
import static org.gearvrf.sutdvr.SutdvrMain.loadTexture;
import static org.gearvrf.sutdvr.SutdvrMain.p1370_to_onestop;
import static org.gearvrf.sutdvr.SutdvrMain.scene;
import static org.gearvrf.sutdvr.SutdvrMain.sphere;
import static org.gearvrf.sutdvr.SutdvrMain.title;

public class OneStop {
    int i_onestop;

    public OneStop(){
        createButtonSet(ar_p1370_to_onestop,ar_onestop_to_p1370);
    }

    private void createButtonSet(final NavigationButton b1, final NavigationButton b2){

        b1.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_onestop++;
                createButton(b1,b2);

            }
        });

        b2.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_onestop--;
                createButton(b1,b2);

            }
        });

        scene.addSceneObject(b1);
        scene.addSceneObject(b2);
    }

    private void createButton(NavigationButton b1, NavigationButton b2){


        if (i_onestop == 0){
            sphere.getTransform().setRotationByAxis(90,0,1,0);

            ar_p1366_to_idc.moveButton(0.3f,0.1f,1.0f);
            ar_p1366_to_idc.rotateButton(180,0,1,0);

            ar_idc_to_p1366.moveButton(-0.1f,0f,-1.0f);

            b1.moveButton(-1.1f,0.1f,0.5f);
            b1.rotateButton(100,0,1,0);

            b2.removeButton();

            title.setDescription(R.string.centre_title);
            title.moveDescription(0.1f,0.3f,1.0f);
            title.rotateDescription(210,0,1,0);
            title.showText();
        }
        else {
            b1.removeButton();

            b2.moveButton(0.5f,0,-1.0f);

            ar_p1366_to_idc.removeButton();
            ar_idc_to_p1366.removeButton();
            title.hideText();

        }

        loadTexture(p1370_to_onestop, i_onestop);


    }
}
