package com.hackerrank.test.alation;

import java.util.Arrays;
import java.util.List;

public class ParticleCollution {

    public static void main(String[] args) {

        collision(Arrays.asList(1,2,3), 1);
    }

    // Complete the collision function below.
    static int collision(List<Integer> speed, int pos) {
        int noOfCollision = 0;
        for (int i = 0; i < pos; i++) {
            if (speed.get(i) >= (speed.get(pos) + (pos - i)))
                noOfCollision++;
        }

        for (int i = pos + 1; i < speed.size(); i++) {
            if ((speed.get(i) + (i - pos)) <= speed.get(pos))
                noOfCollision++;
        }
        return noOfCollision;
    }
}
