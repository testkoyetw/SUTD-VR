package org.gearvrf.sutdvr.components;

import org.gearvrf.sutdvr.R;
import org.gearvrf.sutdvr.focus.TouchAndGestureImpl;

import static org.gearvrf.sutdvr.SutdvrMain.ar_en_to_p1335;
import static org.gearvrf.sutdvr.SutdvrMain.ar_fountain_to_p1351;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1335_to_en;
import static org.gearvrf.sutdvr.SutdvrMain.ar_p1351_to_fountain;
import static org.gearvrf.sutdvr.SutdvrMain.loadTexture;
import static org.gearvrf.sutdvr.SutdvrMain.map;
import static org.gearvrf.sutdvr.SutdvrMain.p1351_to_fountain;
import static org.gearvrf.sutdvr.SutdvrMain.scene;
import static org.gearvrf.sutdvr.SutdvrMain.sphere;
import static org.gearvrf.sutdvr.SutdvrMain.text;
import static org.gearvrf.sutdvr.SutdvrMain.title;

public class Fountain {
    private int i_fountain;

    public Fountain(){

        createButtonSet(ar_p1351_to_fountain,ar_fountain_to_p1351);
    }



    private void createButtonSet(final NavigationButton b1, final NavigationButton b2){

        b1.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_fountain++;
                createButton(b1,b2);

            }
        });

        b2.setTouchAndGesturelistener(new TouchAndGestureImpl(){
            @Override
            public void singleTap() {
                super.singleTap();

                i_fountain--;
                createButton(b1,b2);

            }
        });

        scene.addSceneObject(b1);
        scene.addSceneObject(b2);
    }

    private void createButton(NavigationButton b1, NavigationButton b2){


                if (i_fountain == 0){
                    b2.removeButton();

                    sphere.getTransform().setRotationByAxis(110,0,1,0);
                    ar_p1335_to_en.moveButton(0.0f,0.1f,-1.0f);
                    ar_p1335_to_en.rotateButton(0,0,1,0);

                    ar_en_to_p1335.moveButton(-0.2f,0.14f,1.2f);
                    ar_en_to_p1335.rotateButton(180,0,1,0);

                    b1.moveButton(-0.9f,0.1f,-0.6f);
                    b1.rotateButton(80,0,1,0);

                    title.setDescription(R.string.gom_title);
                    title.moveDescription(0.5f,0.25f,1.2f);
                    title.rotateDescription(210,0,1,0);
                    title.showText();

                    text.setDescription(R.string.gom_text);
                    text.moveDescription(0.49f,0.15f,1.2f);
                    text.rotateDescription(210,0,1,0);
                    text.showText();

                    map.setMap(3);
                }
                else {
                    sphere.getTransform().setRotationByAxis(180,0,1,0);
                    b1.removeButton();
                    ar_p1335_to_en.removeButton();
                    ar_en_to_p1335.removeButton();

                    b2.moveButton(0.7f,0.1f,1.0f);
                    b2.rotateButton(190,0,1,0);

                    text.hideText();

                    title.setDescription(R.string.lt1_title);
                    title.moveDescription(1.3f,0.15f,1.0f);
                    title.rotateDescription(280,0,1,0);
                    title.getTransform().rotateByAxis(10,1,0,0);
                    title.showText();

                    map.setMap(6);
                }

                loadTexture(p1351_to_fountain, i_fountain);


    }
}
