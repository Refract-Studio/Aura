package aura.entity;

class Player {
    private int moveSpeed;
    private boolean isColliding;
    private int stamina;
    private boolean isClimbing;
    private boolean isWalking;
    private boolean isRunning;
    private Class<? extends EntityCollidable> collidingWith;
    private float x, y;
    private int blueberries;
    public void onUpdate(){
        if(isClimbing){
            y += 5;
        }
        if(isWalking && !isRunning){
            x += 2.5f;
        }else if(isRunning && !isWalking){
            x += 5f;
        }
    }
    public void onRender(){

    }
    public void onKeypress(){

    }
    public void onMouseclick(){

    }
}
