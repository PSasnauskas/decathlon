package com.swedbank.decathlon.domain;

public enum DecathlonPointsTable {
    M100(25.4347, 18, 1.81) {
        @Override
        public int calculateEventScore(double result) {
            return calculateRunScore(result);
        }
    },
    LONG_JUMP(0.14354, 220, 1.4) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    SHOT_PUT(51.39, 1.5, 1.05) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    HIGH_JUMP(0.8465, 75, 1.42) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    M400(1.53775, 82, 1.81) {
        @Override
        public int calculateEventScore(double result) {
            return calculateRunScore(result);
        }
    },
    M110(5.74352, 28.5, 1.92) {
        @Override
        public int calculateEventScore(double result) {
            return calculateRunScore(result);
        }
    },
    DISCUS_THROW(12.91, 4, 1.1) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    POLE_VAULT(0.2797, 100, 1.35) {
        @Override
        public int calculateEventScore(double result) {
            return calculateJumpScore(result);
        }
    },
    JAVELIN_THROW(10.14, 7, 1.08) {
        @Override
        public int calculateEventScore(double result) {
            return calculateThrowScore(result);
        }
    },
    M1500(0.03768, 480, 1.85) {
        @Override
        public int calculateEventScore(double result) {
            return calculateRunScore(result);
        }
    };

    private static final int CM_IN_METER = 100;

    private final double a;
    private final double b;
    private final double c;

    DecathlonPointsTable(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public abstract int calculateEventScore(double result);

    int calculateRunScore(double result) {
        Double temp = a * Math.pow(b - result, c);
        return temp.intValue();
    }

    int calculateJumpScore(double result) {
        return calculateThrowScore(result * CM_IN_METER);
    }

    int calculateThrowScore(double result) {
        Double temp = a * Math.pow(result - b, c);
        return temp.intValue();
    }
}
