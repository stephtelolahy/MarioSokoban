package com.telolahy.mariosokoban.scene;

import com.telolahy.mariosokoban.MainActivity;
import com.telolahy.mariosokoban.manager.ResourcesManager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by stephanohuguestelolahy on 11/15/14.
 */
public abstract class BaseScene extends Scene {

    protected ResourcesManager mResourcesManager;
    protected VertexBufferObjectManager mVertexBufferObjectManager;
    protected BoundCamera mCamera;
    protected MainActivity mActivity;

    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------

    public BaseScene(int... params) {

        mResourcesManager = ResourcesManager.getInstance();
        mVertexBufferObjectManager = ResourcesManager.getInstance().vertexBufferObjectManager;
        mCamera = ResourcesManager.getInstance().camera;
        mActivity = ResourcesManager.getInstance().activity;

        onCreateScene(params);
    }


    //---------------------------------------------
    // ABSTRACTION
    //---------------------------------------------

    protected abstract void onCreateScene(int... params);

    protected abstract void onDisposeScene();

    public abstract void onBackKeyPressed();


    // ===========================================================
    // METHODS
    // ===========================================================

    public void disposeScene() {

        Engine.EngineLock engineLock = mActivity.getEngine().getEngineLock();
        engineLock.lock();

        onDisposeScene();

        engineLock.unlock();

        this.detachSelf();
        this.dispose();
    }

}
