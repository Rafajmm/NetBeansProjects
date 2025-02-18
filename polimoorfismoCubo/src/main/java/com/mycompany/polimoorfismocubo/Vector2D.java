package com.mycompany.polimoorfismocubo;

public class Vector2D {
    private double x;
    private double y;
    
    Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    
    Vector2D add(Vector2D other){
        Vector2D suma;
        return suma=new Vector2D(this.x+other.x,this.y+other.y);
    }
    
    Vector2D substract(Vector2D other){
        Vector2D resta;
        return resta=new Vector2D(this.x-other.x, this.y-other.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
