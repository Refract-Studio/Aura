package aura.entity;

class Player {
    int moveSpeed;
    boolean isColliding;
    int stamina;
    boolean isClimbing;
    boolean isWalking;
    boolean isRunning;
    Class<? extends EntityCollidable> collidingWith;
    int x, y;
    int blueberries;
}
