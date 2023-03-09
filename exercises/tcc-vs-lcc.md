# TCC *vs* LCC

Explain under which circumstances *Tight Class Cohesion* (TCC) and *Loose Class Cohesion* (LCC) metrics produce the same value for a given Java class. Build an example of such as class and include the code below or find one example in an open-source project from Github and include the link to the class below. Could LCC be lower than TCC for any given class? Explain.

## Answer
HAMONO Hermine et ROY Raphaẽl
On a LCC et TCC égaux quand chaque parties indépendantes du graphe sont connexes.
On ne peut pas avoir TCC plus grand strictement que LCC car on a le nombre de connexions directes inferieur ou égal au nombre de connexions indirectes.
```
class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        if(this.y != 0){
          return this.x;
        }
    }

    public double getY() {
         if(this.x != 0){
          return this.y;
        }
    }

    public double dot(Point p) {
        return x*p.x + y*p.y;
    }

    public Point sub(Point p) {
        return new Point(x - p.x, y - p.y);
    }

```
